package gigi.storage;

import gigi.exceptions.GigiException;
import gigi.main.Parser;
import gigi.tasks.Deadlines;
import gigi.tasks.Events;
import gigi.tasks.Task;
import gigi.tasks.ToDos;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
    public ArrayList<Task> loadTasksFromFile() throws GigiException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tasks;
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

    public void saveTasksToFile(ArrayList<Task> tasks) throws GigiException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                pw.println(task.convertToText());
            }
        } catch (IOException e) {
            throw new GigiException("MEOW! Unable to save tasks to file: \n" + e.getMessage());
        }
    }
}
