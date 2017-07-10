package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Country;

import java.util.List;

public interface CountryRepository
    extends JpaRepository<Country, Long> {

    /**
     * Возвращает список всех стран вместе с сортировкой по short name
     *
     * @return Список стран
     */
    List<Country> findAllByOrderByShortNameAsc();

    /**
     * Возвращает список стран вместе с сортировкой по short name и пагинацией
     *
     * @param pageable Spring pageable bean
     * @return Список стран
     */
    Page<Country> findAllByOrderByShortNameAsc(final Pageable pageable);
}
