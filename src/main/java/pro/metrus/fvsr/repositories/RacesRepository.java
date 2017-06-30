package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Race;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with races
 */
public interface RacesRepository
    extends DefaultOrderableByIdRepository<Race, Long> {
}
