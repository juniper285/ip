package java.commands;

import java.exceptions.GigiException;
import java.storage.Storage;
import java.tasks.Tasklist;
import java.ui.Ui;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand() {}

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (tasks.isEmpty()) {
            ui.showMessage("MEOW!!! You have nothing to do.");
        } else {
            ui.showMessage("Don't forget what you have to do:");
            for (String task : tasks.getTaskList()) {
                ui.showMessage(task);
            }
        }
        ui.showTaskNumber(tasks);
    }
}
