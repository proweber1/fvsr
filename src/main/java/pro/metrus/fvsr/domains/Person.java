package pro.metrus.fvsr.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность спортсмена
 * <p>
 * Эта сущность представляет одного спорстмена в системе
 */
@Entity
@Table(name = "people")
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long uci;

    @Column(name = "federation_num")
    private int federationNum;

    /**
     * Это поле завел архитектор, мы хотели сделать
     * enum, но теперь это булев флаг, если он true, то
     * это женский пол, если false, то мужской
     */
    private boolean gender;

    private Date birthdate;

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

    @Column(name = "technical_delegate")
    private boolean techincalDelegate;

    private boolean federation;

    @Column(name = "team_member")
    private boolean teamMember;

    @Column(name = "other_role")
    private boolean otherRole;

    private String lastname;
    private String firstname;

    @Column(name = "patronymic")
    private String patronymic;

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

    @Column(name = "firstname_eng")
    private String firstnameEng;

    @Column(name = "lastname_eng")
    private String lastnameEng;
}
