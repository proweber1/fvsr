package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Сущность федерального субъекта
 */
@Entity
@Table(name = "rf_subjects")
public class FederalSubject extends AbstractDictionary {

    /** Федеральный округ к которому привязан этот субъект */
    @OneToOne
    @JoinColumn(name = "rf_fo_id")
    private FederalDistrict federalDistrict;
}
