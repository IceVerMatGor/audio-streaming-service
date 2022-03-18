package by.gorbov.demotest.repo;

import by.gorbov.demotest.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
