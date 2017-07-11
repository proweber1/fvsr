package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.RaceType;

import java.util.List;

public interface RaceTypesRepository extends JpaRepository<RaceType, Short> {

    /**
     * Найти все заезды с сортировкой по ID вида
     *
     * @return Список типов заездов
     */
    List<RaceType> findAllByOrderByVidIdAsc();

    /**
     * Возвращает список типов заездов по id c пагинацией
     *
     * @param pageable Spring pageable bean
     * @return Список типов заездов
     */
    Page<RaceType> findAllByOrderByVidIdAsc(final Pageable pageable);
}
