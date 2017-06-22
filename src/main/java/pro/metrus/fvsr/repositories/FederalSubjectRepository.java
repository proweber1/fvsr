package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.FederalSubject;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with federal subjects
 */
public interface FederalSubjectRepository
        extends DefaultOrderableByIdRepository<FederalSubject, Short> {
}
