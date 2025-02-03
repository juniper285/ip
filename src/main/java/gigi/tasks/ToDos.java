package gigi.tasks;

public class ToDos extends Task{
    protected String taskName;
    protected boolean isComplete;

    public ToDos(String taskName) {
        super(taskName);
        this.isComplete = false;
    }

    public ToDos(String taskName, boolean isComplete) {
        super(taskName);
        this.isComplete = isComplete;
    }

    public String getStatusIcon() {
        return "[T]" + super.getStatusIcon(); // mark done task with X
    }

    void markDone(int index) {
        super.markDone(index);
    }

    void markUndone(int index) {
        super.markUndone(index);
    }

    public String convertToText() {
        return "T" + " | " + super.convertToText();
    }

    public String toString() {
        return super.toString();
    }

}
