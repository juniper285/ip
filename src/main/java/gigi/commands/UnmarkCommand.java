package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Task;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

public class UnmarkCommand extends Command {
    public static final String COMMAND_WORD = "unmark";
    private final int taskIndex;

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
        ui.showTaskNumber(tasks);
    }
}

