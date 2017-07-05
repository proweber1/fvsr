package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    /** Первичный ключ таблицы */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Тип заезда */
    @OneToOne
    @JoinColumn(name = "id_race_type")
    @NotNull
    private RaceType raceType;

    /** Категория в которой отмечена гонка */
    @OneToOne
    @JoinColumn(name = "id_category")
    @NotNull
    private Category category;

    /** Место проведения */
    private String place;

    /** Дата проведения */
    @Column(name = "date_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy H:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

    /** Дистанция заезда */
    private String distance;

    /** Соревнование в котором участвует эта гонка */
    @OneToOne
    @JoinColumn(name = "id_competition")
    @NotNull
    private Competitions competitions;

    /** Комментарии к гонке */
    @Column(name = "coments")
    private String comments;
}
