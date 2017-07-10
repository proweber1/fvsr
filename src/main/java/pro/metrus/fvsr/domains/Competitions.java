package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "competitions")
@Getter
@Setter
public class Competitions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @OneToOne
    @JoinColumn(name = "id_rf_subject")
    @NotNull
    private FederalSubject subject;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "startdate")
    private Date dateBegin;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "enddate")
    private Date dateEnd;

    private String country3;
    private String country2;
    private String classcode;

    @Column(name = "name_eng")
    private String nameEng;

    @OneToOne
    @JoinColumn(name = "id_vid")
    @NotNull
    private Vid vid;
}
