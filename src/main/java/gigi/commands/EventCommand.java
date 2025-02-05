package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Events;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

import java.time.LocalDateTime;

public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";
    private final String description;
    private final LocalDateTime endTime;
    private final LocalDateTime startTime;

    public EventCommand(String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        Events event = new Events(description, startTime, endTime);
        tasks.addTask(event);

        tasks.saveTasks(storage);

        ui.showAddMessage();
        ui.showMessage(String.valueOf(event));
        ui.showTaskNumber(tasks);
    }
}
