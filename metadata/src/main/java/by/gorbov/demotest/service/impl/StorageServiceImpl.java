package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.StorageDto;
import by.gorbov.demotest.dto.mapper.api.StorageMapper;
import by.gorbov.demotest.entity.Storage;
import by.gorbov.demotest.service.api.StorageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends AbstractService<StorageDto, Storage> implements StorageService {

    public StorageServiceImpl(JpaRepository<Storage, Long> repository, StorageMapper mapper) {
        super(repository, mapper);
    }
}
