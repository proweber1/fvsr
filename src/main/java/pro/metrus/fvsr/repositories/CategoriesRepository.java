package pro.metrus.fvsr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Category;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

    /**
     * Отдает список всех категорий с сортировкой по короткому названию
     *
     * @return Список категорий
     */
    List<Category> findAllByOrderByShortNameAsc();

    /**
     * Возвращает список всех категорий с сортировкой по короткому названию и пагинацией
     *
     * @param pageable Spring pageable bean
     * @return Список категорий
     */
    Page<Category> findAllByOrderByShortNameAsc(final Pageable pageable);
}
