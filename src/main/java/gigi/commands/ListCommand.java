package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand() {}

    @Override
    public String execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (tasks.isEmpty()) {
            return ui.showMessage("MEOW!!! You have nothing to do.");
        } else {
            //ui.showMessage("Don't forget what you have to do:");
            for (String task : tasks.getTaskList()) {
                return ui.showMessage(task);
            }
        }
        return ui.showTaskNumber(tasks);
    }
}
