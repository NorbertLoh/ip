import java.util.Objects;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Create a new Todo object
     * @param description The description of the Todo Object
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Alternate constructor for loading isDone directly
     * @param isDone 1 or 0 indicating if task is done
     * @param description The Description of the Task
     */
    public Task(String isDone, String description) {
        this.description = description;
        this.isDone = isDone.equals("1");
    }

    public String getStatusIcon() {
        return (this.isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Mark the todo object as completed
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmark the todo object as completed
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    /**
     * A string that matches the format for writing it to file
     * @return A string to be written to a txt file
     */
    public String getSaveData() {
        String result = "";
        if (this.isDone) {
            result += "1";
        } else {
            result += "0";
        }
        return result + " | " + this.description;
    }
}
