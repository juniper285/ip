package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand() {}

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.getList(ui);
        ui.showTaskNumber(tasks);
    }
}
