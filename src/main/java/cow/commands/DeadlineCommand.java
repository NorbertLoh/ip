package cow.commands;

import java.time.LocalDateTime;

import cow.exceptions.CowExceptions;
import cow.filesaver.FileSaver;
import cow.message.Ui;
import cow.tasks.Deadlines;
import cow.tasks.Task;
import cow.todolist.TodoList;

// solution below inspired by https://github.com/se-edu/addressbook-level2/tree/master

/** Creates a deadline command object. **/
public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    public static final String COMMAND_EXAMPLE = "deadline return book /by 2/12/2019 1800";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Deadline item to the list.\n"
            + "Example: " + COMMAND_EXAMPLE;

    private final LocalDateTime by;
    private final String description;

    /**
     * Creates a DeadlineCommand instance.
     *
     * @param description of the deadline task.
     * @param by LocalDateTime of the deadline.
     */
    public DeadlineCommand(String description, LocalDateTime by) {
        // remove any trailing while spaces to prevent saving spaces.
        this.description = description.trim();
        this.by = by;
    }

    /**
     * Creates a deadline task and adds to the todo list.
     *
     * @param todoList  the list of the tasks.
     * @param fileSaver filesaver object used to write data to txt.
     * @throws CowExceptions any exceptions that might arise from the implementation.
     */
    @Override
    public void execute(TodoList todoList, Ui ui, FileSaver fileSaver) throws CowExceptions {
        Task t = new Deadlines(this.description, this.by);
        todoList.add(t);
        fileSaver.saveData(todoList);
        ui.printAddedTask(t, todoList);
    }
}
