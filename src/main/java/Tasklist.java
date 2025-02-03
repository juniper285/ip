import java.util.ArrayList;

public class Tasklist {
    protected ArrayList<Task> tasks;

    public Tasklist() {
        this.tasks = new ArrayList<>();
    }

    public Tasklist(ArrayList<Task> allTasks) {
        this.tasks = allTasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(int index) {
        this.tasks.remove(index);
    }

    public void getList(Ui ui) {
        if (this.tasks.isEmpty()) {
            ui.showMessage("MEOW!!! You have nothing on your list.");
        } else {
            ui.showMessage("Don't forget what you have to do:");
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i) != null) {
                    ui.showMessage((i + 1) + ". " + tasks.get(i));
                }
            }
        }
    }

    public void saveTasks(Storage storage) throws GigiException {
        storage.saveTasksToFile(tasks);
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public void markTaskAsDone(int taskIndex) {
        tasks.get(taskIndex).markDone(taskIndex);
    }

    public void markTaskAsUndone(int taskIndex) {
        tasks.get(taskIndex).markUndone(taskIndex);
    }

}