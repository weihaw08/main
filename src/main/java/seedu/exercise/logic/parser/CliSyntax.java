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
    public static final Prefix PREFIX_CATEGORY = new Prefix("t/");
    public static final Prefix PREFIX_INDEX = new Prefix("i/");
    public static final Prefix PREFIX_SHORT_NAME = new Prefix("s/");
    public static final Prefix PREFIX_FULL_NAME = new Prefix("f/");
    public static final Prefix PREFIX_PARAMETER_TYPE = new Prefix("p/");

    /* A set consisting of prefix definitions for add and edit commands */
    public static final Set<Prefix> PREFIXES_SET = new HashSet<>();

    public static void setPrefixesSet(Set<Prefix> prefixes) {
        PREFIXES_SET.addAll(prefixes);
    }
}
