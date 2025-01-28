public class Events extends Task{
    protected String taskName;
    protected boolean complete;
    protected String startTime;
    protected String endTime;


    public Events(String taskName, String startTime, String endTime) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.complete = false;
    }

    public Events(String taskName, String startTime, String endTime, boolean isComplete) {
        super(taskName);
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
        return "E | " + super.convertToText() + " | " + this.startTime + " | " + this.endTime;
    }

    public String toString() {
        return super.toString() + " (from: " + this.startTime + " to: " + this.endTime + ")";
    }
}


