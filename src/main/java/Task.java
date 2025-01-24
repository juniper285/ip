public class Task {
    protected String taskName;
    protected boolean complete;

    public Task(String taskName) {
        this.taskName = taskName;
        this.complete = false;
    }

    public String getStatusIcon() {
        return (complete ? "[X]" : "[ ]");
    }

    void markDone(int index) {
        this.complete = true;
    }

    void markUndone(int index) {
        this.complete = false;
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.taskName;
    }
}

