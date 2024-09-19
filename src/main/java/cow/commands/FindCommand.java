package cow.commands;

import cow.exceptions.CowExceptions;
import cow.filesaver.FileSaver;
import cow.message.Ui;
import cow.todolist.TodoList;

// solution below inspired by https://github.com/se-edu/addressbook-level2/tree/master

/** Creates a Find command object. **/
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String COMMAND_EXAMPLE = "todo book";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Finds all task with argument in the description.\n"
            + "Example: " + COMMAND_EXAMPLE;

    private final String description;

    public FindCommand(String description) {
        this.description = description.trim();
    }


    /**
     * Finds all matching description in todo list.
     *
     * @param todoList the list of the tasks.
     * @param fileSaver filesaver object used to write data to txt.
     * @throws CowExceptions any exceptions that might arise from the implementation.
     */
    @Override
    public void execute(TodoList todoList, Ui ui, FileSaver fileSaver) throws CowExceptions {
        TodoList filtered = todoList.getFilteredByDesc(this.description);
        ui.printFindTask(filtered);
    }
}
