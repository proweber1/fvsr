package pro.metrus.fvsr.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import pro.metrus.fvsr.domains.Person;
import pro.metrus.fvsr.forms.PeopleFilter;

import java.util.Objects;
import static java.util.Objects.requireNonNull;

/**
 * This specification using for filtering people by {@link pro.metrus.fvsr.forms.PeopleFilter}
 */
public class PeopleFilterSpecification {

    /**
     * Return all people specifications
     *
     * @return Specifications
     */
    public static Specifications<Person> withAllSpecifications(final PeopleFilter filter) {
        requireNonNull(filter, "Filter must be not null! Given null!");

        return Specifications
                .where(booleanPredicate("bmx", filter.isBmx()))
                .and(booleanPredicate("mb", filter.isMb()))
                .and(booleanPredicate("otherRole", filter.isOther()))
                .and(booleanPredicate("commissaire", filter.isCommissaire()))
                .and(booleanPredicate("federation", filter.isFederation()))
                .and(booleanPredicate("gender", filter.isGender()))
                .and(booleanPredicate("rider", filter.isRider()))
                .and(booleanPredicate("road", filter.isRoad()))
                .and(booleanPredicate("teamMember", filter.isTeamMember()))
                .and(booleanPredicate("techincalDelegate", filter.isTechnical()))
                .and(booleanPredicate("track", filter.isTrack()))
                .and(numberIsNotNull("id", filter.getId()))
                .and(numberIsNotNull("oldId", filter.getOldId()))
                .and(likeCondition("lastname", filter.getSurname()))
                .and(likeCondition("firstname", filter.getFirstname()))
                .and(likeCondition("lastnameRus", filter.getSurnameRus()))
                .and(likeCondition("firstnameRus", filter.getFirstnameRus()))
                .and(personRelationById("team", filter.getTeamId()))
                .and(personRelationById("federalSubject", filter.getFederalSubjectId()))
                .and(personRelationById("title", filter.getTitleId()));
    }

    /**
     * Universal method which return specification
     *
     * @param columnName Column which needs compare with value
     * @param value Column value
     * @return Specification
     */
    private static Specification<Person> booleanPredicate(final String columnName, boolean value) {
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
    private static Specification<Person> numberIsNotNull(String columnWithNumber, String value) {
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
    private static Specification<Person> likeCondition(String columnName, String value) {
        return (root, cq, cb) -> {
            if (Objects.isNull(value) || value.isEmpty()) {
                return null;
            }

            final String pattern = String.format("%%%s%%", value.toUpperCase());
            return cb.like(cb.upper(root.get(columnName)), pattern);
        };
    }

    /**
     * Specification which filtering relations in entity
     *
     * @param relationName Relation name for filtering
     * @param id Relation id
     * @return specification
     */
    private static Specification<Person> personRelationById(String relationName, Integer id) {
        return (root, cq, cb) -> Objects.isNull(id) || id < 1 ? null : cb.equal(root.get(relationName).get("id"), id);
    }
}
