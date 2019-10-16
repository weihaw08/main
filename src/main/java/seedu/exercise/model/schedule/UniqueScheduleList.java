package seedu.exercise.model.schedule;

import seedu.exercise.model.Resource;
import seedu.exercise.model.UniqueList;

/**
 * A list of schedules that enforces uniqueness between its elements and does not allow nulls.
 * A schedule is considered unique by comparing using {@code Schedule#isSameSchedule(Schedule)}.
 * As such, adding and updating of schedules uses Schedule#isSameSchedule(Schedule) for equality so as to ensure that
 * the schedule being added does not have any potential scheduling conflicts.
 * <p>
 * Supports a minimal set of list operations.
 *
 * @see Schedule#isSameResource(Resource)
 */
public class UniqueScheduleList extends UniqueList<Schedule> {


}
