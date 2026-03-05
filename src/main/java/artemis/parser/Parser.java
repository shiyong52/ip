package artemis.parser;

import artemis.ArtemisException;
import java.util.Objects;

public class Parser {

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
}
