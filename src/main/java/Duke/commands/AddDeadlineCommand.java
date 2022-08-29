package Duke.commands;

import Duke.exceptions.DukeException;
import Duke.storage.Storage;
import Duke.tasks.Deadline;
import Duke.tasks.TaskList;
import Duke.ui.UI;

import java.time.LocalDateTime;

public class AddDeadlineCommand extends Command {

    private final String input;

    public AddDeadlineCommand(String input) throws DukeException {
        if (!checkValid(input)) throw new DukeException(" ☹ OOPS!!! The description of a deadline cannot be empty.");
        if (!input.contains("/by")) throw new DukeException(" ☹ OOPS!!! Please enter in the format : \n" +
                "     deadline {task description} /by {day / date : YYYY-MM-DD / time}");
        this.input = input;
    }

    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) {
        String taskDesc = input.substring(9, input.indexOf('/') - 1);
        StringBuilder date = new StringBuilder(input.substring(input.indexOf('/') + 3));
        String[] dateArray = date.toString().split(" ");
        if (isDate(dateArray[0])) {
            LocalDateTime ld = LocalDateTime.parse(dateArray[0]);
            date = new StringBuilder(ld.format(DTF) + "  " + ld.getDayOfWeek());
            for (int i = 1; i < dateArray.length; i++) {
                date.append(" ").append(dateArray[i]);
            }
        }
        Deadline deadline = new Deadline(taskDesc, date.toString());
        taskList.addTask(deadline);
        ui.addTaskMessage(deadline, taskList.size());
        storage.store(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
