package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Continent;

import java.util.List;

public interface ContinentsRepository
    extends JpaRepository<Continent, Long> {

    List<Continent> findAllByOrderByShortNameAsc();
}
