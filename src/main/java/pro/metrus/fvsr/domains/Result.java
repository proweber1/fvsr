package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results")
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_race")
    private Race race;

    private String bib;
    private String rank;
    private Integer num;
    private Integer place;

    @OneToOne
    @JoinColumn(name = "id_people")
    private Person person;

    @Column(name = "fio")
    private String fullname;

    @OneToOne
    @JoinColumn(name = "id_subject")
    private FederalSubject subject;

    @OneToOne
    @JoinColumn(name = "id_team")
    private Team team;
    private String points;

    @OneToOne
    @JoinColumn(name = "id_result_status")
    private ResultStatus resultStatus;
}
