package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Team;

/**
 * Repository which work with team types
 */
public interface TeamRepository
        extends JpaRepository<Team, Short> {
}
