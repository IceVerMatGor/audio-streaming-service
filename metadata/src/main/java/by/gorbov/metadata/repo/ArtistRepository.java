package by.gorbov.metadata.repo;

import by.gorbov.metadata.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
