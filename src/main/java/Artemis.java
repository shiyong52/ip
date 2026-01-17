
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
        System.out.println(Colors.RED + "    Hello from\n" + logo+ Colors.RESET);
        System.out.println("    ____________________________________________________________");
        System.out.println(Colors.RED +"    Hello! I'm Artemis\n    What can I do for you?" + Colors.RESET);
        System.out.println("    ____________________________________________________________");


        try (Scanner scanner = new Scanner(System.in)) {
            while (true){
                System.out.println();
                String userInput = scanner.nextLine();
                if (userInput.equals("bye")) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " + Colors.GREEN + "Bye. Hope to see you again soon!" + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                    break;
                }
                System.out.println("    ____________________________________________________________");
                System.out.println("    " + Colors.BLUE + userInput + Colors.RESET);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
