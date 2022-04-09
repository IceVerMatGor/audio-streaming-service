package by.gorbov.audio.dto.mapper;

import by.gorbov.audio.dto.ResourceDto;
import by.gorbov.audio.entity.Resource;

public interface ResourceMapper {
    Resource toEntity(ResourceDto resourceDto);
    ResourceDto toDto(Resource resource);
}
