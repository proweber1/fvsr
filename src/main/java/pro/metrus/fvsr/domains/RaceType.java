package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "race_type")
@Getter
@Setter
public class RaceType extends AbstractDictionary {

    /** Вид соревнования */
    @OneToOne
    @JoinColumn(name = "id_vid")
    private Vid vid;
}
