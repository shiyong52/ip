package artemis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import artemis.storage.Storage;
import artemis.ui.ConsoleUI;
import artemis.task.Task;
import artemis.task.ToDo;
import artemis.task.Deadline;
import artemis.task.Event;

public class Artemis {

    public static final String BYE = "bye";
    public static final String LIST = "list";
    public static final String MARK = "mark";
    public static final String UNMARK = "unmark";
    public static final String TODO = "todo";
    public static final String DELETE = "delete";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String MENU = "menu";

    public static void main(String[] args) {
        //List<Task> list = new ArrayList<>();
        Storage storage = new Storage();
        List<Task> list = storage.load();

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
                    case BYE:
                        ConsoleUI.displayFarewellScreen();
                        return;
                    case LIST:
                        ConsoleUI.showTaskList(list);
                        break;
                    case MARK:
                        index = ConsoleUI.getIndex(userInput, list.size());
                        task = list.get(index);
                        task.markAsDone();
                        ConsoleUI.showTaskMarked(task, true);
                        storage.save(list);
                        break;
                    case UNMARK:
                        index = ConsoleUI.getIndex(userInput, list.size());
                        task = list.get(index);
                        task.markAsNotDone();
                        ConsoleUI.showTaskMarked(task, true);
                        storage.save(list);
                        break;
                    case TODO:
                        description = ConsoleUI.getContent(userInput);
                        ToDo todo = new ToDo(description);
                        list.add(todo);
                        ConsoleUI.showAdded(todo, list.size());
                        storage.save(list);
                        break;
                    case DELETE:
                        index = ConsoleUI.getIndex(userInput, list.size());
                        task = list.get(index);
                        list.remove(index);
                        ConsoleUI.showDeleted(task, list.size());
                        storage.save(list);
                        break;
                    case DEADLINE:
                        String[] deadlineContent = ConsoleUI.readContent(userInput, "deadline");
                        description = deadlineContent[0];
                        String by = deadlineContent[1];

                        Deadline deadline = new Deadline(description, by);
                        list.add(deadline);
                        ConsoleUI.showAdded(deadline, list.size());
                        storage.save(list);
                        break;
                    case EVENT:
                        String[] eventContent = ConsoleUI.readContent(userInput, "event");
                        description = eventContent[0];
                        String from = eventContent[1];
                        String to = eventContent[2];

                        Event event = new Event(description, from, to);
                        list.add(event);
                        ConsoleUI.showAdded(event, list.size());
                        storage.save(list);
                        break;
                    case MENU:
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

