package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.model.StudentEnrolledClass;

@Component
class StudentClassEntityStudentEnrolledClassConverter implements Converter<StudentClassEntity, StudentEnrolledClass> {
    @Override
    public StudentEnrolledClass convert(StudentClassEntity source) {
        return new StudentEnrolledClass(source.getClassEntity().getId(),
                source.getClassEntity().getName());
    }
}
