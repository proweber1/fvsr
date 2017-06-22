package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.FederalDistrict;

/**
 * Repository which work with federal district
 */
public interface FederalDistrictRepository
        extends JpaRepository<FederalDistrict, Short> {
}
