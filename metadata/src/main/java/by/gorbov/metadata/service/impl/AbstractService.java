package by.gorbov.metadata.service.impl;


import by.gorbov.metadata.dto.AbstractDto;
import by.gorbov.metadata.dto.mapper.api.Mapper;
import by.gorbov.metadata.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<D extends AbstractDto, E extends AbstractEntity> implements Service<D> {

    private final JpaRepository<E, Long> repository;
    private final Mapper<D, E> mapper;

    public AbstractService(JpaRepository<E, Long> repository, Mapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<D> getAll() {
        List<D> dtoList = new ArrayList<>();
        repository.findAll().forEach(e -> dtoList.add(mapper.toDto(e)));
        return dtoList;
    }

    @Override
    public D getById(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = SQLException.class)
    @Override
    public void delete(D dto) {
        repository.delete(mapper.toEntity(dto));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = SQLException.class)
    @Override
    public void save(D dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = SQLException.class)
    @Override
    public void update(D dto) {
        repository.save(mapper.toEntity(dto));
    }
}
