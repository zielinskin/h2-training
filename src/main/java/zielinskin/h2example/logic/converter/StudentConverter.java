package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.data.StudentRepository;
import zielinskin.h2example.model.Student;
import zielinskin.h2example.model.StudentEnrolledClass;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class StudentConverter implements Converter<Student, StudentEntity> {
    private final StudentRepository studentRepository;
    private final RelatedChildConverter<StudentEntity, StudentEnrolledClass, StudentClassEntity> studentEnrolledClassConverter;

    public StudentConverter(StudentRepository studentRepository,
                            RelatedChildConverter<StudentEntity, StudentEnrolledClass, StudentClassEntity> studentEnrolledClassConverter) {
        this.studentRepository = studentRepository;
        this.studentEnrolledClassConverter = studentEnrolledClassConverter;
    }

    @Override
    public StudentEntity convert(Student source) {
        StudentEntity entity = Optional.ofNullable(source.getId())
                .flatMap(studentRepository::findById)
                .orElse(new StudentEntity());

        entity.setName(source.getName());

        Set<StudentClassEntity> classes = source.getEnrolledClasses().stream()
                .map(studentEnrolledClass -> studentEnrolledClassConverter.convert(entity, studentEnrolledClass))
                .collect(Collectors.toSet());

        entity.getClasses().retainAll(classes);
        entity.getClasses().addAll(classes);

        return entity;
    }
}
