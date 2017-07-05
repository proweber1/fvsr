package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Этот абстрактный класс для словарей которые еще имеют в
 * своем распоряжении короткое название
 */
@Getter
@Setter
@MappedSuperclass
abstract class AbstractDictionaryWithShortName
    extends AbstractDictionary {

    /** Короткое название записи в словаре */
    @Column(name = "name_short")
    private String shortName;
}
