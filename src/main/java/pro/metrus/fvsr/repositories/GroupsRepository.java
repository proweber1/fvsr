package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Group;

/**
 * Repository which work with groups entity
 */
public interface GroupsRepository
        extends JpaRepository<Group, Short> {
}
