package zielinskin.h2example.logic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zielinskin.h2example.data.ClassEntity;
import zielinskin.h2example.model.AttendedClass;

@Service
public class AttendedClassService extends CrudService<AttendedClass, ClassEntity, Integer> {
    public AttendedClassService(CrudRepository<ClassEntity, Integer> repository,
                                Converter<AttendedClass, ClassEntity> viewConverter,
                                Converter<ClassEntity, AttendedClass> entityConverter) {
        super(repository, viewConverter, entityConverter);
    }
}
