package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность команды.
 * <p>
 * Это словарь команд которые есть в федерации.
 */
@Entity
@Table(name = "teams")
public class Team extends AbstractDictionary {
}
