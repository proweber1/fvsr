package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.RaceType;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

public interface RaceTypesRepository
    extends DefaultOrderableByIdRepository<RaceType, Short> {
}
