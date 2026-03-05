package artemis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import artemis.storage.Storage;
import artemis.ui.ConsoleUI;
import artemis.parser.Parser;
import artemis.task.Task;
import artemis.task.TaskList;
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
        Storage storage = new Storage();
        TaskList tasksList = new TaskList(storage.load());

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleUI.displayWelcomeScreen();
            ConsoleUI.displayUserGuide();

            while (true) {
                try {
                    String userInput = ConsoleUI.readUserInput(scanner);
                    String command = Parser.readCommand(userInput);

                    int index;
                    String description;
                    Task task;

                    switch (command) {
                    case BYE:
                        ConsoleUI.displayFarewellScreen();
                        return;
                    case LIST:
                        ConsoleUI.showTaskList(tasksList.getTasks());
                        break;
                    case MARK:
                        index = Parser.getIndex(userInput, tasksList.size());
                        task = tasksList.get(index);
                        task.markAsDone();
                        ConsoleUI.showTaskMarked(task, true);
                        storage.save(tasksList.getTasks());
                        break;
                    case UNMARK:
                        index = Parser.getIndex(userInput, tasksList.size());
                        task = tasksList.get(index);
                        task.markAsNotDone();
                        ConsoleUI.showTaskMarked(task, false);
                        storage.save(tasksList.getTasks());
                        break;
                    case TODO:
                        description = Parser.getContent(userInput);
                        ToDo todo = new ToDo(description);
                        tasksList.add(todo);
                        ConsoleUI.showAdded(todo, tasksList.size());
                        storage.save(tasksList.getTasks());
                        break;
                    case DELETE:
                        index = Parser.getIndex(userInput, tasksList.size());
                        task = tasksList.get(index);
                        tasksList.remove(index);
                        ConsoleUI.showDeleted(task, tasksList.size());
                        storage.save(tasksList.getTasks());
                        break;
                    case DEADLINE:
                        String[] deadlineContent = Parser.readContent(userInput, DEADLINE);
                        description = deadlineContent[0];
                        String by = deadlineContent[1];

                        Deadline deadline = new Deadline(description, by);
                        tasksList.add(deadline);
                        ConsoleUI.showAdded(deadline, tasksList.size());
                        storage.save(tasksList.getTasks());
                        break;
                    case EVENT:
                        String[] eventContent = Parser.readContent(userInput, EVENT);
                        description = eventContent[0];
                        String from = eventContent[1];
                        String to = eventContent[2];

                        Event event = new Event(description, from, to);
                        tasksList.add(event);
                        ConsoleUI.showAdded(event, tasksList.size());
                        storage.save(tasksList.getTasks());
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

