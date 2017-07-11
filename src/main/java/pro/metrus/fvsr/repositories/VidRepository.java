package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pro.metrus.fvsr.domains.Vid;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

public interface VidRepository
    extends DefaultOrderableByIdRepository<Vid, Short> {

    /**
     * Возвращает список всех видов спорта с сортировкой по id и пагинацией
     *
     * @param pageable String pageable bean
     * @return Список видов спорта
     */
    Page<Vid> findAllByOrderByIdAsc(final Pageable pageable);
}
