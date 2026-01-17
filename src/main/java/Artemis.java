
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artemis {

    public static void main(String[] args) {
        String logo = """
             _         _                 _     
            / \\   _ __| |_ ___ _ __ ___ (_)___ 
           / _ \\ | '__| __/ _ \\ '_ ` _ \\| / __|
          / ___ \\| |  | ||  __/ | | | | | \\__ \\
         /_/   \\_\\_|   \\__\\___|_| |_| |_|_|___/
                                               
        """;

        List<Task> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Colors.RED + "    Hello from\n" + logo + Colors.RESET);
            System.out.println("    ____________________________________________________________");
            System.out.println(Colors.RED + "    Hello! I'm Artemis\n    What can I do for you?" + Colors.RESET);
            System.out.println("    ____________________________________________________________");

            while (true) {
                System.out.println();
                System.out.print(Colors.BLUE);
                String userInput = scanner.nextLine();
                System.out.print(Colors.RESET);

                if (userInput.equals("bye")) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.RED + "Bye. Hope to see you again soon!" + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                    break;
                }

                if (userInput.equals("list")) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.RED + "Here are the tasks in your list:" + Colors.RESET);
                    int count = 1;
                    for (Task task : list) {
                        System.out.println("    " + count + ". " + Colors.GREEN + task + Colors.RESET);
                        count++;
                    }
                    System.out.println("    ____________________________________________________________");
                } else if (userInput.startsWith("mark ")) {
                    int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    Task task = list.get(index);
                    task.markAsDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.RED + "Nice! I've marked this task as done:" + Colors.RESET);
                    System.out.println("    " + Colors.GREEN + "  " + task + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                } else if (userInput.startsWith("unmark ")) {
                    int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    Task task = list.get(index);
                    task.markAsNotDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.RED + "OK, I've marked this task as not done yet:" + Colors.RESET);
                    System.out.println("    " + Colors.GREEN + "  " + task + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                } else {
                    list.add(new Task(userInput));
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.RED + "added: " + userInput + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                }

            }
        }

    }
}
