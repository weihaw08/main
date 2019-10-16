package seedu.exercise.model;

/**
 * Encapsulates the various resources that will be tracked by the app.
 * Resources tracked by the app are {@code Exercise}, {@code Regime}, {@code Schedule} and {@code CustomProperty}.
 */
public abstract class Resource {

    public abstract boolean isSameResource(Resource otherResource);

}
