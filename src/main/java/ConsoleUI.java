import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI {

    public static final String logo = """
             _         _                 _     
            / \\   _ __| |_ ___ _ __ ___ (_)___ 
           / _ \\ | '__| __/ _ \\ '_ ` _ \\| / __|
          / ___ \\| |  | ||  __/ | | | | | \\__ \\
         /_/   \\_\\_|   \\__\\___|_| |_| |_|_|___/
                                               
        """;

    public static final String LINE = "    ____________________________________________________________";

    public static String readUserInput(Scanner scanner) {
        System.out.println();
        System.out.print(Colors.BLUE);
        String userInput = scanner.nextLine();
        System.out.print(Colors.RESET);
        return userInput;
    }

    public static String readCommand(String userInput) {
        String[] parts = userInput.trim().split(" ");
        return parts[0];
    }

    public static int getIndex(String userInput, int listSize) throws ArtemisException {
        String[] parts = userInput.trim().split(" ");
        if (parts.length < 2) {
            throw new ArtemisException("Oopsie!! I can't read your mind. Add a TASK NUMBER or type menu to see how it works");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        if (index < 0 || index >= listSize) {
            throw new ArtemisException("TASK NUMBER DOES NOT EXIST, TRY AGAIN!!!!");
        }
        return index;
    }

    public static String getContent(String userInput) throws ArtemisException {
        String[] parts = userInput.trim().split(" ", 2);
        if (parts.length < 2) {
            throw new ArtemisException("Oopsie!! I can't read your mind. Type menu to see how it works");
        }
        return parts[1].trim();
    }

    public static String[] readContent(String userInput, String command) throws ArtemisException {
        String content = getContent(userInput);
        if (Objects.equals(command, "deadline")) {
            if (!content.contains(" /by ")) {
                throw new ArtemisException("PLEASE WRITE IT IN THIS WAY: \n deadline <task description> /by <date>");
            }
            return content.split(" /by ", 2);
        } else if (Objects.equals(command, "event")) {
            if (!content.contains(" /from ") || !content.contains(" /to ")) {
                throw new ArtemisException("PLEASE WRITE IT IN THIS WAY: \n event <event description> /from <start time> /to <end time>");
            }
            String[] fromSplit = content.split(" /from ", 2);
            String description = fromSplit[0];

            String[] toSplit = fromSplit[1].split(" /to ", 2);
            String from = toSplit[0];
            String to = toSplit[1];

            return new String[]{description, from, to};
        } else {
            throw new ArtemisException("Unknown index type");
        }

    }

    public static void displayFarewellScreen() {
        printLine();
        System.out.println("    " + Colors.RED + "Bye. Hope to see you again soon!" + Colors.RESET);
        printLine();
    }

    private static void printLine() {
        System.out.println(LINE);
    }

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
        System.out.println("    Mark task as done: done <task number>");
        System.out.println("    Delete task: delete <task number>");
        System.out.println("    Exit: bye");
        printLine();
    }

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

    public static void showTaskAdded(String input) {
        printLine();
        System.out.println("    " + Colors.RED + "added: " + input + Colors.RESET);
        printLine();
    }

    public static void showAdded(Task task, int taskCount) {
        printLine();
        System.out.println("    " + Colors.RED + "Got it. I've added this task: " + Colors.RESET);
        System.out.println("    " + Colors.RED + "  " + task + Colors.RESET);
        System.out.println("    " + Colors.RED + "Now you have " + taskCount + " tasks in the list. " + Colors.RESET);
        printLine();
    }
}
