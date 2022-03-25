package by.gorbov.metadata.service.api;

import by.gorbov.metadata.dto.AlbumDto;
import by.gorbov.metadata.dto.ResourceDto;

import java.util.List;

public interface ResourceService {
    List<ResourceDto> getAll();

    ResourceDto getById(Long id);

    void save(ResourceDto resourceDto);

    void update(ResourceDto resourceDto);

    void deleteAllById(List<Long> ids);
}
