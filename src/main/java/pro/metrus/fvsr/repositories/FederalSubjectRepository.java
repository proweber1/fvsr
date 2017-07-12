package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.FederalSubject;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

import java.util.List;

/**
 * Repository which work with federal subjects
 */
public interface FederalSubjectRepository
        extends DefaultOrderableByIdRepository<FederalSubject, Short> {

    List<FederalSubject> findAllByOrderByNameAsc();
}
