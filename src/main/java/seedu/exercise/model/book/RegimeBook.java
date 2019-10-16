package seedu.exercise.model.book;

import seedu.exercise.model.regime.Regime;

/**
 * Wraps all data at the regime-book level
 * Duplicates are not allowed (by .isSameRegime comparison)
 */
public class RegimeBook extends ReadOnlyResourceBook<Regime> {

    public RegimeBook() {

    }

    public RegimeBook(ReadOnlyResourceBook<Regime> toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * /**
     * Returns the index of regime in regime book.
     */
    public int getRegimeIndex(Regime regime) {
        int i = 0;
        for (Regime r : resources) {
            if (r.equals(regime)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return resources.asUnmodifiableObservableList().size() + " regimes";
        // TODO: refine later
    }
}
