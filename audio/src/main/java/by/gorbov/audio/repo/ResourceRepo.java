package by.gorbov.audio.repo;

import by.gorbov.audio.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends JpaRepository<Resource,Long> {
}
