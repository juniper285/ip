package gigi.tasks;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task {
    protected String taskName;
    protected boolean isComplete;

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

    public Task(String taskName) {
        this.taskName = taskName;
        this.isComplete = false;
    }

    public String getStatusIcon() {
        return (isComplete ? "[X]" : "[ ]");
    }

    void markDone(int index) {
        this.isComplete = true;
    }

    void markUndone(int index) {
        this.isComplete = false;
    }

    public String convertToText() {
        return isComplete + " | " + this.taskName;
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.taskName;
    }

}

