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

    @Column(name = "country2")
    private String alpha2;

    private String country3;

    @OneToOne
    private Continent continent;
}
