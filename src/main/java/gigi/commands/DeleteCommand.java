package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Task;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

import java.io.IOException;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private final int taskIndex;

    public DeleteCommand(int i) {
        this.taskIndex = i - 1;
    }

    @Override
    public String execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException, IOException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new GigiException("MEOW! You don't have that many tasks.");
        }

        Task removedTask = tasks.getTask(taskIndex);
        tasks.deleteTask(taskIndex);
        tasks.saveTasks(storage);

        return ui.showDelMessage() + "\n" +
                ui.showMessage(removedTask.toString())+ "\n" +
                ui.showTaskNumber(tasks);
    }
}
