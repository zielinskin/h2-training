package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.model.AttendingStudent;

@Component
class StudentClassEntityAttendingStudentConverter implements Converter<StudentClassEntity, AttendingStudent> {
    @Override
    public AttendingStudent convert(StudentClassEntity source) {
        return new AttendingStudent(source.getStudentEntity().getId(),
                source.getStudentEntity().getName());
    }
}
