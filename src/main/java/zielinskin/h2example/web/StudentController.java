package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.logic.CrudService;
import zielinskin.h2example.model.Student;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController {
    private final CrudService<Student, StudentEntity, Integer> service;

    public StudentController(CrudService<Student, StudentEntity, Integer> service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Student studentEntity) {
        service.save(studentEntity);
    }

    @GetMapping()
    public List<Student> get() {
        return service.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
