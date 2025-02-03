package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Deadlines;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

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
