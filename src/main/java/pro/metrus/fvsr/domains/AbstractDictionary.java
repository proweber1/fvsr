package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Скелет для справочников, вынесено в супер класс потому что
 * в системе все справочники будут иметь короткий id (short type)
 * и имя (поле name)
 */
@MappedSuperclass
class AbstractDictionary {

    /**
     * Первичный ключ группы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private short id;

    /**
     * Название в справочнике
     */
    @Getter
    @Setter
    private String name;
}
