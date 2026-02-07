
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artemis {

    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleUI.displayWelcomeScreen();
            ConsoleUI.displayUserGuide();

            while (true) {
                String userInput = ConsoleUI.readUserInput(scanner);
                String command = ConsoleUI.readCommand(userInput);

                int index;
                String description;
                String content;
                Task task;

                switch (command) {
                case "bye":
                    ConsoleUI.displayFarewellScreen();
                    return;
                case "list":
                    ConsoleUI.showTaskList(list);
                    break;
                case "mark":
                    index = ConsoleUI.getIndex(userInput);
                    task = list.get(index);
                    task.markAsDone();
                    ConsoleUI.showTaskMarked(task, true);
                    break;
                case "unmark":
                    index = ConsoleUI.getIndex(userInput);
                    task = list.get(index);
                    task.markAsNotDone();
                    ConsoleUI.showTaskMarked(task, true);
                    break;
                case "todo":
                    description = userInput.substring(ConsoleUI.TODO_INDEX);
                    ToDo todo = new ToDo(description);
                    list.add(todo);
                    ConsoleUI.showAdded(todo, list.size());
                    break;
                case "deadline":
                    String[] deadlineContent = ConsoleUI.readContent(userInput, ConsoleUI.DEADLINE_INDEX);
                    description = deadlineContent[0];
                    String by = deadlineContent[1];

                    Deadline deadline = new Deadline(description, by);
                    list.add(deadline);
                    ConsoleUI.showAdded(deadline, list.size());
                    break;
                case "event":
                    String[] eventContent = ConsoleUI.readContent(userInput, ConsoleUI.EVENT_INDEX);
                    description = eventContent[0];
                    String from = eventContent[1];
                    String to = eventContent[2];

                    Event event = new Event(description, from, to);
                    list.add(event);
                    ConsoleUI.showAdded(event, list.size());
                    break;
                default:
                    task = new Task(userInput);
                    list.add(task);
                    ConsoleUI.showTaskAdded(userInput);
                    break;
                }

            }
        }

    }



}
