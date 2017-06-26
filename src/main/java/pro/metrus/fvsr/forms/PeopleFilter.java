package pro.metrus.fvsr.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * Форма фильтера для фильтрации спортсменов по параметрам
 * из данного фильтра
 */
@Getter
@Setter
public class PeopleFilter {

    /**
     * Этот параметр указывает на пол спортсмена
     */
    private boolean gender;

    /**
     * Этот флаг указывает на то, что спорстмен имеет
     * навыки езды на велосипеде
     */
    private boolean rider;

    /**
     * Техник
     */
    private boolean technical;

    /**
     * Коммисар
     */
    private boolean commissaire;

    /**
     * Федерация
     */
    private boolean federation;

    /**
     * Член команды
     */
    private boolean teamMember;

    /**
     * Другое
     */
    private boolean other;

    /**
     * Дорога
     */
    private boolean road;

    /**
     * Трек
     */
    private boolean track;

    /**
     * Маунтинбайк
     */
    private boolean mb;

    /**
     * BMX
     */
    private boolean bmx;

    /**
     * ID спорстмена
     */
    private String id;

    /**
     * Старый ID спортсмена
     */
    private String oldId;

    /**
     * Фамилия на английском
     */
    private String surname;

    /**
     * Имя на английском
     */
    private String firstname;

    /**
     * Фамилия на русском
     */
    private String surnameRus;

    /**
     * Имя на русском
     */
    private String firstnameRus;

    /**
     * ID'шник субъекта федерации
     */
    @Min(1)
    private Integer federalSubjectId;

    /**
     * ID команды
     */
    @Min(1)
    private Integer teamId;

    /**
     * ID заголовка
     */
    @Min(1)
    private Integer titleId;
}
