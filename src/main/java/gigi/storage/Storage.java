package gigi.storage;

import gigi.exceptions.GigiException;
import gigi.Parser;
import gigi.tasks.Deadlines;
import gigi.tasks.Events;
import gigi.tasks.Task;
import gigi.tasks.ToDos;

import java.io.*;
import java.util.ArrayList;

/**
 * Handles file storage operations for saving and loading tasks.
 * This class is responsible for reading and writing tasks to a file.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a Storage instance with a specified file path.
     *
     * @param filePath The path of the file where tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Converts a formatted task string from storage into a Task object.
     *
     * @param line The stored task string.
     * @return The corresponding Task object.
     * @throws GigiException If the task type is unknown.
     */
    public static Task convertToTask(String line) throws GigiException {
        String[] info = line.split(" \\| ");
        String taskType = info[0];
        boolean isDone = Boolean.parseBoolean(info[1]);
        return switch (taskType) {
            case "T" -> new ToDos(info[2], isDone);
            case "D" -> new Deadlines(info[2],
                    Parser.parseDateTime(info[3]),
                    isDone);
            case "E" -> new Events(info[2],
                    Parser.parseDateTime(info[3]),
                    Parser.parseDateTime(info[4]),
                    isDone);
            default -> throw new GigiException("Unknown task type: " + taskType);
        };
    }

    /**
     * Loads tasks from the specified file and returns them as a list.
     * If the file does not exist, an empty list is returned.
     *
     * @return A list of tasks retrieved from the file.
     * @throws GigiException If an error occurs while reading the file.
     */
    public ArrayList<Task> loadTasksFromFile() throws GigiException, IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        file.getParentFile().mkdirs(); // correct!
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(convertToTask(line));
            }
        } catch (IOException e) {
            throw new GigiException("Error loading file.");
        }
        return tasks;
    }

    /**
     * Saves the list of tasks to the specified file.
     * Each task is converted to a string format before being written to the file.
     *
     * @param tasks The list of tasks to be saved.
     * @throws GigiException If an error occurs while writing to the file.
     */
    public void saveTasksToFile(ArrayList<Task> tasks) throws IOException, GigiException {
        File file = new File(filePath);
        file.getParentFile().mkdirs(); // correct!
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.mkdirs()) {
            System.out.println("Directory is created");
        } else {
            System.out.println("Directory cannot be created");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                pw.println(task.convertToText());
            }
        } catch (IOException e) {
            throw new GigiException("MEOW! Unable to save tasks to file: \n" + e.getMessage());
        }
    }
}
