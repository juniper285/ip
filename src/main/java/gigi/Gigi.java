package gigi;

import gigi.commands.Command;
import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

public class Gigi {
    private static final String FILE_PATH = "./data/Gigi.txt";
    private final Storage storage;
    private Tasklist tasks;
    private final Ui ui;

    public static void main(String[] args) {
        new Gigi(FILE_PATH).run();
    }

    public Gigi(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new Tasklist();
            tasks.getTasks(storage);
        } catch (GigiException e) {
            ui.showLoadingError();
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
                Command c = Parser.parse(fullCommand);
                c.execute(tasks,ui,storage);
                isExit = c.isExit();
            } catch (GigiException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return "";
            //return c.execute(tasks, ui, storage);
        } catch (GigiException e) {
            return "Error: " + e.getMessage();
        }
    }
}