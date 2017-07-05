package pro.metrus.fvsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.metrus.fvsr.domains.Participant;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

public interface ParticipantRepository
        extends DefaultOrderableByIdRepository<Participant, Long> {

}
