public class ToDoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private final Task task;

    public ToDoCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.addTask(task);
        tasks.saveTasks(storage);
        ui.showAddMessage();
        ui.showMessage(String.valueOf(task));
        ui.showMessage(String.format("Now you have %d task(s) in the list.", tasks.getSize()));
    }
}
