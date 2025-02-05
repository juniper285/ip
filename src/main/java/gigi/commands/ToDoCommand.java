package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Tasklist;
import main.java.tasks.ToDos;
import main.java.ui.Ui;

/**
 * Represents a command to add a ToDo task to the task list.
 * This command is triggered when the user inputs "todo" followed by a task description.
 */

public class ToDoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private final String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command to add a ToDo task to the task list.
     * If description is empty, an exception is thrown.
     * Otherwise, the task is added, saved, and a confirmation message is shown.
     *
     * @param tasks   The task list where the ToDo task will be added.
     * @param ui      The UI component responsible for displaying messages.
     * @param storage The storage component for saving tasks.
     * @throws GigiException If the task description is empty.
     */
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (description.isBlank()) {
            throw new GigiException("MEOW! A ToDo task cannot be empty.");
        }
        ToDos todo = new ToDos(description);
        tasks.addTask(todo);

        tasks.saveTasks(storage);

        ui.showAddMessage();
        ui.showMessage(String.valueOf(todo));
        ui.showTaskNumber(tasks);
    }
}
