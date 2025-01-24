public class ToDos extends Task{
    protected String taskName;
    protected boolean complete;

    public ToDos(String taskName) {
        super(taskName);
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

    public String toString() {
        return super.toString();
    }
}
