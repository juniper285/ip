package java.commands;

import java.exceptions.GigiException;
import java.storage.Storage;
import java.tasks.Task;
import java.tasks.Tasklist;
import java.ui.Ui;

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
