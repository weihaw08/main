package seedu.exercise.model.property;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_CUSTOM_NAME;
import static seedu.exercise.testutil.Assert.assertThrows;
import static seedu.exercise.testutil.CommonTestData.INVALID_FULL_NAME_DESC;
import static seedu.exercise.testutil.CommonTestData.INVALID_PREFIX_NAME_DESC;
import static seedu.exercise.testutil.CommonTestData.NUMBER_SLASH;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_REMARK;
import static seedu.exercise.testutil.CommonTestData.VALID_PARAMETER_TYPE_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_PREFIX_NAME_RATING;
import static seedu.exercise.testutil.typicalutil.TypicalCustomProperties.ENDDATE;
import static seedu.exercise.testutil.typicalutil.TypicalCustomProperties.INSTRUCTIONS;
import static seedu.exercise.testutil.typicalutil.TypicalCustomProperties.PRIORITY;

import org.junit.jupiter.api.Test;

import seedu.exercise.logic.parser.Prefix;
import seedu.exercise.testutil.builder.CustomPropertyBuilder;

class CustomPropertyTest {

    @Test
    public void constructor_withNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomProperty(null, VALID_FULL_NAME_REMARK,
            ParameterType.TEXT));
        assertThrows(NullPointerException.class, () -> new CustomProperty(PREFIX_CUSTOM_NAME, null,
            ParameterType.TEXT));
        assertThrows(NullPointerException.class, () -> new CustomProperty(PREFIX_CUSTOM_NAME, VALID_FULL_NAME_REMARK,
            null));
    }

    @Test
    public void constructor_invalidPrefixName_throwsIllegalArgumentException() {
        // No punctuation allowed
        assertThrows(IllegalArgumentException.class, () -> new CustomProperty(new Prefix("$/"),
            VALID_FULL_NAME_REMARK, ParameterType.TEXT));

        // No numbers allowed
        assertThrows(IllegalArgumentException.class, () -> new CustomProperty(NUMBER_SLASH,
            VALID_FULL_NAME_REMARK, ParameterType.TEXT));
    }

    @Test
    public void constructor_invalidFullName_throwsIllegalArgumentException() {

    }

    @Test
    public void execute_isValidFullName_success() {
        assertTrue(CustomProperty.isValidFullName(VALID_FULL_NAME_REMARK));
    }

    @Test
    public void execute_isValidFullName_failure() {
        assertFalse(CustomProperty.isValidFullName(INVALID_FULL_NAME_DESC));
    }

    @Test
    public void execute_isValidPrefixName_success() {
        assertTrue(CustomProperty.isValidPrefixName(VALID_PREFIX_NAME_RATING));
    }

    @Test
    public void execute_isValidPrefixName_failure() {
        assertFalse(CustomProperty.isValidPrefixName(INVALID_PREFIX_NAME_DESC));
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(INSTRUCTIONS.equals(INSTRUCTIONS));

        // null -> returns false
        assertFalse(INSTRUCTIONS.equals(null));

        // same values -> returns true
        CustomProperty customPropertyCopy = new CustomPropertyBuilder(INSTRUCTIONS).build();
        assertTrue(INSTRUCTIONS.equals(customPropertyCopy));

        // different type -> returns false
        assertFalse(INSTRUCTIONS.equals(5));

        // different custom property -> returns false
        assertFalse(INSTRUCTIONS.equals(ENDDATE));

        // different prefix -> returns false
        CustomProperty editedPriority = new CustomPropertyBuilder(PRIORITY)
            .withPrefix(VALID_PREFIX_NAME_RATING).build();
        assertFalse(INSTRUCTIONS.equals(editedPriority));

        // different full name -> returns false
        editedPriority = new CustomPropertyBuilder(INSTRUCTIONS).withFullName(VALID_FULL_NAME_RATING).build();
        assertFalse(INSTRUCTIONS.equals(editedPriority));

        // different parameter type -> returns false
        editedPriority = new CustomPropertyBuilder(INSTRUCTIONS).withParameterType(VALID_PARAMETER_TYPE_RATING).build();
        assertFalse(INSTRUCTIONS.equals(editedPriority));

    }

}
