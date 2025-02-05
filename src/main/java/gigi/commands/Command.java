package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

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