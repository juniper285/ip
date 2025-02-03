import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task{
    protected String taskName;
    protected boolean isComplete;
    protected LocalDateTime deadline;

    public Deadlines(String taskName, LocalDateTime deadline) {
        super(taskName);
        this.deadline = deadline;
        this.isComplete = false;
    }

    public Deadlines(String taskName, LocalDateTime deadline, boolean isComplete) {
        super(taskName);
        this.deadline = deadline;
        this.isComplete = isComplete;
    }

    public String getStatusIcon() {
        return "[D]" + super.getStatusIcon(); // mark done task with X
    }

    void markDone(int index) {
        super.markDone(index);
    }

    void markUndone(int index) {
        super.markUndone(index);
    }

    public String convertToText() {
        return "D | " + super.convertToText() + " | " + this.deadline;
    }

    public String toString() {
        return super.toString() + " (by: " + deadline.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}

