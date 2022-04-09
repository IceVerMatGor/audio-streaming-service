package by.gorbov.audio.service;

import by.gorbov.audio.dto.ResourceDto;
import by.gorbov.audio.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    ResourceDto getById(Long id);
    List<ResourceDto> getAll();
    void deleteAllById(List<Long> ids);
    void saveAll(List<ResourceDto> resourceDtos);
    void update(ResourceDto resourceDto);
}
