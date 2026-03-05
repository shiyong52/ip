package artemis.task;

/**
 * Represents a task in Artemis.
 * Stores the description and isDone status of the task.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    public abstract String toFileString();

    /**
     *  Constructs a Task with the given description.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task
     * @return "X" if done, " " if not done
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
