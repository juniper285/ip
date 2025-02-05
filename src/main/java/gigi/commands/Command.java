package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

/**
 * Represents an abstract command in the Gigi chatbot.
 * All specific command types (e.g., adding, deleting, marking tasks) extend this class.
 */

public abstract class Command {

    /**
     * Executes the command with the given task list, UI, and storage.
     *
     * @param tasks   The task list containing all tasks.
     * @param ui      The UI instance for displaying messages.
     * @param storage The storage instance for saving tasks.
     * @throws GigiException If an error occurs during command execution.
     */
    public abstract void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException;

    public boolean isExit() {
        return false;
    }
}