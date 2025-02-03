package gigi.command;

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
        ui.showMessage(String.format("Now you have %d task(s) in the list.", tasks.getSize()));
    }
}
