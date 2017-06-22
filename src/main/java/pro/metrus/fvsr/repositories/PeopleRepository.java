package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Person;

public interface PeopleRepository
        extends JpaRepository<Person, Long> {
}
