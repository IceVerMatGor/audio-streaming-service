package by.gorbov.audio.dto.mapper;

import by.gorbov.audio.dto.ResourceDto;
import by.gorbov.audio.entity.Resource;
import by.gorbov.audio.entity.Storage;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapperImpl implements ResourceMapper{


    @Override
    public Resource toEntity(ResourceDto resourceDto) {
        return Resource.builder()
                .id(resourceDto.getId())
                .size(resourceDto.getSize())
                .audioType(resourceDto.getAudioType())
                .checksum(resourceDto.getChecksum())
                .originalFileName(resourceDto.getOriginalFileName())
                .audioId(resourceDto.getAudioId())
                .storage(Storage.builder().id(resourceDto.getStorageId()).build())
                .songId(resourceDto.getSongId())
                .path(resourceDto.getPath())
                .build();
    }

    @Override
    public ResourceDto toDto(Resource resource) {
        return ResourceDto.builder()
                .id(resource.getId())
                .size(resource.getSize())
                .audioType(resource.getAudioType())
                .checksum(resource.getChecksum())
                .originalFileName(resource.getOriginalFileName())
                .audioId(resource.getAudioId())
                .storageId(resource.getStorage().getId())
                .songId(resource.getSongId())
                .path(resource.getPath())
                .build();
    }
}
