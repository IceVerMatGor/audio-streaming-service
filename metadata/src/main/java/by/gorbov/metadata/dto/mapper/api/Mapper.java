package by.gorbov.metadata.dto.mapper.api;

import by.gorbov.metadata.dto.AbstractDto;
import by.gorbov.metadata.entity.AbstractEntity;

public interface Mapper <D extends AbstractDto, E extends AbstractEntity>{
    D toDto(E entity);

    E toEntity(D dto);
}
