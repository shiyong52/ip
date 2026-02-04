
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artemis {

    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleUI.displayWelcomeScreen();

            while (true) {
                String userInput = ConsoleUI.readUserInput(scanner);

                String[] parts = userInput.split(" ");
                String command = parts[0];

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
                    index = Integer.parseInt(parts[1]) - 1;
                    task = list.get(index);
                    task.markAsDone();
                    ConsoleUI.showTaskMarked(task, true);
                    break;
                case "unmark":
                    index = Integer.parseInt(parts[1]) - 1;
                    task = list.get(index);
                    task.markAsNotDone();
                    ConsoleUI.showTaskMarked(task, true);
                    break;
                case "todo":
                    description = userInput.substring(5);
                    ToDo todo = new ToDo(description);
                    list.add(todo);
                    ConsoleUI.showAdded(todo, list.size());
                    break;
                case "deadline":
                    content = userInput.substring(9);
                    String[] part = content.split(" /by ", 2);
                    description = part[0];
                    String by = part[1];
                    Deadline deadline = new Deadline(description, by);
                    list.add(deadline);
                    ConsoleUI.showAdded(deadline, list.size());
                    break;
                case "event":
                    content = userInput.substring(6);
                    String[] part1 = content.split(" /from ", 2);
                    description = part1[0];
                    String[] part2 = part1[1].split(" /to ",2);
                    String from = part2[0];
                    String to = part2[1];
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
