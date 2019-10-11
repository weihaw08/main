package seedu.exercise.model.exercise;

/**
 * Encapsulates the different validation regex that help to check if an input is correct.
 */
public enum ValidationRegex {
    ONLY_NUMBERS("\\d+(\\.\\d+)?"),
    ONLY_ALPHABETS_AND_SPACE("^[ A-Za-z]+$"),
    ONLY_ALPHABETS("^[A-Za-z]+$");

    private final String validationRegex;

    ValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    /**
     * Returns the string representation of the {@code ValidationRegex} instance.
     *
     * @return a validation regex that corresponds to the instance invoking this method
     */
    public String getRegex() {
        return this.validationRegex;
    }
}
