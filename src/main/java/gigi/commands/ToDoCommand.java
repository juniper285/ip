package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Tasklist;
import main.java.tasks.ToDos;
import main.java.ui.Ui;

public class ToDoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private final String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

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
