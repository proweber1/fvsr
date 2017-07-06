package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
public class Continent extends AbstractDictionaryWithShortName {
}
