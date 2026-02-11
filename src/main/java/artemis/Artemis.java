package artemis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import artemis.ui.ConsoleUI;
import artemis.task.Task;
import artemis.task.ToDo;
import artemis.task.Deadline;
import artemis.task.Event;

public class Artemis {

    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleUI.displayWelcomeScreen();
            ConsoleUI.displayUserGuide();

            while (true) {
                try {
                    String userInput = ConsoleUI.readUserInput(scanner);
                    String command = ConsoleUI.readCommand(userInput);

                    int index;
                    String description;
                    Task task;

                    switch (command) {
                    case "bye":
                        ConsoleUI.displayFarewellScreen();
                        return;
                    case "list":
                        ConsoleUI.showTaskList(list);
                        break;
                    case "mark":
                        index = ConsoleUI.getIndex(userInput, list.size());
                        task = list.get(index);
                        task.markAsDone();
                        ConsoleUI.showTaskMarked(task, true);
                        break;
                    case "unmark":
                        index = ConsoleUI.getIndex(userInput, list.size());
                        task = list.get(index);
                        task.markAsNotDone();
                        ConsoleUI.showTaskMarked(task, true);
                        break;
                    case "todo":
                        description = ConsoleUI.getContent(userInput);
                        ToDo todo = new ToDo(description);
                        list.add(todo);
                        ConsoleUI.showAdded(todo, list.size());
                        break;
                    case "deadline":
                        String[] deadlineContent = ConsoleUI.readContent(userInput, "deadline");
                        description = deadlineContent[0];
                        String by = deadlineContent[1];

                        Deadline deadline = new Deadline(description, by);
                        list.add(deadline);
                        ConsoleUI.showAdded(deadline, list.size());
                        break;
                    case "event":
                        String[] eventContent = ConsoleUI.readContent(userInput, "event");
                        description = eventContent[0];
                        String from = eventContent[1];
                        String to = eventContent[2];

                        Event event = new Event(description, from, to);
                        list.add(event);
                        ConsoleUI.showAdded(event, list.size());
                        break;
                    case "menu":
                        ConsoleUI.displayUserGuide();
                        break;
                    default:
                        throw new ArtemisException("What's That??? I DON'T UNDERSTAND");
                    }
                } catch (ArtemisException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

