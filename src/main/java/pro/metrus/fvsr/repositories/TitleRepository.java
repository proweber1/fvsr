package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Title;

/**
 * Repository which work with titles
 */
public interface TitleRepository
        extends JpaRepository<Title, Short> {
}
