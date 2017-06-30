package pro.metrus.fvsr.utils;

/**
 * This class provide only method which build binding result
 * redirect attribute name, for redirect to other pages with
 * validation errors
 */
public class BindingResultUtil {

    /**
     * Effective Java advice, util classes cannot be created
     */
    private BindingResultUtil() {
        throw new RuntimeException("BindingResult cannot be created");
    }

    /**
     * This method return attribute name for redirect to page with
     * validation errors
     *
     * @param formName Form name which contains errors
     * @return attribute name
     */
    public static String attributeName(final String formName) {
        return String.format("org.springframework.validation.BindingResult.%s", formName);
    }
}
