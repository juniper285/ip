package gigi.commands;

import gigi.exceptions.GigiException;
import gigi.storage.Storage;
import gigi.tasks.Tasklist;
import gigi.ui.Ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

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