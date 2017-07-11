package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pro.metrus.fvsr.domains.Team;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

import java.util.List;

/**
 * Repository which work with team types
 */
public interface TeamRepository
        extends DefaultOrderableByIdRepository<Team, Short> {

    List<Team> findAllByOrderByShortNameAsc();

    Page<Team> findAllByOrderByShortNameAsc(final Pageable pageable);
}
