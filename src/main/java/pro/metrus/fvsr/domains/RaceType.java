package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "race_type")
@Getter
@Setter
public class RaceType extends AbstractDictionary {

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_short_eng")
    private String nameShortEng;

    /** Вид соревнования */
    @OneToOne
    @JoinColumn(name = "id_vid")
    private Vid vid;
}
