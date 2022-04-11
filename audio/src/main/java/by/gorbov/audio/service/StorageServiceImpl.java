package by.gorbov.audio.service;

import by.gorbov.audio.dto.StorageDto;
import by.gorbov.audio.dto.mapper.StorageMapper;
import by.gorbov.audio.entity.Storage;
import by.gorbov.audio.repo.StorageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {

    private final StorageRepo storageRepo;
    private final StorageMapper storageMapper;

    @Override
    public List<StorageDto> getAll() {
        List<StorageDto> storageDtoList = new ArrayList<>();
        storageRepo.findAll().forEach(storage -> storageDtoList.add(storageMapper.toDto(storage)));
        return storageDtoList;
    }

    @Override
    public StorageDto getById(Long id) {
        return storageMapper.toDto(storageRepo.getById(id));
    }

    @Override
    public void save(StorageDto storageDto) {
        storageRepo.save(storageMapper.toEntity(storageDto));
    }

    @Override
    public void update(StorageDto storageDto) {
        storageRepo.save(storageMapper.toEntity(storageDto));
    }
}
