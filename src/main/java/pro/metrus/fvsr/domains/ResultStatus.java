package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_status")
@Getter
@Setter
public class ResultStatus extends AbstractDictionaryWithShortName {

    @Column(name = "name_short_eng")
    private String nameShortEng;

    @Column(name = "name_eng")
    private String nameEng;
}
