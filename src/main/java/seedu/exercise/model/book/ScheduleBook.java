package seedu.exercise.model.book;

import seedu.exercise.model.schedule.Schedule;

/**
 * Wraps all data at the schedule-book level.
 * Conflicting schedules are not allowed.
 */
public class ScheduleBook extends ReadOnlyResourceBook<Schedule> {

    public ScheduleBook() {

    }

    public ScheduleBook(ReadOnlyResourceBook<Schedule> toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Returns the index of {@code schedule} in Schedule book.
     */
    public int getSchedulesIndex(Schedule schedule) {
        int i = 0;
        for (Schedule r : resources) {
            if (r.equals(schedule)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
