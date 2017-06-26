package pro.metrus.fvsr.forms;

import lombok.Getter;
import lombok.Setter;

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
}
