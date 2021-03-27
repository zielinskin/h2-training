package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.model.AttendedClass;
import zielinskin.h2example.model.AttendingStudent;

import java.util.stream.Collectors;

@Component
class ClassEntityConverter implements Converter<ClassEntity, AttendedClass> {
    private final Converter<StudentClassEntity, AttendingStudent> studentClassEntityAttendingStudentConverter;

    public ClassEntityConverter(Converter<StudentClassEntity, AttendingStudent> studentClassEntityAttendingStudentConverter) {
        this.studentClassEntityAttendingStudentConverter = studentClassEntityAttendingStudentConverter;
    }

    @Override
    public AttendedClass convert(ClassEntity source) {
        return new AttendedClass(source.getId(),
                source.getName(),
                source.getStudents().stream()
                        .map(studentClassEntityAttendingStudentConverter::convert)
                        .collect(Collectors.toList()));
    }
}
