package artemis.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks in Artemis.
 * Provides operations to add, remove, mark, unmark, and search tasks.
 */
public class TaskList {
    private List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Mark the task at specified index as done.
     *
     * @param index Index of the task to mark.
     * @return The task that was marked as done.
     */
    public Task mark(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
        return task;
    }

    /**
     * Unmark the task at specified index as not done.
     *
     * @param index Index of the task to unmark.
     * @return The task that was unmarked as not done.
     */
    public Task unmark(int index) {
        Task task = tasks.get(index);
        task.markAsNotDone();
        return task;
    }

    /**
     * Find all tasks containing the given keyword
     *
     * @param keyword Keyword to search for.
     * @return A list of tasks that contain the keyword.
     */
    public List<Task> find(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

}
