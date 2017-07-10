package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
@Getter
@Setter
public class Continent extends AbstractDictionaryWithShortName {

    @Column(name = "name_short_eng")
    private String nameShortEng;
}
