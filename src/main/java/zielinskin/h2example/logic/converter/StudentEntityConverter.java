package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.model.Student;
import zielinskin.h2example.model.StudentEnrolledClass;

import java.util.stream.Collectors;

@Component
class StudentEntityConverter implements Converter<StudentEntity, Student> {
    private final Converter<StudentClassEntity, StudentEnrolledClass> studentEnrolledClassConverter;

    public StudentEntityConverter(Converter<StudentClassEntity, StudentEnrolledClass> studentEnrolledClassConverter) {
        this.studentEnrolledClassConverter = studentEnrolledClassConverter;
    }

    @Override
    public Student convert(StudentEntity source) {
        return new Student(source.getId(),
                source.getName(),
                source.getClasses().stream()
                        .map(studentEnrolledClassConverter::convert)
                        .collect(Collectors.toList()));
    }
}
