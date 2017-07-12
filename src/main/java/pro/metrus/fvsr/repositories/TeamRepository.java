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

    /**
     * Find all teams by specify uci id
     *
     * @param ucisId   Specify uci id, must be positive integer
     *                 if this param is negative then throw IllegalArgumentException
     * @return Spring page
     */
    List<Team> findAllByUcisVidIdOrderByShortNameAsc(final short ucisId);

    Page<Team> findAllByOrderByShortNameAsc(final Pageable pageable);

    /**
     * Find all teams by specify uci id
     *
     * @param pageable Spring pageable bean
     * @param ucisId   Specify uci id, must be positive integer
     *                 if this param is negative then throw IllegalArgumentException
     * @return Spring page
     */
    Page<Team> findAllByUcisVidIdOrderByShortNameAsc(
            final Pageable pageable, final short ucisId);
}
