package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pro.metrus.fvsr.domains.Person;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with people (sportsmen)
 */
public interface PeopleRepository
        extends DefaultOrderableByIdRepository<Person, Long>,
                JpaSpecificationExecutor<Person> {
}
