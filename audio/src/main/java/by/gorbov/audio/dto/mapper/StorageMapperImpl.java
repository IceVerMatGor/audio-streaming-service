package by.gorbov.audio.dto.mapper;

import by.gorbov.audio.dto.StorageDto;
import by.gorbov.audio.entity.Resource;
import by.gorbov.audio.entity.Storage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageMapperImpl implements StorageMapper {

    @Override
    public Storage toEntity(StorageDto storageDto) {
        List<Resource> resourceList = new ArrayList<>();
        if (storageDto.getResourcesId() != null) {
            storageDto.getResourcesId().forEach(id -> resourceList.add(Resource.builder().id(id).build()));
        }
        return Storage.builder()
                .id(storageDto.getId())
                .type(storageDto.getType())
                .resources(resourceList)
                .build();
    }

    @Override
    public StorageDto toDto(Storage storage) {
        return StorageDto.builder()
                .id(storage.getId())
                .type(storage.getType())
                .resourcesId(storage.getResources().stream().mapToLong(Resource::getId).boxed().toList()).build();
    }
}
