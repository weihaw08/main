package seedu.exercise.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_REMOVE_CUSTOM;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import seedu.exercise.commons.core.index.Index;
import seedu.exercise.logic.commands.exceptions.CommandException;
import seedu.exercise.model.Model;
import seedu.exercise.model.property.Calories;
import seedu.exercise.model.property.Date;
import seedu.exercise.model.property.Muscle;
import seedu.exercise.model.property.Name;
import seedu.exercise.model.property.Quantity;
import seedu.exercise.model.property.Unit;
import seedu.exercise.model.resource.Exercise;

/**
 * Removes the custom property with the given full name.
 */
public class CustomRemoveCommand extends CustomCommand {

    public static final String MESSAGE_USAGE_CUSTOM_REMOVE = "Parameters: "
        + PREFIX_REMOVE_CUSTOM + "FULL NAME\n"
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_REMOVE_CUSTOM + "Rating ";

    public static final String MESSAGE_SUCCESS = "Custom property removed: %1$s";
    public static final String MESSAGE_FULL_NAME_NOT_FOUND = "This full name is not used by an "
        + "existing custom property";

    private final String toRemove;
    private final Optional<Index> index;

    public CustomRemoveCommand(String toRemove, Optional<Index> index) {
        requireNonNull(toRemove);
        this.toRemove = toRemove;
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.isFullNameUsedByCustomProperty(toRemove)) {
            throw new CommandException(MESSAGE_FULL_NAME_NOT_FOUND);
        }

        if (index.isEmpty()) {
            model.removeCustomProperty(toRemove);
            updateCustomPropertiesOfAllExercises(model);
        } else {
            updateCustomPropertiesOfSingleExercise(model, index.get());
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, toRemove));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
            || (other instanceof CustomRemoveCommand)
            && (toRemove.equals(((CustomRemoveCommand) other).toRemove));
    }


    /**
     * Updates the old custom properties map of an exercise with the updated custom properties.
     *
     * @param oldPropertiesMap the old custom properties map of an exercise
     * @return a new map consisting of the updated custom properties
     */
    private Map<String, String> updateCustomPropertiesMap(Map<String, String> oldPropertiesMap) {
        Map<String, String> updatedMap = new TreeMap<>();
        Set<String> keySet = oldPropertiesMap.keySet();
        for (String property : keySet) {
            if (!property.equals(toRemove)) {
                updatedMap.put(property, oldPropertiesMap.get(property));
            }
        }
        return updatedMap;
    }

    /**
     * Updates the custom properties of the given {@code exercise}.
     *
     * @return a new {@code Exercise} object containing the updated custom properties. The other properties are
     *     kept the same.
     */
    private Exercise updateExerciseCustomProperty(Exercise exercise) {
        Name name = exercise.getName();
        Date date = exercise.getDate();
        Calories calories = exercise.getCalories();
        Quantity quantity = exercise.getQuantity();
        Unit unit = exercise.getUnit();
        Set<Muscle> muscles = exercise.getMuscles();
        Map<String, String> oldCustomProperties = exercise.getCustomPropertiesMap();
        Map<String, String> updatedCustomProperties = updateCustomPropertiesMap(oldCustomProperties);
        return new Exercise(name, date, calories, quantity, unit, muscles, updatedCustomProperties);
    }

    /**
     * Updates the custom properties of the exercise at the given index in the model.
     */
    private void updateCustomPropertiesOfSingleExercise(Model model, Index index) {
        Exercise oldExercise = model.getFilteredExerciseList().get(index.getZeroBased());
        Exercise updatedExercise = updateExerciseCustomProperty(oldExercise);
        model.setExercise(oldExercise, updatedExercise);
    }

    /**
     * Updates the custom properties of all the exercises in the given {@code model}.
     */
    private void updateCustomPropertiesOfAllExercises(Model model) {
        List<Exercise> exerciseList = model.getFilteredExerciseList();
        for (Exercise oldExercise : exerciseList) {
            Exercise updatedExercise = updateExerciseCustomProperty(oldExercise);
            model.setExercise(oldExercise, updatedExercise);
        }
    }
}
