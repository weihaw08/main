package seedu.exercise.model.util;

import static seedu.exercise.logic.parser.CliSyntax.PREFIX_CALORIES;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_MUSCLE;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_UNIT;
import static seedu.exercise.model.exercise.Calories.PROPERTY_CALORIES;
import static seedu.exercise.model.exercise.Date.PROPERTY_DATE;
import static seedu.exercise.model.exercise.Name.PROPERTY_NAME;
import static seedu.exercise.model.exercise.Quantity.PROPERTY_QUANTITY;
import static seedu.exercise.model.exercise.Unit.PROPERTY_UNIT;
import static seedu.exercise.model.tag.Muscle.PROPERTY_MUSCLE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.exercise.logic.parser.Prefix;
import seedu.exercise.model.exercise.CustomProperty;
import seedu.exercise.model.exercise.PropertyManager;

/**
 * Contains utility methods for initialising a default {@code PropertyManager}.
 */
public class DefaultPropertyManagerUtil {

    /**
     * Creates a new {@code PropertyManager} that contains the default short names, default full names and
     * an empty list of default custom properties.
     */
    public static PropertyManager getDefaultPropertyManager() {
        Set<Prefix> defaultShortNames = getDefaultShortNames();
        Set<String> defaultFullNames = getDefaultFullNames();
        List<CustomProperty> defaultCustomProperties = getDefaultCustomProperties();
        return new PropertyManager(defaultShortNames, defaultFullNames, defaultCustomProperties);
    }

    /**
     * Creates a new {@code Set<Prefix>} that contains all the short names of the default exercise properties.
     */
    private static Set<Prefix> getDefaultShortNames() {
        Set<Prefix> defaultShortNames = new HashSet<>();
        defaultShortNames.add(PREFIX_NAME);
        defaultShortNames.add(PREFIX_DATE);
        defaultShortNames.add(PREFIX_CALORIES);
        defaultShortNames.add(PREFIX_QUANTITY);
        defaultShortNames.add(PREFIX_MUSCLE);
        defaultShortNames.add(PREFIX_UNIT);
        return defaultShortNames;
    }

    /**
     * Creates a new {@code Set<String>} that contains all the full names of the default exercise properties.
     */
    private static Set<String> getDefaultFullNames() {
        Set<String> defaultFullNames = new HashSet<>();
        defaultFullNames.add(PROPERTY_NAME);
        defaultFullNames.add(PROPERTY_DATE);
        defaultFullNames.add(PROPERTY_CALORIES);
        defaultFullNames.add(PROPERTY_QUANTITY);
        defaultFullNames.add(PROPERTY_MUSCLE);
        defaultFullNames.add(PROPERTY_UNIT);
        return defaultFullNames;
    }

    /**
     * Creates a new empty {@code List<CustomProperty>}
     */
    private static List<CustomProperty> getDefaultCustomProperties() {
        return new ArrayList<>();
    }
}
