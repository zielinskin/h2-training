package zielinskin.h2example.logic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.model.Student;

@Service
class StudentService extends CrudService<Student, StudentEntity, Integer> {
    public StudentService(CrudRepository<StudentEntity, Integer> repository,
                          Converter<Student, StudentEntity> viewConverter,
                          Converter<StudentEntity, Student> entityConverter) {
        super(repository, viewConverter, entityConverter);
    }
}
