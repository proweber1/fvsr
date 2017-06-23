package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Сущность федерального субъекта
 */
@Entity
@Table(name = "rf_subjects")
@Getter
@Setter
public class FederalSubject extends AbstractDictionary {

    /** Федеральный округ к которому привязан этот субъект */
    @OneToOne
    @JoinColumn(name = "rf_fo_id")
    private FederalDistrict federalDistrict;
}
