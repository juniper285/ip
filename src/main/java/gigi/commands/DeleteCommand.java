package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Task;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public final int taskIndex;

    public DeleteCommand(int i) {
        this.taskIndex = i - 1;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new GigiException("MEOW! You don't have that many tasks.");
        }

        Task removedTask = tasks.getTask(taskIndex);
        tasks.deleteTask(taskIndex);
        tasks.saveTasks(storage);

        ui.showDelMessage();
        ui.showMessage(removedTask.toString());
        ui.showTaskNumber(tasks);
    }
}
