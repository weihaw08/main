package seedu.exercise.logic.commands;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import seedu.exercise.commons.util.CollectionUtil;
import seedu.exercise.model.property.Calories;
import seedu.exercise.model.property.Date;
import seedu.exercise.model.property.Muscle;
import seedu.exercise.model.property.Name;
import seedu.exercise.model.property.Quantity;
import seedu.exercise.model.property.Unit;
import seedu.exercise.model.resource.Exercise;

public class EditExerciseDescriptor {
    private Name name;
    private Calories calories;
    private Date date;
    private Quantity quantity;
    private Unit unit;
    private Set<Muscle> muscles;
    private Map<String, String> customProperties;

    public EditExerciseDescriptor() {
    }

    /**
     * Copy constructor.
     * A defensive copy of {@code muscles} is used internally.
     */
    public EditExerciseDescriptor(EditExerciseDescriptor toCopy) {
        setName(toCopy.name);
        setCalories(toCopy.calories);
        setDate(toCopy.date);
        setQuantity(toCopy.quantity);
        setUnit(toCopy.unit);
        setMuscles(toCopy.muscles);
        setCustomProperties(toCopy.customProperties);
    }

    /**
     * A constructor that copies all of the information from an exercise.
     */
    public EditExerciseDescriptor(Exercise toEdit) {
        setName(toEdit.getName());
        setCalories(toEdit.getCalories());
        setDate(toEdit.getDate());
        setQuantity(toEdit.getQuantity());
        setUnit(toEdit.getUnit());
        setMuscles(toEdit.getMuscles());
        setCustomProperties(toEdit.getCustomPropertiesMap());
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, calories, date, quantity, unit, muscles, customProperties);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Optional<Name> getName() {
        return Optional.ofNullable(name);
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }

    public Optional<Calories> getCalories() {
        return Optional.ofNullable(calories);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Optional<Date> getDate() {
        return Optional.ofNullable(date);
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Optional<Quantity> getQuantity() {
        return Optional.ofNullable(quantity);
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Optional<Unit> getUnit() {
        return Optional.ofNullable(unit);
    }

    /**
     * Sets {@code muscles} to this object's {@code muscles}.
     * A defensive copy of {@code muscles} is used internally.
     */
    public void setMuscles(Set<Muscle> muscles) {
        this.muscles = (muscles != null) ? new HashSet<>(muscles) : null;
    }

    /**
     * Returns an unmodifiable muscle set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * Returns {@code Optional#empty()} if {@code muscles} is null.
     */
    public Optional<Set<Muscle>> getMuscles() {
        return (muscles != null) ? Optional.of(Collections.unmodifiableSet(muscles)) : Optional.empty();
    }

    /**
     * Returns an unmodifiable custom properties map, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * Returns {@code Optional#empty()} if {@code customProperties} is null.
     */
    public Optional<Map<String, String>> getCustomProperties() {
        return (customProperties != null) ? Optional.of(Collections.unmodifiableMap(customProperties))
            : Optional.empty();
    }

    /**
     * Sets {@code customProperties} to this object's {@code customProperties}.
     */
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = (customProperties != null) ? new TreeMap<>(customProperties) : null;
    }

    /**
     * Creates and returns a {@code Exercise} with the details of {@code exerciseToEdit}
     * edited with {@code editExerciseDescriptor}.
     */
    public static Exercise createEditedExercise(
        Exercise exerciseToEdit, EditExerciseDescriptor editExerciseDescriptor) {
        assert exerciseToEdit != null;

        Name updatedName = editExerciseDescriptor.getName().orElse(exerciseToEdit.getName());
        Calories updatedCalories = editExerciseDescriptor.getCalories().orElse(exerciseToEdit.getCalories());
        Date updatedDate = editExerciseDescriptor.getDate().orElse(exerciseToEdit.getDate());
        Quantity updatedQuantity = editExerciseDescriptor.getQuantity().orElse(exerciseToEdit.getQuantity());
        Unit updatedUnit = editExerciseDescriptor.getUnit().orElse(exerciseToEdit.getUnit());
        Set<Muscle> updatedMuscles = editExerciseDescriptor.getMuscles().orElse(exerciseToEdit.getMuscles());
        Map<String, String> updatedCustomProperties = new TreeMap<>(exerciseToEdit.getCustomPropertiesMap());
        Map<String, String> newCustomProperties = editExerciseDescriptor.getCustomProperties()
            .orElse(new TreeMap<>());
        updatedCustomProperties.putAll(newCustomProperties);

        return new Exercise(updatedName, updatedDate, updatedCalories, updatedQuantity, updatedUnit,
            updatedMuscles, updatedCustomProperties);
    }

    public Exercise buildEditedExercise() {
        return new Exercise(name, date, calories, quantity, unit, muscles, customProperties);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditExerciseDescriptor)) {
            return false;
        }

        // state check
        EditExerciseDescriptor e = (EditExerciseDescriptor) other;

        return getName().equals(e.getName())
            && getCalories().equals(e.getCalories())
            && getDate().equals(e.getDate())
            && getQuantity().equals(e.getQuantity())
            && getUnit().equals(e.getUnit())
            && getMuscles().equals(e.getMuscles())
            && getCustomProperties().equals(e.getCustomProperties());
    }
}
