package pro.metrus.fvsr.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_status")
public class ResultStatus extends AbstractDictionaryWithShortName {

    @Column(name = "name_short_eng")
    private String nameShortEng;

    @Column(name = "name_eng")
    private String nameEng;
}
