package duke.commands;

import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.UI;

public class IncorrectCommand extends Command {

    /**
     * Informs the user that the command is not recognised.
     *
     * @param taskList placeholder to match parameters defined in parent abstract class Command
     * @param ui the ui to display incorrect command message
     * @param storage placeholder to match parameters defined in parent abstract class Command
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.incorrectCommandMessage();
    }

    /**
     * Prevents the program from terminating in Duke.run().
     *
     * @return False as this is not the 'exit' command
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
