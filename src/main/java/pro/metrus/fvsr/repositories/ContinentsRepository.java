package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Continent;

import java.util.List;

public interface ContinentsRepository
    extends JpaRepository<Continent, Long> {

    List<Continent> findAllByOrderByShortNameAsc();

    /**
     * Возвращает список континентов по короткому названию с пагинацией
     *
     * @param pageable Spring pageable bean
     * @return Список континентов
     */
    Page<Continent> findAllByOrderByShortNameAsc(final Pageable pageable);
}
