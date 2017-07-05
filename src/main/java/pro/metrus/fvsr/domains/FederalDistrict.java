package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность федерального округа.
 * <p>
 * Она привязывается к субъету ведерального округа.
 */
@Entity
@Table(name = "rf_fo")
public class FederalDistrict extends AbstractDictionaryWithShortName {
}
