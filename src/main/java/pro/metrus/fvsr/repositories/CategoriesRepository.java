package pro.metrus.fvsr.repositories;

import pro.metrus.fvsr.domains.Category;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

public interface CategoriesRepository
    extends DefaultOrderableByIdRepository<Category, Short> {
}
