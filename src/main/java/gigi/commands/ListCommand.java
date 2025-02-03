package gigi.command;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand() {}

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException {
        tasks.getList(ui);
    }
}
