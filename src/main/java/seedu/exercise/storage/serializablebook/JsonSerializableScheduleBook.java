package seedu.exercise.storage.serializablebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.exercise.model.book.ReadOnlyResourceBook;
import seedu.exercise.model.schedule.Schedule;
import seedu.exercise.storage.resource.JsonAdaptedSchedule;

/**
 * An Immutable ScheduleBook that is serializable to JSON format.
 */
@JsonRootName(value = "schedulebook")
public class JsonSerializableScheduleBook extends SerializableResourceBook<JsonAdaptedSchedule> {

    @JsonCreator
    public JsonSerializableScheduleBook(@JsonProperty("jsonResources") List<JsonAdaptedSchedule> schedules) {
        super(schedules);
    }

    public JsonSerializableScheduleBook(ReadOnlyResourceBook<Schedule> source) {
        List<JsonAdaptedSchedule> schedules = new ArrayList<>();
        schedules
            .addAll(source.getResourceList()
                .stream()
                .map(JsonAdaptedSchedule::new)
                .collect(Collectors.toList()));
        jsonResources.addAll(schedules);
    }


}
