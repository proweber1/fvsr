package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_eng")
    private String name;

    @Column(name = "name")
    private String nameRus;

    private String alpha2;

    @Column(name = "name_short")
    private String shortName;

    @OneToOne
    private Continent continent;
}
