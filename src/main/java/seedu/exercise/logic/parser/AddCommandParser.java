package seedu.exercise.logic.parser;

import static seedu.exercise.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_CALORIES;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_MUSCLE;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_UNIT;
import static seedu.exercise.logic.parser.CliSyntax.PROPERTY_PREFIXES;

import java.util.Map;
import java.util.Set;

import seedu.exercise.logic.commands.AddCommand;
import seedu.exercise.logic.parser.exceptions.ParseException;
import seedu.exercise.model.exercise.Calories;
import seedu.exercise.model.exercise.Date;
import seedu.exercise.model.exercise.Exercise;
import seedu.exercise.model.exercise.Name;
import seedu.exercise.model.exercise.Quantity;
import seedu.exercise.model.exercise.Unit;
import seedu.exercise.model.tag.Muscle;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PROPERTY_PREFIXES);

        if (!argMultimap.arePrefixesPresent(PREFIX_NAME, PREFIX_QUANTITY, PREFIX_DATE, PREFIX_CALORIES, PREFIX_UNIT)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Date date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        Calories calories = ParserUtil.parseCalories(argMultimap.getValue(PREFIX_CALORIES).get());
        Quantity quantity = ParserUtil.parseQuantity(argMultimap.getValue(PREFIX_QUANTITY).get());
        Unit unit = ParserUtil.parseUnit(argMultimap.getValue(PREFIX_UNIT).get());
        Set<Muscle> muscleList = ParserUtil.parseMuscles(argMultimap.getAllValues(PREFIX_MUSCLE));
        Map<String, String> customPropertiesMap =
            ParserUtil.parseCustomProperties(argMultimap.getAllCustomProperties());

        Exercise exercise = new Exercise(name, date, calories, quantity, unit, muscleList, customPropertiesMap);

        return new AddCommand(exercise);
    }
}
