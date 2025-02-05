package main.java.commands;

import main.java.exceptions.GigiException;
import main.java.storage.Storage;
import main.java.tasks.Tasklist;
import main.java.ui.Ui;

public abstract class Command {
    protected static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("d MMM yyyy HH:mm"),
            DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a"),
            DateTimeFormatter.ofPattern("d MMM yyyy h:mm a"),
            DateTimeFormatter.ofPattern("d MMMM yyyy h:mm a"),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
    );

    public abstract void execute(Tasklist tasks, Ui ui, Storage storage) throws GigiException;

    public boolean isExit() {
        return false;
    }
}