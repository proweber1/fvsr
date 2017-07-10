package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends AbstractDictionaryWithShortName {

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_short_eng")
    private String nameShortEng;
}
