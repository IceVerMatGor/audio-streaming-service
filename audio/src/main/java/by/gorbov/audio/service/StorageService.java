package by.gorbov.audio.service;

import by.gorbov.audio.dto.StorageDto;
import by.gorbov.audio.entity.Storage;

import java.util.List;

public interface StorageService {
    List<StorageDto> getAll();

    StorageDto getById(Long id);

    void save(StorageDto storageDto);

    void update(StorageDto storageDto);
}
