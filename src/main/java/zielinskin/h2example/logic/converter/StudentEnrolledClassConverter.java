package zielinskin.h2example.logic.converter;

import org.springframework.stereotype.Component;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.model.StudentEnrolledClass;

@Component
class StudentEnrolledClassConverter implements RelatedChildConverter<StudentEntity, StudentEnrolledClass, StudentClassEntity> {

    @Override
    public StudentClassEntity convert(StudentEntity parent, StudentEnrolledClass source) {
        if(source.getId() == null) {
            throw new IllegalArgumentException("Attending students must be persisted first before being added to a class.");
        }

        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(source.getId());

        StudentClassEntity studentClassEntity = new StudentClassEntity();
        studentClassEntity.setClassEntity(classEntity);
        studentClassEntity.setStudentEntity(parent);

        return studentClassEntity;
    }
}
