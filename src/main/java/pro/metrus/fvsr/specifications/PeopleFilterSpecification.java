package pro.metrus.fvsr.specifications;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import pro.metrus.fvsr.domains.Person;
import pro.metrus.fvsr.forms.PeopleFilter;

import javax.persistence.criteria.Expression;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

/**
 * This specification using for filtering people by {@link pro.metrus.fvsr.forms.PeopleFilter}
 */
public class PeopleFilterSpecification {

    /**
     * This is database like mode, it's same "%STRING%"
     */
    private static final String LIKE_SEARCH_PATTERN="%%%s%%";

    /**
     * Return all people specifications
     *
     * @return Specifications
     */
    public static Specifications<Person> withAllSpecifications(final PeopleFilter filter) {
        requireNonNull(filter, "Filter must be not null! Given null!");

        /*
        TODO: Refactor to meta models
         */
        return Specifications
                .where(booleanPredicate("bmx", filter.isBmx()))
                .and(booleanPredicate("mb", filter.isMb()))
                .and(booleanPredicate("otherRole", filter.isOther()))
                .and(booleanPredicate("commissaire", filter.isCommissaire()))
                .and(booleanPredicate("federation", filter.isFederation()))
                .and(gender(filter))
                .and(booleanPredicate("rider", filter.isRider()))
                .and(booleanPredicate("road", filter.isRoad()))
                .and(booleanPredicate("teamMember", filter.isTeamMember()))
                .and(booleanPredicate("techincalDelegate", filter.isTechnical()))
                .and(booleanPredicate("track", filter.isTrack()))
                .and(numberIsNotNull("id", filter.getId()))
                .and(likeCondition("uci", filter.getUci()))
                .and(numberIsNotNull("oldId", filter.getOldId()))
                .or(likeCondition("lastname", filter.getSurname()))
                .or(likeCondition("lastnameEng", filter.getSurname()))
                .or(likeCondition("firstname", filter.getFirstname()))
                .or(likeCondition("firstnameEng", filter.getFirstname()))
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
    @NotNull
    @Contract(pure = true)
    private static Specification<Person> booleanPredicate(String columnName, boolean value) {
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
    @NotNull
    @Contract(pure = true)
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
    @NotNull
    @Contract(pure = true)
    private static Specification<Person> likeCondition(String columnName, String value) {
        return (root, cq, cb) -> {
            if (Objects.isNull(value) || value.isEmpty()) {
                return null;
            }

            final String pattern = String.format(LIKE_SEARCH_PATTERN, value.toUpperCase());
            final Expression<String> stringExpression = cb.toString(root.get(columnName));
            return cb.like(cb.upper(stringExpression), pattern);
        };
    }

    /**
     * Specification which filtering relations in entity
     *
     * @param relationName Relation name for filtering
     * @param id Relation id
     * @return specification
     */
    @NotNull
    @Contract(pure = true)
    private static Specification<Person> personRelationById(String relationName, Integer id) {
        return (root, cq, cb) -> Objects.isNull(id) || id < 1 ? null : cb.equal(root.get(relationName).get("id"), id);
    }

    /**
     * Gender specification
     *
     * @param filter People filter
     * @return specification
     */
    @NotNull
    @Contract(pure = true)
    private static Specification<Person> gender(final PeopleFilter filter) {
        return (root, cq, cb) -> {
            final Boolean gender = filter.getGender();
            if (Objects.isNull(gender)) {
                return null;
            }
            return cb.equal(root.get("gender"), gender);
        };
    }
}
