public class MarkCommand extends Command {
    public static final String COMMAND_WORD = "mark";
    public final int taskIndex;

    public MarkCommand(int i) {
        this.taskIndex = i - 1;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new GigiException("MEOW! You don't have that many tasks.");
        }

        Task markedTask = tasks.getTask(taskIndex);
        tasks.markTaskAsDone(taskIndex);
        tasks.saveTasks(storage);

        ui.showDoneMessage();
        ui.showMessage(markedTask.toString());
        ui.showMessage(String.format("Now you have %d task(s) in the list.", tasks.getSize()));
    }
}

