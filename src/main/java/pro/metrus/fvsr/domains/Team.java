package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Сущность команды.
 * <p>
 * Это словарь команд которые есть в федерации.
 */
@Entity
@Table(name = "teams")
@Getter
@Setter
public class Team extends AbstractDictionaryWithShortName {

    /** Регион в котором участвует комманда */
    @OneToOne
    @JoinColumn(name = "countries_id")
    private Country country;

    /** Формат команд */
    private String format;
}
