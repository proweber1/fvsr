package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность группы.
 * <p>
 * Это группа в которой находится спортсмен, спортсмен может
 * состоять в одной и больше групп
 */
@Entity
@Table(name = "groups")
public class Group extends AbstractDictionary {
}
