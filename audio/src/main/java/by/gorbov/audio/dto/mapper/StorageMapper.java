package by.gorbov.audio.dto.mapper;

import by.gorbov.audio.dto.StorageDto;
import by.gorbov.audio.entity.Storage;

public interface StorageMapper {
    Storage toEntity(StorageDto storageDto);
    StorageDto toDto(Storage storage);
}
