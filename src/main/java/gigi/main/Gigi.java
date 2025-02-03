import gigi.commands.Command;
import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class Gigi {
    private static final String FILE_PATH = "./data/Gigi.txt";

    private Storage storage;
    private Tasklist tasks;
    private Ui ui;

    public Gigi(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new Tasklist();
            tasks.getTasks(storage);
        } catch (GigiException e) {
            ui.showLoadingError();
            System.out.println("DEBUG: Error loading tasks - " + e.getMessage());
            tasks = new Tasklist();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c;
                c = Parser.parse(fullCommand);
                c.execute(tasks,ui,storage);
                isExit = c.isExit();
            } catch (GigiException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Gigi(FILE_PATH).run();
    }
}