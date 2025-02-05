package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        Tasklist matchingTasks = new Tasklist();
        matchingTasks = tasks.getMatchingTasks(this.keyword);
        matchingTasks.getTaskList();

        if (matchingTasks.isEmpty()) {
            ui.showMessage("MEOW!!! There are no matching tasks.");
        } else {
            ui.showMessage("These are the matching tasks:");
            for (String task : tasks.getTaskList()) {
                ui.showMessage(task);
            }
        }
    }
}

