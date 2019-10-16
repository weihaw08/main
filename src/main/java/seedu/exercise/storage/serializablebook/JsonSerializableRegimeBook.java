package seedu.exercise.storage.serializablebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.exercise.model.book.ReadOnlyResourceBook;
import seedu.exercise.model.regime.Regime;
import seedu.exercise.storage.resource.JsonAdaptedRegime;

/**
 * An Immutable RegimeBook that is serializable to JSON format.
 */
@JsonRootName(value = "regimebook")
public class JsonSerializableRegimeBook extends SerializableResourceBook<JsonAdaptedRegime> {

    /**
     * Constructs a {@code JsonSerializableRegimeBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableRegimeBook(@JsonProperty("jsonResources") List<JsonAdaptedRegime> regimes) {
        super(regimes);
    }

    /**
     * Converts a given {@code ReadOnlyResourceBook<Regime>} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableRegimeBook}.
     */
    public JsonSerializableRegimeBook(ReadOnlyResourceBook<Regime> source) {
        List<JsonAdaptedRegime> regimes = new ArrayList<>();
        regimes
            .addAll(source.getResourceList()
                .stream()
                .map(JsonAdaptedRegime::new)
                .collect(Collectors.toList()));
        jsonResources.addAll(regimes);
    }

}
