
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
        
        List<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Colors.RED + "    Hello from\n" + logo+ Colors.RESET);
            System.out.println("    ____________________________________________________________");
            System.out.println(Colors.RED +"    Hello! I'm Artemis\n    What can I do for you?" + Colors.RESET);
            System.out.println("    ____________________________________________________________");
            
            while (true){
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
                    int count = 1;
                    for (String item: list){
                        System.out.println("    " + count + ". " + Colors.GREEN + item + Colors.RESET);
                        count++;
                    }
                    System.out.println("    ____________________________________________________________");
                } else {
                    list.add(userInput);
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    " +  Colors.RED + "added: " + userInput + Colors.RESET);
                    System.out.println("    ____________________________________________________________");
                }

            }
        }
        
    }
}
