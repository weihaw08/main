package seedu.exercise.storage.serializablebook;

import java.util.ArrayList;
import java.util.List;

import seedu.exercise.commons.exceptions.IllegalValueException;
import seedu.exercise.model.Resource;
import seedu.exercise.model.book.ReadOnlyResourceBook;
import seedu.exercise.storage.resource.JsonAdaptedResource;

/**
 * An immutable ResourceBook that is serializable to JSON format.
 * In particular, this resource book can be extended to create an immutable ResourceBook that holds
 * any {@code JsonAdaptedResource} of type {@code T}.
 */
public class SerializableResourceBook<T extends JsonAdaptedResource> {

    public static final String MESSAGE_DUPLICATE_RESOURCE = "The list has duplicate exercises/regimes/schedules.";

    protected final List<T> jsonResources = new ArrayList<>();

    public SerializableResourceBook() {

    }

    public SerializableResourceBook(List<T> jsonResources) {
        this.jsonResources.addAll(jsonResources);
    }

    /**
     * Converts the Jackson-friendly {@code SerializableResourceBook} into the model's {@code ReadOnlyResourceBook}.
     *
     * @throws IllegalValueException if there are any violations in the data constraints.
     */
    public <U extends Resource> ReadOnlyResourceBook<U> toModelType() throws IllegalValueException {
        ReadOnlyResourceBook<U> resourceBook = new ReadOnlyResourceBook<>();
        for (T jsonResource : jsonResources) {
            U resourceModel = jsonResource.toModelType();
            if (resourceBook.hasResource(resourceModel)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_RESOURCE);
            }
            resourceBook.addResource(resourceModel);
        }
        return resourceBook;
    }

}
