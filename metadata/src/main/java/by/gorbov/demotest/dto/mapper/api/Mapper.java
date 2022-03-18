package by.gorbov.demotest.dto.mapper.api;

import by.gorbov.demotest.dto.AbstractDto;
import by.gorbov.demotest.entity.AbstractEntity;

public interface Mapper <D extends AbstractDto, E extends AbstractEntity>{
    D toDto(E entity);

    E toEntity(D dto);
}
