package java.tasks;

import java.exceptions.GigiException;
import java.storage.Storage;

import java.util.ArrayList;

/**
 * Represents a task list in the Gigi chatbot.
 * This class manages a list of tasks and provides methods to add, remove,
 * retrieve, and modify tasks.
 */

public class Tasklist {
    protected ArrayList<Task> tasks;

    /**
     * Constructs an empty task list.
     */
    public Tasklist() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a task list initialized with an existing list of tasks.
     *
     * @param allTasks The list of tasks to initialize the task list with.
     */
    public Tasklist(ArrayList<Task> allTasks) {
        this.tasks = allTasks;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Deletes a task from the task list based on its index.
     *
     * @param index The index of the task to be removed.
     */
    public void deleteTask(int index) {
        this.tasks.remove(index);
    }

    /**
     * Retrieves a formatted list of all tasks with their respective indices (from 1).
     *
     * @return A list of formatted task strings, where each task is numbered.
     */
    public List<String> getTaskList() {
        List<String> allTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null) {
                allTasks.add((i + 1) + ". " + tasks.get(i));
            }
        }
        return allTasks;
    }


    /**
     * Saves the current list of tasks to storage.
     *
     * @param storage The storage component responsible for saving tasks.
     * @throws GigiException If an error occurs while saving tasks.
     */
    public void saveTasks(Storage storage) throws GigiException {
        storage.saveTasksToFile(tasks);
    }

    /**
     * Loads tasks from storage.
     *
     * @param storage The storage component responsible for loading tasks.
     * @throws GigiException If an error occurs while loading tasks.
     */
    public void getTasks(Storage storage) throws GigiException {
        storage.loadTasksFromFile();
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Retrieves a task from the task list by index.
     *
     * @param taskIndex The index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    /**
     * Checks if the task list is empty.
     *
     * @return {@code true} if the task list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Marks a task as done based on its index.
     *
     * @param taskIndex The index of the task to be marked as done.
     */
    public void markTaskAsDone(int taskIndex) {
        tasks.get(taskIndex).markDone(taskIndex);
    }

    /**
     * Marks a task as not done based on its index.
     *
     * @param taskIndex The index of the task to be marked as not done.
     */
    public void markTaskAsUndone(int taskIndex) {
        tasks.get(taskIndex).markUndone(taskIndex);
    }

    public Tasklist getMatchingTasks(String keyword) {
        Tasklist result = new Tasklist();
        for (Task task : tasks) {
            String taskName = task.getTaskName();
            if (taskName.contains(keyword)) {
                result.addTask(task);
            }
        }
        return result;
    }

}