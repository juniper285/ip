package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Task;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class UnmarkCommand extends Command {
    public static final String COMMAND_WORD = "unmark";
    public final int taskIndex;

    public UnmarkCommand(int i) {
        this.taskIndex = i - 1;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new GigiException("MEOW! You don't have that many tasks.");
        }

        Task unmarkedTask = tasks.getTask(taskIndex);
        tasks.markTaskAsUndone(taskIndex);
        tasks.saveTasks(storage);

        ui.showUndoneMessage();
        ui.showMessage(unmarkedTask.toString());
        ui.showMessage(String.format("Now you have %d task(s) in the list.", tasks.getSize()));
    }
}

