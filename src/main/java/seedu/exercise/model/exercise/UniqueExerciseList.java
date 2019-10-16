package seedu.exercise.model.exercise;

import seedu.exercise.model.Resource;
import seedu.exercise.model.UniqueList;

/**
 * A list of exercises that enforces uniqueness between its elements and does not allow nulls.
 * An exercise is considered unique by comparing using {@code Exercise#isSameExercise(Exercise)}.
 * As such, adding and updating of exercises uses Exercise#isSameExercise(Exercise) for equality so as to ensure that
 * the exercise being added or updated is unique in terms of identity in the UniqueExerciseList.
 * However, the removal of an exercise uses Exercise#equals(Object) so as to ensure that the exercise with exactly the
 * same fields will be removed.
 * <p>
 * Supports a minimal set of list operations.
 *
 * @see Exercise#isSameResource(Resource)
 */
public class UniqueExerciseList extends UniqueList<Exercise> {


}
