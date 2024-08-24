package cow.commands;

import cow.filesaver.FileSaver;
import cow.todoList.TodoList;
import cow.message.Message;

// solution below inspired by https://github.com/se-edu/addressbook-level2/tree/master

public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public void execute(TodoList todoList, FileSaver fileSaver) {
        Message.print(
                ListCommand.MESSAGE_USAGE
                        + "\n" + ByeCommand.MESSAGE_USAGE
                        + "\n" + TodoCommand.MESSAGE_USAGE
                        + "\n" + DeadlineCommand.MESSAGE_USAGE
                        + "\n" + EventCommand.MESSAGE_USAGE
                        + "\n" + MarkCommand.MESSAGE_USAGE
                        + "\n" + UnmarkCommand.MESSAGE_USAGE
                        + "\n" + DeleteCommand.MESSAGE_USAGE
                        + "\n" + DueCommand.MESSAGE_USAGE
                        + "\n" + HelpCommand.MESSAGE_USAGE
        );
    }
}
