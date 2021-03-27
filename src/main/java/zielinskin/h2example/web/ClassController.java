package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.logic.CrudService;
import zielinskin.h2example.model.AttendedClass;

import java.util.List;

@RestController
@RequestMapping("/classes")
class ClassController {
    private final CrudService<AttendedClass, ClassEntity, Integer> service;

    public ClassController(CrudService<AttendedClass, ClassEntity, Integer> service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody AttendedClass view) {
        service.save(view);
    }

    @GetMapping()
    public List<AttendedClass> get() {
        return service.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
