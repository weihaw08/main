package seedu.exercise.model.book;

import seedu.exercise.model.exercise.Exercise;

/**
 * Wraps all data at the exercise-book level
 * Duplicates are not allowed (by .isSameExercise comparison)
 */
public class ExerciseBook extends ReadOnlyResourceBook<Exercise> {

    public ExerciseBook() {

    }

    public ExerciseBook(ReadOnlyResourceBook<Exercise> toBeCopied) {
        this();
        resetData(toBeCopied);
    }
}
