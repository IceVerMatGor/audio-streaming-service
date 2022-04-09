package by.gorbov.audio.service;

import by.gorbov.audio.entity.Storage;
import by.gorbov.audio.repo.StorageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {

    private final StorageRepo storageRepo;

    @Override
    public List<Storage> getAll() {
        return storageRepo.findAll();
    }

    @Override
    public Storage getById(Long id) {
        return storageRepo.getById(id);
    }

    @Override
    public void save(Storage storage) {
        storageRepo.save(storage);
    }

    @Override
    public void update(Storage storage) {
        storageRepo.save(storage);
    }
}
