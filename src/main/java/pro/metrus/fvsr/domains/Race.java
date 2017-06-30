package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "races")
@Getter
@Setter
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_race_type")
    private RaceType raceType;

    @OneToOne
    @JoinColumn(name = "id_category")
    private Category category;

    private String place;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private String distance;

    @OneToOne
    @JoinColumn(name = "id_competition")
    private Competitions competitions;
}
