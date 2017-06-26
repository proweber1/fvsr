package pro.metrus.fvsr.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import pro.metrus.fvsr.domains.Person;
import pro.metrus.fvsr.forms.PeopleFilter;

import java.util.Objects;

import static java.util.Objects.*;

/**
 * This specification using for filtering people by {@link pro.metrus.fvsr.forms.PeopleFilter}
 */
public class PeopleFilterSpecification {

    /**
     * Filter for filtering people
     */
    private final PeopleFilter filter;

    /**
     * @param filter Filter for filtering people, must be not null, if null, these
     *               throw NPE
     */
    public PeopleFilterSpecification(final PeopleFilter filter) {
        this.filter = requireNonNull(filter, "PeopleFilter must be not null, given null!");
    }

    /**
     * Return specification which enable filtering by bmx boolean flag.
     * {@link Person#bmx}
     *
     * @return Specification
     */
    public Specification<Person> bmx() {
        return booleanPredicate("bmx", filter.isBmx());
    }

    /**
     * Return specification which enable filtering by mb boolean flag.
     * {@link Person#mb}
     *
     * @return Specification interface
     */
    public Specification<Person> mb() {
        return booleanPredicate("mb", filter.isMb());
    }

    /**
     * Return specification which enable filtering by track boolean flag.
     * {@link Person#track}
     *
     * @return Specification interface
     */
    public Specification<Person> track() {
        return booleanPredicate("track", filter.isTrack());
    }

    /**
     * Return specification which enable filtering by road boolean flag.
     * {@link Person#road}
     *
     * @return Specification interface
     */
    public Specification<Person> road() {
        return booleanPredicate("road", filter.isRoad());
    }

    /**
     * Return specification which enable filtering by other_role boolean flag.
     * {@link Person#otherRole}
     *
     * @return Specification interface
     */
    public Specification<Person> other() {
        return booleanPredicate("otherRole", filter.isOther());
    }

    /**
     * Return specification which enable filtering by teamMember boolean flag.
     * {@link Person#teamMember}
     *
     * @return Specification interface
     */
    public Specification<Person> teamMember() {
        return booleanPredicate("teamMember", filter.isTeamMember());
    }

    /**
     * Return specification which enable filtering by federation boolean flag.
     * {@link Person#federation}
     *
     * @return Specification interface
     */
    public Specification<Person> federation() {
        return booleanPredicate("federation", filter.isFederation());
    }

    /**
     * Return specification which enable filtering by commissaire boolean flag.
     * {@link Person#commissaire}
     *
     * @return Specification interface
     */
    public Specification<Person> commissaire() {
        return booleanPredicate("commissaire", filter.isCommissaire());
    }

    /**
     * Return specification which enable filtering by techincalDelegate boolean flag.
     * {@link Person#techincalDelegate}
     *
     * @return Specification interface
     */
    public Specification<Person> techincalDelegate() {
        return booleanPredicate("techincalDelegate", filter.isTechnical());
    }

    /**
     * Return specification which enable filtering by rider boolean flag.
     * {@link Person#rider}
     *
     * @return Specification interface
     */
    public Specification<Person> rider() {
        return booleanPredicate("rider", filter.isRider());
    }

    /**
     * Return specification which enable filtering by gender boolean flag.
     * {@link Person#gender}
     *
     * @return Specification interface
     */
    public Specification<Person> gender() {
        return booleanPredicate("gender", filter.isGender());
    }

    /**
     * Add filtering by entity id
     *
     * @return Specification
     */
    public Specification<Person> id() {
        return numberIsNotNull("id", filter.getId());
    }

    /**
     * Add filtering by old entity id
     *
     * @return Specification
     */
    public Specification<Person> oldId() {
        return numberIsNotNull("oldId", filter.getOldId());
    }

    /**
     * Add filtering with like conditions by surname field
     *
     * @return specification
     */
    public Specification<Person> surname() {
        return likeCondition("lastname", filter.getSurname());
    }

    /**
     * Add filtering by firstname with like conditions
     *
     * @return specification
     */
    public Specification<Person> firstname() {
        return likeCondition("firstname", filter.getFirstname());
    }

    /**
     * Add filtering by surname rus with like conditions
     *
     * @return specification
     */
    public Specification<Person> surnameRus() {
        return likeCondition("lastnameRus", filter.getSurnameRus());
    }

    /**
     * Add filtering by firstname rus with like conditions
     *
     * @return Specification
     */
    public Specification<Person> firstnameRus() {
        return likeCondition("firstnameRus", filter.getFirstnameRus());
    }

    /**
     * Return all people specifications
     *
     * @return Specifications
     */
    public Specifications<Person> withAllSpecifications() {
        return Specifications
                .where(bmx())
                .and(mb())
                .and(other())
                .and(commissaire())
                .and(federation())
                .and(gender())
                .and(rider())
                .and(road())
                .and(teamMember())
                .and(techincalDelegate())
                .and(track())
                .and(id())
                .and(oldId())
                .and(surname())
                .and(firstname())
                .and(surnameRus())
                .and(firstnameRus());
    }

    /**
     * Universal method which return specification
     *
     * @param columnName Column which needs compare with value
     * @param value Column value
     * @return Specification
     */
    private Specification<Person> booleanPredicate(final String columnName, boolean value) {
        return (root, cq, cb) -> value ? cb.equal(root.get(columnName), true) : null;
    }

    /**
     * Specification provider which return specification which working with
     * numbers in query
     *
     * @param columnWithNumber Column name which contains numbers
     * @param value Number value
     * @return Specification impl
     */
    private Specification<Person> numberIsNotNull(String columnWithNumber, String value) {
        return (root, cq, cb) -> Objects.isNull(value) || value.isEmpty()
                ? null : cb.equal(root.get(columnWithNumber), value);
    }

    /**
     * This method provide like conditions for string columns
     *
     * @param columnName Column name
     * @param value Column value
     * @return specification
     */
    private Specification<Person> likeCondition(String columnName, String value) {
        return (root, cq, cb) -> {
            if (Objects.isNull(value) || value.isEmpty()) {
                return null;
            }

            final String pattern = String.format("%%%s%%", value.toUpperCase());
            return cb.like(cb.upper(root.get(columnName)), pattern);
        };
    }
}
