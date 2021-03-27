package zielinskin.h2example.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
    List<ClassEntity> findAll();
}
