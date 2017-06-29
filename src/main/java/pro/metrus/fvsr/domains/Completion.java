package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "completions")
@Getter
@Setter
public class Completion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id_rf_subject")
    private FederalSubject subject;

    private String place;

    @Column(name = "date_begin")
    private LocalDate dateBegin;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @OneToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @OneToOne
    @JoinColumn(name = "id_vid")
    private Vid vid;
}
