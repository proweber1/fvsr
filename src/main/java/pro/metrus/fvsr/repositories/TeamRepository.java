package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Team;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with team types
 */
public interface TeamRepository
        extends DefaultOrderableByIdRepository<Team, Short> {
}
