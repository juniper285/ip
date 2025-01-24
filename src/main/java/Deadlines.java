public class Deadlines extends Task{
    protected String taskName;
    protected boolean complete;
    protected String deadline;

    public Deadlines(String taskName, String deadline) {
        super(taskName);
        this.deadline = deadline;
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

    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }
}

