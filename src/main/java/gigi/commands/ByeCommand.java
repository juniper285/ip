package main.java.commands;

import main.java.tasks.Tasklist;
import main.java.ui.Ui;
import main.java.storage.Storage;
import main.java.exceptions.GigiException;

/**
 * Represents a command to exit the Gigi chatbot.
 * This command is triggered when the user inputs "bye".
 */

public class ByeCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    /**
     * Constructs a ByeCommand.
     */
    public ByeCommand() {}

    /**
     * Executes the exit command.
     * Saves the task list before displaying a farewell message.
     *
     * @param tasks   The task list whose state needs to be saved.
     * @param ui      The UI component for displaying messages.
     * @param storage The storage component for saving tasks before exit.
     * @throws GigiException If an error occurs while saving tasks.
     */
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.saveTasks(storage);
        ui.showByeMessage();
    }
}
