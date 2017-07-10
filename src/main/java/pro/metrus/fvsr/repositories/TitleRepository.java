package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pro.metrus.fvsr.domains.Title;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

/**
 * Repository which work with titles
 */
public interface TitleRepository
        extends DefaultOrderableByIdRepository<Title, Short> {

    /**
     * Возвращает список всех званий с сортировкой по id и пагинацией
     *
     * @param pageable Spring pageable bean
     * @return Список званий
     */
    Page<Title> findAllByOrderByIdAsc(final Pageable pageable);
}
