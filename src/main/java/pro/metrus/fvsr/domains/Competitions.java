package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private String place;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_begin")
    private LocalDate dateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @OneToOne
    @JoinColumn(name = "id_country")
    @NotNull
    private Country country;

    @OneToOne
    @JoinColumn(name = "id_vid")
    @NotNull
    private Vid vid;
}
