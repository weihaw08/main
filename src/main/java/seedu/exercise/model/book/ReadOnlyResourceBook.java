package seedu.exercise.model.book;

import static java.util.Objects.requireNonNull;
import static seedu.exercise.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.exercise.model.Resource;
import seedu.exercise.model.UniqueList;

/**
 * Encapsulates a Resource Book that can contain {@code Resource} objects of type {@code T}.
 */
public class ReadOnlyResourceBook<T extends Resource> {

    protected final UniqueList<T> resources;

    {
        resources = new UniqueList<>();
    }

    public ReadOnlyResourceBook() {

    }

    public ReadOnlyResourceBook(ReadOnlyResourceBook<T> toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Sets the data of a {@code ReadOnlyResourceBook} with the {@code resources}.
     */
    public void setResources(List<T> resources) {
        requireNonNull(resources);
        this.resources.setAll(resources);
    }

    /**
     * Resets the data of a {@code ReadOnlyResourceBook} with the {@code newData}.
     */
    public void resetData(ReadOnlyResourceBook<T> newData) {
        requireNonNull(newData);
        setResources(newData.getResourceList());
    }

    /**
     * Returns true if the {@code ReadOnlyResourceBook} instance contains {@code resource}.
     */
    public boolean hasResource(T resource) {
        requireNonNull(resource);
        return resources.contains(resource);
    }

    /**
     * Adds {@code resource} into the {@code ReadOnlyResourceBook} instance.
     */
    public void addResource(T resource) {
        requireNonNull(resource);
        resources.add(resource);
    }

    /**
     * Replaces {@code target} with {@code editResource} in the {@code ReadOnlyResourceBook} instance.
     */
    public void setResource(T target, T editedResource) {
        requireAllNonNull(target, editedResource);
        resources.set(target, editedResource);
    }

    /**
     * Removes {@code key} from the {@code ReadOnlyResourceBook} instance.
     */
    public void removeResource(T key) {
        requireNonNull(key);
        resources.remove(key);
    }

    /**
     * Returns an unmodifiable list of {@code Resource} of type {@code T}.
     */
    public ObservableList<T> getResourceList() {
        return resources.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ReadOnlyResourceBook // instanceof handles nulls
            && resources.equals(((ReadOnlyResourceBook<T>) other).resources));
    }

    @Override
    public int hashCode() {
        return resources.hashCode();
    }
}
