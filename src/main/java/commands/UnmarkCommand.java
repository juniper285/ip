package java.commands;

import java.exceptions.GigiException;
import java.storage.Storage;
import java.tasks.Task;
import java.tasks.Tasklist;
import java.ui.Ui;

/**
 * Represents a command to unmark a task as done in the task list.
 * This command is triggered when the user inputs "unmark" followed by a task index.
 */

public class UnmarkCommand extends Command {
    public static final String COMMAND_WORD = "unmark";
    private final int taskIndex;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     * The index is adjusted to be zero-based for internal processing.
     *
     * @param i The 1-based task index provided by the user.
     */
    public UnmarkCommand(int i) {
        this.taskIndex = i - 1;
    }

    /**
     * Executes the command to unmark a task as done.
     * If the task index is invalid, an exception is thrown.
     * Otherwise, the task is updated, saved, and a confirmation message is shown.
     *
     * @param tasks   The task list where the task is located.
     * @param ui      The UI component responsible for displaying messages.
     * @param storage The storage component for saving task updates.
     * @throws GigiException If the task index is out of bounds.
     */
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new GigiException("MEOW! You don't have that many tasks.");
        }

        Task unmarkedTask = tasks.getTask(taskIndex);
        tasks.markTaskAsUndone(taskIndex);
        tasks.saveTasks(storage);

        ui.showUndoneMessage();
        ui.showMessage(unmarkedTask.toString());
        ui.showTaskNumber(tasks);
    }
}

