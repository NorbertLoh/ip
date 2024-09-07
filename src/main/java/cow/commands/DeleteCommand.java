package cow.commands;

import cow.exceptions.CowExceptions;
import cow.filesaver.FileSaver;
import cow.message.Ui;
import cow.tasks.Task;
import cow.todolist.TodoList;

// solution below inspired by https://github.com/se-edu/addressbook-level2/tree/master

/** Creates a delete command object. **/
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public static final String COMMAND_EXAMPLE = "delete 1";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Delete an item from the todo list.\n"
            + "Example: " + COMMAND_EXAMPLE;

    private final int index;

    /**
     * Delete the item from the todolist based on the index entered.
     *
     * @param index of the todo list to delete starting from 1.
     */
    public DeleteCommand(int index) {
        assert index >= 0 : "index should be >= 0";
        this.index = index - 1;
    }

    /**
     * Deletes task using the index in the todo list.
     *
     * @param todoList the list of the tasks.
     * @param fileSaver filesaver object used to write data to txt.
     * @throws CowExceptions any exceptions that might arise from the implementation.
     */
    @Override
    public void execute(TodoList todoList, Ui ui, FileSaver fileSaver) throws CowExceptions {
        Task t = todoList.delete(this.index);
        fileSaver.saveData(todoList);
        ui.printDeletedTask(t, todoList);
    }
}
