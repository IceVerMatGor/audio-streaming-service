package by.gorbov.demotest.dto.mapper.impl;

import by.gorbov.demotest.dto.AlbumDto;
import by.gorbov.demotest.dto.StorageDto;
import by.gorbov.demotest.dto.mapper.api.StorageMapper;
import by.gorbov.demotest.entity.AbstractEntity;
import by.gorbov.demotest.entity.Album;
import by.gorbov.demotest.entity.Storage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class StorageMapperImpl extends AbstractMapper<StorageDto, Storage> implements StorageMapper {
    @Override
    protected Class<Storage> getEntityClass() {
        return Storage.class;
    }

    @Override
    protected Class<StorageDto> getDtoClass() {
        return StorageDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Storage.class, StorageDto.class)
                .addMappings(m -> m.skip(StorageDto::setResourcesId)).setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(Storage source, StorageDto destination) {
        List<Long> resourcesId = source.getResources().stream().mapToLong(AbstractEntity::getId).boxed().toList();

        destination.setResourcesId(resourcesId);
    }
}
