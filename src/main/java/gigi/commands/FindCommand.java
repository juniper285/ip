package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        Tasklist matchingTasks = new Tasklist();
        matchingTasks = tasks.getMatchingTasks(this.keyword);
        matchingTasks.getTaskList();

        if (matchingTasks.isEmpty()) {
            return ui.showMessage("MEOW!!! There are no matching tasks.");
        } else {
            //ui.showMessage("These are the matching tasks:");
            for (String task : tasks.getTaskList()) {
                return ui.showMessage(task);
            }
        }

        return "";
    }
}

