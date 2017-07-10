package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    /** Формат команд */
    private String format;

    /** Список UCI которые принаджелат команде */
    @ManyToMany
    @JoinTable(
            name = "teams_uci",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "uci_id")
    )
    private List<Uci> ucis;
    private String country3;
}
