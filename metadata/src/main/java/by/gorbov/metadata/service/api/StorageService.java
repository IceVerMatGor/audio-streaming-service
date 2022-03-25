package by.gorbov.metadata.service.api;

import by.gorbov.metadata.dto.AlbumDto;
import by.gorbov.metadata.dto.StorageDto;

import java.util.List;

public interface StorageService {
    List<StorageDto> getAll();

    StorageDto getById(Long id);

    void save(StorageDto storageDto);

    void update(StorageDto storageDto);
}
