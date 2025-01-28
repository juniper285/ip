public class Task {
    protected String taskName;
    protected boolean isComplete;

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
        return (isComplete ? "1" : "0") + " | " + this.taskName;
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.taskName;
    }
}

