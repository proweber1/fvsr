package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Group;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with groups entity
 */
public interface GroupsRepository
        extends DefaultOrderableByIdRepository<Group, Short> {
}
