package duke.ui;

import java.util.ArrayList;
import java.util.Scanner;

import duke.task.Task;
import duke.tasklist.TaskList;

/**
 * This class encapsulates everything <code>Duke</code> Duke's interactions with the user.
 *
 * @author Bo Kuan (LG17)
 * @version CS2103T AY22/23 Semester 2
 */
public class Ui {
    /**
     * <code>Duke</code>'s logo.
     */
    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    /**
     * <code>Scanner</code> to take user input.
     */
    private static final String GREETING_MESSAGE = "\tHello! I'm Duke\n"
            + "\tWhat can I do for you?";
    private final Scanner scanner;
    private final String init_message = "Hello from\n" + Ui.LOGO;
    private final String marked_task_message = "\tNice! I've marked this task as done:\n\t  ";
    private final String unmarked_task_message = "\tOK, I've marked this task as not done yet:"
            + "\n\t  ";
    private final String added_task_message = "\tGot it. I've added this task:\n\t  ";
    private final String deleted_task_message = "\tNoted. I've removed this task:\n\t  ";
    private final String clear_task_message = "\tI have cleared the task list.";
    private final String bye_message = "\tBye. Hope to see you again soon!";
    private final String line_seperation = "\t___________________________________"
            + "_________________________";
    private final String loading_error_message = "Error loading file from storage.";
    /**
     * Constructor for <code>Duke</code>'s <code>Ui</code>.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads from <code>System.in</code> and returns input in <code>String</code> format.
     * @return Input in <code>String</code> format.
     */
    public String readCommand() {

        if (this.scanner.hasNextLine()) {
            String userInput = this.scanner.nextLine();
            makeSeperation();
            return userInput;
        }
        return null;
    }
    /**
     * Returns and prints <code>Duke</code>'s init message.
     * @return <code>Duke</code>'s init message
     */
    public String showInitMessage() {
        System.out.println(init_message);
        return init_message;
    }
    /**
     * Returns and prints the greeting message and a line separation.
     * @return <code>Duke</code>'s greeting message
     */
    public static String showGreeting() {
        System.out.println(GREETING_MESSAGE);
        return GREETING_MESSAGE;
    }
    /**
     * Returns and prints <code>Duke</code>'s marked-task message.
     * @return <code>Duke</code>'s marked-task message
     */
    public String showMarkedTask(String taskDescription) {
        String message = marked_task_message + taskDescription;
        System.out.println(message);
        return message;
    }
    /**
     * Returns and prints <code>Duke</code>'s unmarked-task message.
     * @return <code>Duke</code>'s unmarked-task message
     */
    public String showUnmarkedTask(String taskDescription) {
        String message = unmarked_task_message + taskDescription;
        System.out.println(message);
        return message;
    }
    /**
     * Returns and prints <code>Duke</code>'s added-task message.
     * @return <code>Duke</code>'s added-task message
     */
    public String showAddedTask(Task t, TaskList tl) {
        String message = added_task_message + t + getTaskListLengthString(tl);
        System.out.println(message);
        return message;
    }
    /**
     * Returns and prints <code>Duke</code>'s deleted-task message.
     * @return <code>Duke</code>'s deleted-task message
     */
    public String showDeletedTask(Task t, TaskList tl) {
        String message = deleted_task_message + t + getTaskListLengthString(tl);
        System.out.println(message);
        return message;
    }
    /**
     * Returns and prints <code>Duke</code>'s cleared-tasks message.
     * @return <code>Duke</code>'s cleared-tasks message
     */
    public String showClearTasksMessage() {
        System.out.println(clear_task_message);
        return clear_task_message;
    }
    /**
     * Returns and prints <code>Duke</code>'s goodbye message.
     * @return <code>Duke</code>'s goodbye message
     */
    public String showByeMessage() {
        System.out.println(bye_message);
        return bye_message;
    }

    /**
     * Returns and prints a numbered list <code>String</code>.
     * @param tasks <code>ArrayList</code> of <code>Task</code>s
     * @return Formatted <code>String</code> of list of <code>Task</code>s
     */
    public String showTaskListPretty(ArrayList<Task> tasks) {
        String toPrint = "";
        int i = 1;
        for (Task t : tasks) {
            toPrint += "\t" + (i) + ". " + t.toString() + "\n";
            i++;
        }
        System.out.println((toPrint));
        return toPrint;
    }

    /**
     * Prints <code>Duke</code>'s error response message.
     */
    public String showError(String e) {
        System.out.println(e);
        return e;
    }

    /**
     * Prints out a line separation.
     */
    public void makeSeperation() {
        System.out.println(line_seperation);
    }
    /**
     * Prints <code>Duke</code>'s loading-error-from-tasks.txt message.
     */
    public void showLoadingError() {
        System.out.println(loading_error_message);
        makeSeperation();
    }

    /**
     * Returns a formatted string of the number of items in a <code>TaskList</code>.
     * @param tl <code>TaskList</code> whose length to be measured
     * @return Formatted string of the number of items in a <code>TaskList</code>
     */
    public String getTaskListLengthString(TaskList tl) {
        return String.format("Now you have %d tasks in the list.",
                tl.getLength());
    }
}
