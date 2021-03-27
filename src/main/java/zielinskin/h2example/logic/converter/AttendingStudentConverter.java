package zielinskin.h2example.logic.converter;

import org.springframework.stereotype.Component;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.model.AttendingStudent;

@Component
class AttendingStudentConverter implements RelatedChildConverter<ClassEntity, AttendingStudent, StudentClassEntity> {

    @Override
    public StudentClassEntity convert(ClassEntity classEntity, AttendingStudent source) {
        if(source.getId() == null) {
            throw new IllegalArgumentException("Attending students must be persisted first before being added to a class.");
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(source.getId());

        StudentClassEntity studentClassEntity = new StudentClassEntity();
        studentClassEntity.setClassEntity(classEntity);
        studentClassEntity.setStudentEntity(studentEntity);

        return studentClassEntity;
    }
}
