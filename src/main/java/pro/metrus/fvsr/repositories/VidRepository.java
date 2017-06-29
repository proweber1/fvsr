package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Vid;

public interface VidRepository
    extends JpaRepository<Vid, Long> {
}
