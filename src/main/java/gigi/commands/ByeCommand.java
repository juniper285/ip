package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class ByeCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public ByeCommand() {}

    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.saveTasks(storage);
        ui.showByeMessage();
    }
}
