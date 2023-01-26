package duke.task;

import duke.exception.DukeBadInstructionFormatException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Subclass of duke.task.Task class used by duke.Duke to keep track of user's tasks inputted.
 *
 * @author Bo Kuan (LG17)
 * @version CS2103T AY22/23 Semester 2
 */

public class Deadline extends Task {

    /**
     * A string representing the deadline of the duke.task.Deadline instance.
     */
    private LocalDateTime by;

    private String byString;

    /**
     * Constructor for a duke.task.Deadline instance.
     *
     * @param description String describing this duke.task.Deadline.
     *
     * @param by deadline of this duke.task.Deadline.
     */
    public Deadline(String description, String by) throws DukeBadInstructionFormatException {
        super(description);

        try {
            this.byString = by;
            this.by = Task.getLocalDateTime(by);
        } catch (DateTimeParseException e) {
            throw new DukeBadInstructionFormatException("Use date/time format: " +
                    Task.STORE_DATE_TIME_FORMAT);
        }
    }

    /**
     * Returns the string representation of a duke.task.Deadline.
     *
     * @return The string representation of a duke.task.Deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Task.getDateTimeString(this.by) + ")";
    }

    @Override
    public String getFileFormatString() {
        //to be split using "|"
        return "D" + "@" + this.isDone + "@" + this.description + "@" + this.byString;
    }
}
