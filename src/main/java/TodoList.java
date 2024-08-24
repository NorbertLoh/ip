import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> todoList = new ArrayList<>();

    public TodoList() {

    }

    /**
     * Adds a new item to the todo list.
     * @param task A Task object to be added.
     * @return The update list of Todo items.
     */
    public ArrayList<Task> add(Task task) {
        todoList.add(task);
        return todoList;
    }

    /**
     * Get Task in TodoList
     * @param i The Index you want to retrieve
     * @return The Task at index i
     */
    public Task get(int i) {
        return todoList.get(i);
    }

    /**
     * Returns a string that consists of the number of tasks in the list.
     * @return A string that consists of the number of tasks in the list.
     */
    public String count() {
        return "Now you have " + this.todoList.size() + " tasks in the list.";
    }

    /**
     * Removes the task at the index.
     * @param i index of task to remove.
     * @return The removed Task.
     */
    public Task delete(int i) {
        return todoList.remove(i);
    }
    public String getSaveData() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < todoList.size(); i++) {
            result.append(todoList.get(i).getSaveData());
            if (i != todoList.size() - 1) result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        String string = "Here are the tasks in your list:\n";
        int size = this.todoList.size();
        for (int i = 0; i < size; i++) {
            string += String.format("%d.%s", i + 1, todoList.get(i));
            if (i != size - 1) {
                string += "\n";
            }
        }
        return string;
    }

}
