package by.gorbov.demotest.repo;

import by.gorbov.demotest.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SongRepository extends JpaRepository<Song,Long> {
}
