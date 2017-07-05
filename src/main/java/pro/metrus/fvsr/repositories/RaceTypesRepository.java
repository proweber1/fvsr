package pro.metrus.fvsr.repositories;

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
}
