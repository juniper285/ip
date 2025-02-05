package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Deadlines;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

import java.time.LocalDateTime;

public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    private final String description;
    private final LocalDateTime deadlineDate;

    public DeadlineCommand(String description, LocalDateTime deadlineDate) {
        this.description = description;
        this.deadlineDate = deadlineDate;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        Deadlines deadline = new Deadlines(description, deadlineDate);
        tasks.addTask(deadline);

        tasks.saveTasks(storage);

        ui.showAddMessage();
        ui.showMessage(String.valueOf(deadline));
        ui.showTaskNumber(tasks);
    }
}
