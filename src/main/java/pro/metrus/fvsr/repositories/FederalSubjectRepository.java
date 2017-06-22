package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.FederalSubject;

/**
 * Repository which work with federal subjects
 */
public interface FederalSubjectRepository
        extends JpaRepository<FederalSubject, Short> {
}
