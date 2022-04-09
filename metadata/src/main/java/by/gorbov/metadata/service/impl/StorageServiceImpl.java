package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.StorageDto;
import by.gorbov.metadata.service.api.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Override
    public List<StorageDto> getAll() {
        return null;
    }

    @Override
    public StorageDto getById(Long id) {
        return null;
    }

    @Override
    public void save(StorageDto storageDto) {

    }

    @Override
    public void update(StorageDto storageDto) {

    }
}
