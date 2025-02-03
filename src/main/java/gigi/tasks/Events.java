package gigi.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task{
    protected String taskName;
    protected boolean complete;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;

    public Events(String taskName, LocalDateTime startTime, LocalDateTime endTime) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.complete = false;
    }

    public Events(String taskName, LocalDateTime startTime, LocalDateTime endTime, boolean isComplete) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = isComplete;
    }

    public Events(String taskName) {

        super(taskName);
    }

    public String getStatusIcon() {

        return "[E]" + super.getStatusIcon(); // mark done task with X
    }

    void markDone(int index) {

        super.markDone(index);
    }

    void markUndone(int index) {

        super.markUndone(index);
    }

    public String convertToText() {
        return "E | " + super.convertToText() + " | "
                + this.startTime.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " | "
                + this.endTime.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    public String toString() {
        return super.toString() + " (from: " + this.startTime.toString() + " to: " + this.endTime + ")";
    }
}


