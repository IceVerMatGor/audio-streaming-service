package by.gorbov.demotest.dto.mapper.impl;

import by.gorbov.demotest.dto.AbstractDto;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.entity.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class AbstractMapper<D extends AbstractDto, E extends AbstractEntity> implements Mapper<D, E> {
    @Autowired
    ModelMapper mapper;

    protected abstract Class<E> getEntityClass();

    protected abstract Class<D> getDtoClass();

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, getDtoClass());
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, getEntityClass());
    }

    Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(E source, D destination) {
    }

    void mapSpecificFields(D source, E destination) {
    }
}
