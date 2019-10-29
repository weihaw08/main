package seedu.exercise.model.property;

import static seedu.exercise.testutil.Assert.assertThrows;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_RATING;
import static seedu.exercise.testutil.typicalutil.TypicalCustomProperties.RATING;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.exercise.logic.parser.Prefix;

public class PropertyBookTest {

    private Set<Prefix> prefixSet = Set.of(new Prefix("r/"));
    private Set<String> fullNamesSet = Set.of(VALID_FULL_NAME_RATING);
    private List<CustomProperty> customPropertiesList = List.of(RATING);
    // private PropertyBook propertyBook = new PropertyBook(prefixSet, fullNamesSet, customPropertiesList);

    @Test
    public void constructor_withNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PropertyBook(null, fullNamesSet,
            customPropertiesList));
        assertThrows(NullPointerException.class, () -> new PropertyBook(prefixSet, null,
            customPropertiesList));
        assertThrows(NullPointerException.class, () -> new PropertyBook(prefixSet, fullNamesSet,
            null));
    }




}
