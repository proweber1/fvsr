package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Сущность спортсмена
 * <p>
 * Эта сущность представляет одного спорстмена в системе
 */
@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "federation_num")
    private int federationNum;

    private String lastname;

    private String firstname;

    /**
     * Это поле завел архитектор, мы хотели сделать
     * enum, но теперь это булев флаг, если он true, то
     * это мужской пол, если false, то женский
     */
    private boolean gender;

    private LocalDate birthdate;

    private String address1;

    private String address2;

    private String zip;

    private String town;

    private String country;

    private String phone;

    private String mobile;

    private String email;

    private boolean rider;

    private boolean commissaire;

    private boolean classifier;

    @Column(name = "techincal_delegate")
    private boolean techincalDelegate;

    private boolean federation;

    @Column(name = "team_member")
    private boolean teamMember;

    @Column(name = "other_Role")
    private boolean otherRole;

    @Column(name = "old_id")
    private String oldId;

    @Column(name = "lastname_rus")
    private String lastnameRus;

    @Column(name = "firstname_rus")
    private String firstnameRus;

    @Column(name = "patronymic_rus")
    private String patronymicRus;

    @OneToOne
    @JoinColumn(name = "groups_id")
    private Group group;

    @OneToOne
    @JoinColumn(name = "subjects_id")
    private FederalSubject federalSubject;

    @OneToOne
    @JoinColumn(name = "teams_id")
    private Team team;

    private boolean road;

    private boolean track;

    private boolean mb;

    private boolean bmx;

    @OneToOne
    @JoinColumn(name = "titles_id")
    private Title title;
}
