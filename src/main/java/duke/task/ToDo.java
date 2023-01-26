package duke.task;

/**
 * Subclass of duke.task.Task class used by duke.Duke to keep track of user's tasks inputted.
 *
 * @author Bo Kuan (LG17)
 * @version CS2103T AY22/23 Semester 2
 */

public class ToDo extends Task {

    /**
     * Constructor for a duke.task.ToDo.
     *
     * @param description String describing the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of a ToDO.
     *
     * @return The string representation of a ToDO.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String getFileFormatString() {
        //to be split using "|"
        return "T" + "@" + this.isDone + "@" + this.description;
    }
}
