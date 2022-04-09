package by.gorbov.audio.repo;

import by.gorbov.audio.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<Storage,Long> {
}
