package pro.metrus.fvsr.repositories.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface DefaultOrderableByIdRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {

    /**
     * Return all items sorted by id
     *
     * @return List of all T entities
     */
    List<T> findAllByOrderByIdAsc();

    /**
     * Find all items with sort by id and pagination
     *
     * @param page Pageable spring bean
     * @return Data page
     */
    Page<T> findAllByOrderByIdAsc(final Pageable page);
}
