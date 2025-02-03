public class ByeCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public ByeCommand() {}

    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.saveTasks(storage);
        ui.showByeMessage();
    }
}
