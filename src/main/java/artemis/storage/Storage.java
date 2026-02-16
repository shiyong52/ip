package artemis.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import artemis.task.Task;
import artemis.task.Deadline;
import artemis.task.ToDo;
import artemis.task.Event;

public class Storage {
    private static final String FILE_PATH = "data/artemis.txt";

    public Storage(){
        createDataFolderIfMissing();
    }

    private void createDataFolderIfMissing(){
        File dir = new File("data");
        if (!dir.exists() && !dir.mkdirs()) {
            System.out.println("Warning: Failed to create data directory.");
        }
    }

    public List<Task> load() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()){
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                tasks.add(parseTask(currentLine));
            }
        } catch (IOException e){
            System.out.println("Error loading data.");
        }

        return tasks;
    }

    private Task parseTask(String line){
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task = switch (type) {
            case "T" -> new ToDo(description);
            case "D" -> new Deadline(description, parts[3]);
            case "E" -> new Event(description, parts[3], parts[4]);
            default -> throw new IllegalArgumentException("Unknown task type");
        };

        if (isDone) {
            task.markAsDone();
        }

        return task;
    }

    public void save(List<Task> tasks) {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Task task: tasks) {
                fw.write(taskToFileString(task) + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private String taskToFileString(Task task) {
        return task.toFileString();
    }
}
