package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность заголовков
 */
@Entity
@Table(name = "titles")
public class Title extends AbstractDictionaryWithShortName {
}
