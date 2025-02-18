package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Events;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

import java.io.IOException;
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
    public String execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException, IOException {
        Events event = new Events(description, startTime, endTime);
        tasks.addTask(event);

        tasks.saveTasks(storage);

        return ui.showAddMessage() + "\n" +
                ui.showMessage(String.valueOf(event)) + "\n" +
                ui.showTaskNumber(tasks);
    }
}
