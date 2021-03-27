package zielinskin.h2example.logic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class CrudService<V, E, I> {
    private final CrudRepository<E, I> repository;
    private final Converter<V, E> viewConverter;
    private final Converter<E, V> entityConverter;

    public CrudService(CrudRepository<E, I> repository,
                       Converter<V, E> viewConverter,
                       Converter<E, V> entityConverter) {
        this.repository = repository;
        this.viewConverter = viewConverter;
        this.entityConverter = entityConverter;
    }

    public void delete(I id) {
        repository.deleteById(id);
    }

    public void save(V view) {
        repository.save(viewConverter.convert(view));
    }

    public List<V> get() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entityConverter::convert)
                .collect(Collectors.toList());
    }
}
