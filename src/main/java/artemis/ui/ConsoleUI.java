package artemis.ui;

import java.util.List;
import java.util.Scanner;

import artemis.task.Task;

/**
 * Handles interactions with the user via the console.
 * Responsible for printing messages and reading user input.
 */
public class ConsoleUI {

    public static final String logo = """
             _         _                 _     
            / \\   _ __| |_ ___ _ __ ___ (_)___ 
           / _ \\ | '__| __/ _ \\ '_ ` _ \\| / __|
          / ___ \\| |  | ||  __/ | | | | | \\__ \\
         /_/   \\_\\_|   \\__\\___|_| |_| |_|_|___/
                                               
        """;

    public static final String LINE = "    ____________________________________________________________";

    /**
     * Reads a line of user input.
     * @param scanner Scanner object to read input from.
     * @return The user's input
     */
    public static String readUserInput(Scanner scanner) {
        System.out.println();
        System.out.print(Colors.BLUE);
        String userInput = scanner.nextLine();
        System.out.print(Colors.RESET);
        return userInput;
    }

    /**
     * Prints a farewell message
     */
    public static void displayFarewellScreen() {
        printLine();
        System.out.println("    " + Colors.RED + "Bye. Hope to see you again soon!" + Colors.RESET);
        printLine();
    }

    private static void printLine() {
        System.out.println(LINE);
    }

    /**
     * Prints a welcome message
     */
    public static void displayWelcomeScreen() {
        System.out.println(Colors.RED + "    Hello from\n" + logo + Colors.RESET);
        printLine();
        System.out.println(Colors.RED + "    Hello! I'm Artemis\n    What can I do for you?" + Colors.RESET);
        printLine();
    }

    public static void displayUserGuide() {
        printLine();
        System.out.println("    <<<<User Guide>>>>");
        System.out.println("    Add a Task: todo <task description>");
        System.out.println("    Add a Deadline: deadline <task description> /by <date>");
        System.out.println("    Add an Event: event <event description> /from <start time> /to <end time>");
        System.out.println("    List tasks: list");
        System.out.println("    Mark task as done: mark <task number>");
        System.out.println("    Unmark task as done: unmark <task number>");
        System.out.println("    Delete task: delete <task number>");
        System.out.println("    Exit: bye");
        printLine();
    }

    /**
     * Prints a list of tasks.
     *
     * @param list Tasks to display
     */
    public static void showTaskList(List<Task> list) {
        printLine();
        System.out.println("    " + Colors.RED + "Here are the tasks in your list:" + Colors.RESET);

        int count = 1;
        for (Task task : list) {
            System.out.println("    " + count + ". " + Colors.GREEN + task + Colors.RESET);
            count++;
        }

        printLine();
    }

    /**
     * Prints a message indicating that a task has been marked or unmarked
     *
     * @param task The task that was marked or unmarked
     * @param done True if the task was marked as done; false if unmarked
     */
    public static void showTaskMarked(Task task, boolean done) {
        printLine();
        if (done) {
            System.out.println("    " + Colors.RED + "Nice! I've marked this task as done:" + Colors.RESET);
        } else {
            System.out.println("    " + Colors.RED + "OK, I've marked this task as not done yet:" + Colors.RESET);
        }
        System.out.println("    " + Colors.GREEN + "  " + task + Colors.RESET);
        printLine();
    }

    /**
     * Prints a message indicating that a task has been added to the list.
     *
     * @param task The task that was added.
     * @param taskCount The total number of tasks in the list after adding.
     */
    public static void showAdded(Task task, int taskCount) {
        printLine();
        System.out.println("    " + Colors.RED + "Got it. I've added this task: " + Colors.RESET);
        System.out.println("    " + Colors.RED + "  " + task + Colors.RESET);
        System.out.println("    " + Colors.RED + "Now you have " + taskCount + " tasks in the list. " + Colors.RESET);
        printLine();
    }

    /**
     * Prints a message indicating that a task has been deleted from the list.
     *
     * @param task The task that was removed.
     * @param taskCount The total number of tasks remaining in the list after deletion.
     */
    public static void showDeleted(Task task, int taskCount) {
        printLine();
        System.out.println("    " + Colors.RED + "Noted. I've removed this task: " + Colors.RESET);
        System.out.println("    " + Colors.GREEN + "  " + task + Colors.RESET);
        System.out.println("    " + Colors.RED + "Now you have " + taskCount + " tasks in the list. " + Colors.RESET);
        printLine();
    }
}
