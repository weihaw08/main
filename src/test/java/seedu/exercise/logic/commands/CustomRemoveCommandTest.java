package seedu.exercise.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.exercise.model.util.DefaultPropertyBookUtil.getDefaultPropertyBook;
import static seedu.exercise.testutil.Assert.assertThrows;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_END_DATE;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_REMARK;
import static seedu.exercise.testutil.typicalutil.TypicalCustomProperties.REMARK;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.exercise.logic.commands.exceptions.CommandException;
import seedu.exercise.model.Model;
import seedu.exercise.model.ModelManager;
import seedu.exercise.model.ReadOnlyResourceBook;
import seedu.exercise.model.UserPrefs;
import seedu.exercise.model.resource.Exercise;
import seedu.exercise.testutil.builder.ExerciseBookBuilder;
import seedu.exercise.testutil.builder.ExerciseBuilder;

public class CustomRemoveCommandTest {

    private Model model;

    @BeforeEach
    public void reset() {
        //reset the custom properties
        getDefaultPropertyBook().clearCustomProperties();
        Map<String, String> customPropertiesMap = Map.of("Remark", "Text");
        Exercise exercise = new ExerciseBuilder().withCustomProperties(customPropertiesMap).build();
        ReadOnlyResourceBook<Exercise> exerciseBook = new ExerciseBookBuilder().withExercise(exercise).build();
        model = new ModelManager(exerciseBook, new ReadOnlyResourceBook<>(), new ReadOnlyResourceBook<>(),
            new ReadOnlyResourceBook<>(), new UserPrefs(), getDefaultPropertyBook());
        model.getPropertyBook().addCustomProperty(REMARK);
    }

    @Test
    public void constructor_withNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomRemoveCommand(null));
    }

    @Test
    public void execute_customPropertyRemoved_success() throws CommandException {
        CustomRemoveCommand customRemoveCommand = new CustomRemoveCommand(VALID_FULL_NAME_REMARK);
        String commandResult = customRemoveCommand.execute(model).getFeedbackToUser();

        // Expected result
        Exercise updatedExercise = new ExerciseBuilder().build();
        ReadOnlyResourceBook<Exercise> updatedExerciseBook =
            new ExerciseBookBuilder().withExercise(updatedExercise).build();
        String expectedMessage = String.format(CustomRemoveCommand.MESSAGE_SUCCESS, VALID_FULL_NAME_REMARK);
        Model expectedModel = new ModelManager(updatedExerciseBook, new ReadOnlyResourceBook<>(),
            new ReadOnlyResourceBook<>(), new ReadOnlyResourceBook<>(),
            new UserPrefs(), getDefaultPropertyBook());

        assertEquals(commandResult, expectedMessage);
        assertEquals(model, expectedModel);
    }

    @Test
    public void execute_fullNameNotUsed_throwsCommandException() {
        CustomRemoveCommand customRemoveCommand = new CustomRemoveCommand("Date");
        assertThrows(CommandException.class, () -> customRemoveCommand.execute(model));
    }

    @Test
    public void equals() {
        CustomRemoveCommand removeRating = new CustomRemoveCommand(VALID_FULL_NAME_RATING);
        CustomRemoveCommand removeEndDate = new CustomRemoveCommand(VALID_FULL_NAME_END_DATE);
        CustomRemoveCommand anotherRemoveRating = new CustomRemoveCommand(VALID_FULL_NAME_RATING);

        // Same object -> true
        assertTrue(removeRating.equals(removeRating));

        // Same values -> true
        assertTrue(removeRating.equals(anotherRemoveRating));

        // Different values -> false
        assertFalse(removeRating.equals(removeEndDate));

        // Different object -> false
        assertFalse(removeRating.equals(3.5));

        // null -> false
        assertFalse(removeRating.equals(null));
    }
}
