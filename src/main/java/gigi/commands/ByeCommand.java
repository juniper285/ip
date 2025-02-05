package main.java.commands;

import main.java.tasks.Tasklist;
import main.java.ui.Ui;
import main.java.storage.Storage;
import main.java.exceptions.GigiException;

public class ByeCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public ByeCommand() {}

    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.saveTasks(storage);
        ui.showByeMessage();
    }
}
