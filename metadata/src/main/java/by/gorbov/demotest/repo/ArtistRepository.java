package by.gorbov.demotest.repo;

import by.gorbov.demotest.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
