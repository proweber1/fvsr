package pro.metrus.fvsr.repositories.custom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface DefaultOrderableByIdRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {

    /**
     * Return all items sorted by id
     *
     * @return List of all T entities
     */
    List<T> findAllByOrderByIdAsc();
}
