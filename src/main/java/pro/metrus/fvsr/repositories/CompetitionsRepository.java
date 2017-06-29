package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Competitions;

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
}
