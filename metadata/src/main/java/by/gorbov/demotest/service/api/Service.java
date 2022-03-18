package by.gorbov.demotest.service.api;

import by.gorbov.demotest.dto.AbstractDto;

import java.util.List;

public interface Service<D extends AbstractDto> {
    List<D> getAll();

    D getById(Long id);

    void delete(D dto);

    void save(D dto);

    void update(D dto);
}
