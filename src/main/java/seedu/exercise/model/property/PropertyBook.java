package seedu.exercise.model.property;

import static seedu.exercise.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.exercise.logic.parser.CliSyntax.setPropertyPrefixesSet;
import static seedu.exercise.model.util.DefaultPropertyBookUtil.getDefaultFullNames;
import static seedu.exercise.model.util.DefaultPropertyBookUtil.getDefaultPrefixes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.exercise.logic.parser.Prefix;

/**
 * Helps to keep track of all the existing prefixes and full names for both default and custom properties.
 * It also helps to keep track of all the existing custom properties that have been defined by the user.
 */
public class PropertyBook {
    private static final Set<CustomProperty> CUSTOM_PROPERTIES = new HashSet<>();

    // Helps to ensure that the prefixes used in add/edit command and full names of default
    // properties are always present.
    private final Set<Prefix> prefixes = getDefaultPrefixes();
    private final Set<String> fullNames = getDefaultFullNames();

    /**
     * Initialises an instance of {@code PropertyBook} object. If any full name/prefix are present in the custom
     * property but not in the prefixes
     *
     * @param customProperties the set of custom properties to be added to the {@code PropertyBook}
     */
    public PropertyBook(Set<CustomProperty> customProperties) {
        requireAllNonNull(customProperties);
        addCustomProperties(customProperties);
        setPrefixesAndFullNames(customProperties);
    }

    /**
     * Adds in all the custom properties that are present in the given {@code Set<CustomProperty> customProperties}
     * into the PropertyBook.
     *
     * @param customProperties the custom properties to be added
     */
    public void addCustomProperties(Set<CustomProperty> customProperties) {
        CUSTOM_PROPERTIES.addAll(customProperties);
        setPrefixesAndFullNames(customProperties);
    }

    /**
     * Clears all of the custom properties in PropertyBook.
     */
    public void clearCustomProperties() {
        CUSTOM_PROPERTIES.clear();
        prefixes.retainAll(getDefaultPrefixes());
        fullNames.retainAll(getDefaultFullNames());
    }

    /**
     * Returns an immutable custom properties set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public static Set<CustomProperty> getCustomProperties() {
        return Collections.unmodifiableSet(CUSTOM_PROPERTIES);
    }

    /**
     * Adds the newly defined custom property into the manager.
     */
    public void addCustomProperty(CustomProperty customProperty) {
        Prefix newPrefix = customProperty.getPrefix();
        String newFullName = customProperty.getFullName();
        addPrefix(newPrefix);
        addFullName(newFullName);
        CUSTOM_PROPERTIES.add(customProperty);
        updatePropertyPrefixes();
    }

    /**
     * Removes the custom property with the associated {@code fullName}, if such a custom property
     * exists.
     */
    public void removeCustomProperty(String fullName) {
        Optional<CustomProperty> toRemove = retrieveCustomProperty(fullName);
        if (toRemove.isPresent()) {
            removeCustomProperty(toRemove.get());
        }
    }

    /**
     * Removes the given {@code customProperty} and its associated prefix and full name from
     * PropertyBook.
     */
    private void removeCustomProperty(CustomProperty toRemove) {
        Prefix prefixToRemove = toRemove.getPrefix();
        String fullNameToRemove = toRemove.getFullName();
        removePrefix(prefixToRemove);
        removeFullName(fullNameToRemove);
        CUSTOM_PROPERTIES.remove(toRemove);
        updatePropertyPrefixes();
    }

    public void updatePropertyPrefixes() {
        setPropertyPrefixesSet(Collections.unmodifiableSet(prefixes));
    }


    /**
     * Checks if the prefix has already been used by a property.
     */
    public boolean isPrefixUsed(Prefix prefix) {
        return prefixes.contains(prefix);
    }

    /**
     * Checks if the full name has already been used by a property.
     */
    public boolean isFullNameUsed(String fullName) {
        return fullNames.contains(fullName);
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PropertyBook)) {
            return false;
        }

        PropertyBook anotherManager = (PropertyBook) other;
        return prefixes.equals(anotherManager.prefixes)
            && fullNames.equals(anotherManager.fullNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefixes, fullNames);
    }


    private void setPrefixesAndFullNames(Set<CustomProperty> customProperties) {
        for (CustomProperty property : customProperties) {
            this.addPrefix(property.getPrefix());
            this.addFullName(property.getFullName());
        }
    }

    /**
     * Adds the prefix of a newly defined custom property.
     */
    private void addPrefix(Prefix prefix) {
        prefixes.add(prefix);
    }

    /**
     * Adds the full name of a newly defined custom property.
     */
    private void addFullName(String fullName) {
        fullNames.add(fullName);
    }

    /**
     * Removes the prefix of a custom property from {@code prefixes}.
     */
    private void removePrefix(Prefix prefix) {
        prefixes.remove(prefix);
    }

    /**
     * Removes the full name of a custom property from {@code fullNames}.
     */
    private void removeFullName(String fullName) {
        fullNames.remove(fullName);
    }

    /**
     * Retrieves the custom property with the given {@code fullName}.
     */
    private Optional<CustomProperty> retrieveCustomProperty(String fullName) {
        Optional<CustomProperty> retrieved = Optional.empty();
        for (CustomProperty customProperty : CUSTOM_PROPERTIES) {
            if (customProperty.getFullName().equals(fullName)) {
                retrieved = Optional.of(customProperty);
                break;
            }
        }
        return retrieved;
    }
}
