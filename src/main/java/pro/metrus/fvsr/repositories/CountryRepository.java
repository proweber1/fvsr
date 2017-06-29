package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Country;

public interface CountryRepository
    extends JpaRepository<Country, Long> {
}
