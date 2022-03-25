package by.gorbov.audio.repo;

import by.gorbov.audio.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface AudioRepo extends JpaRepository<Audio,Long> {
}
