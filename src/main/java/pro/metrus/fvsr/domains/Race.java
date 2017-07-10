package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Сущность представляет собой одну гонку в системе
 */
@Entity
@Table(name = "races")
@Getter
@Setter
@ToString
public class Race {

    private static final String DATE_FORMAT = "dd-MM-yyyy";

    /** Первичный ключ таблицы */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Место проведения */
    private String place;
    private String name;

    @Column(name = "categorycode")
    private String categoryCode;

    /** Дата проведения */
    @Column(name = "date")
    @DateTimeFormat(pattern = Race.DATE_FORMAT)
    private LocalDate dateTime = LocalDate.now();

    @Column(name = "mandatorydate")
    @DateTimeFormat(pattern = Race.DATE_FORMAT)
    private LocalDate mandatoryDate;

    @OneToOne
    private Participant participant;

    /** Соревнование в котором участвует эта гонка */
    @OneToOne
    @JoinColumn(name = "id_competition")
    @NotNull
    private Competitions competitions;
}
