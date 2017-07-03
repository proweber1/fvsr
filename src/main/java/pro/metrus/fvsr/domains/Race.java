package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "races")
@Getter
@Setter
@ToString
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_race_type")
    @NotNull
    private RaceType raceType;

    @OneToOne
    @JoinColumn(name = "id_category")
    @NotNull
    private Category category;

    private String place;

    @Column(name = "date_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy H:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

    private String distance;

    @OneToOne
    @JoinColumn(name = "id_competition")
    @NotNull
    private Competitions competitions;
}
