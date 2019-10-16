package seedu.exercise.model.regime;

import seedu.exercise.model.Resource;
import seedu.exercise.model.UniqueList;

/**
 * A list of regimes that enforces uniqueness between its elements and does not allow nulls.
 * A regime is considered unique by comparing using {@code Regime#isSameRegime(Regime)}.
 * As such, adding and updating of regimes uses Regime#isSameRegime(Regime) for equality so as to ensure that
 * the regime being added or updated is unique in terms of identity in the UniqueRegimeList.
 * <p>
 * Supports a minimal set of list operations.
 *
 * @see Regime#isSameResource(Resource)
 */
public class UniqueRegimeList extends UniqueList<Regime> {

}
