package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.FederalDistrict;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with federal district
 */
public interface FederalDistrictRepository
        extends DefaultOrderableByIdRepository<FederalDistrict, Short> {
}
