package by.gorbov.audio.service;

import by.gorbov.audio.entity.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> getAll();

    Storage getById(Long id);

    void save(Storage storage);

    void update(Storage storage);
}
