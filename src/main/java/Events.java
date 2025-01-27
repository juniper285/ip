public class Event extends Task{
    protected String taskName;
    protected boolean complete;
    protected String startTime;
    protected String endTime;
    protected boolean isComplete;

    public Event(String taskName, String startTime, String endTime) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = false;
    }

    public Event(String taskName, String startTime, String endTime, boolean isComplete) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = isComplete;
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

    public String toString() {
        return super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}

