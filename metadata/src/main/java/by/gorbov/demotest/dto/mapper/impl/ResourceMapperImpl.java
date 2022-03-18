package by.gorbov.demotest.dto.mapper.impl;

import by.gorbov.demotest.dto.ResourceDto;
import by.gorbov.demotest.dto.SongDto;
import by.gorbov.demotest.dto.mapper.api.ResourceMapper;
import by.gorbov.demotest.entity.Album;
import by.gorbov.demotest.entity.Resource;
import by.gorbov.demotest.entity.Song;
import by.gorbov.demotest.entity.Storage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ResourceMapperImpl extends AbstractMapper<ResourceDto, Resource> implements ResourceMapper {
    @Override
    protected Class<Resource> getEntityClass() {
        return Resource.class;
    }

    @Override
    protected Class<ResourceDto> getDtoClass() {
        return ResourceDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Resource.class, ResourceDto.class)
                .addMappings(m -> m.skip(ResourceDto::setSongId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(ResourceDto::setStorageId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ResourceDto.class, Resource.class)
                .addMappings(m -> m.skip(Resource::setSong)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Resource::setStorage)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Resource source, ResourceDto destination) {
        if (source.getSong() != null)
            destination.setSongId(source.getSong().getId());
        if (source.getStorage() != null)
            destination.setStorageId(source.getStorage().getId());

    }
    @Override
    public void mapSpecificFields(ResourceDto source, Resource destination) {
        Storage storage = new Storage();
        storage.setId(source.getStorageId());
        destination.setStorage(storage);
    }
}
