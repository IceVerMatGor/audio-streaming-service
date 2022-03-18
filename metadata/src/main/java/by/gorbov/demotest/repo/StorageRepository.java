package by.gorbov.demotest.repo;

import by.gorbov.demotest.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage,Long> {
}
