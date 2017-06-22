package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Person;

/**
 * Repository which work with people (sportsmen)
 */
public interface PeopleRepository
        extends JpaRepository<Person, Long> {
}
