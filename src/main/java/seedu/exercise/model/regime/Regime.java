package seedu.exercise.model.regime;

import java.util.Objects;

import seedu.exercise.model.Resource;
import seedu.exercise.model.exercise.Exercise;
import seedu.exercise.model.exercise.UniqueExerciseList;
import seedu.exercise.model.property.Name;

/**
 * Represents a Regime in the regime book.
 */
public class Regime extends Resource {
    private final Name regimeName;
    private final UniqueExerciseList regimeExercises;

    public Regime(Name regimeName, UniqueExerciseList regimeExercises) {
        this.regimeName = regimeName;
        this.regimeExercises = regimeExercises;
    }

    public void addExercise(Exercise exercise) {
        regimeExercises.add(exercise);
    }

    public void deleteExercise(Exercise exercise) {
        regimeExercises.remove(exercise);
    }

    public Name getRegimeName() {
        return regimeName;
    }

    /**
     * Returns true if both regimes have the same name.
     */
    public boolean isSameResource(Resource otherResource) {
        return this.equals(otherResource);
    }

    public UniqueExerciseList getRegimeExercises() {
        return regimeExercises;
    }

    @Override
    public String toString() {
        String str = "";
        int i = 1;
        for (Exercise e : regimeExercises) {
            str += "Exercise " + i + ": " + e.getName().toString() + "\n";
            i++;
        }
        return str;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
               || (other instanceof Regime)
               && regimeName.equals(((Regime) other).getRegimeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(regimeName, regimeExercises);
    }
}
