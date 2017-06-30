package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Competitions;

import java.util.Optional;

public interface CompetitionsRepository
        extends JpaRepository<Competitions, Long> {

    /**
     * Найти все записи соревнований и разбить их по странично, а так
     * же сортировать их по ID в увеличивающемся порядке
     *
     * @param pagination Модуль пагинации
     * @return Страница
     */
    Page<Competitions> findAllByOrderByIdAsc(Pageable pagination);

    /**
     * Return one entity by id
     *
     * @param id Entity ID
     * @return Java 8 Optional
     */
    Optional<Competitions> findOne(final long id);
}
