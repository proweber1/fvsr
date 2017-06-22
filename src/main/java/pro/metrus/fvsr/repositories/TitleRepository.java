package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Title;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with titles
 */
public interface TitleRepository
        extends DefaultOrderableByIdRepository<Title, Short> {
}
