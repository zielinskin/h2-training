package zielinskin.h2example.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.data.ClassRepository;
import zielinskin.h2example.data.StudentClassEntity;
import zielinskin.h2example.model.AttendedClass;
import zielinskin.h2example.model.AttendingStudent;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class AttendedClassConverter implements Converter<AttendedClass, ClassEntity> {
    private final ClassRepository classRepository;
    private final RelatedChildConverter<ClassEntity, AttendingStudent, StudentClassEntity> attendingStudentConverter;

    public AttendedClassConverter(ClassRepository classRepository,
                                  RelatedChildConverter<ClassEntity, AttendingStudent, StudentClassEntity> attendingStudentConverter) {
        this.classRepository = classRepository;
        this.attendingStudentConverter = attendingStudentConverter;
    }

    @Override
    public ClassEntity convert(AttendedClass source) {
        ClassEntity entity = Optional.ofNullable(source.getId())
                .flatMap(classRepository::findById)
                .orElse(new ClassEntity());

        entity.setName(source.getName());

        Set<StudentClassEntity> attendees = source.getAttendees().stream()
                .map(attendee ->
                        attendingStudentConverter.convert(entity, attendee))
                .collect(Collectors.toSet());

        entity.getStudents().retainAll(attendees);
        entity.getStudents().addAll(attendees);

        return entity;
    }
}
