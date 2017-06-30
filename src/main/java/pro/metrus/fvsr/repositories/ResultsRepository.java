package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Result;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

public interface ResultsRepository
    extends DefaultOrderableByIdRepository<Result, Long> {
}
