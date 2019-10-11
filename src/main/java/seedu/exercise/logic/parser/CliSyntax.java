package seedu.exercise.logic.parser;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_DATE = new Prefix("d/");
    public static final Prefix PREFIX_CALORIES = new Prefix("c/");
    public static final Prefix PREFIX_QUANTITY = new Prefix("q/");
    public static final Prefix PREFIX_MUSCLE = new Prefix("m/");
    public static final Prefix PREFIX_UNIT = new Prefix("u/");
    public static final Prefix PREFIX_SHORT_NAME = new Prefix("s/");
    public static final Prefix PREFIX_FULL_NAME = new Prefix("f/");
    public static final Prefix PREFIX_PARAMETER_TYPE = new Prefix("p/");

    /* A set consisting of prefix definitions for exercise's properties */
    public static final Set<Prefix> PROPERTY_PREFIXES = new HashSet<>();

    public static void setPropertyPrefixes(Set<Prefix> prefixes) {
        PROPERTY_PREFIXES.addAll(prefixes);
    }
}
