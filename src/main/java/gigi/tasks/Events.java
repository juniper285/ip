package main.java.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents event task in Gigi.
 * This class extends {@code Task} and includes additional attributes to store start and end time
 * of an event.
 *
 * An event task requires a {@code taskName}, {@code startTime}, and {@code endTime}.
 * */

public class Events extends Task{
    private String taskName;
    private boolean isComplete;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static String iconEvent = "[E]";

    /**
     * Constructs an event task with a given name, start time, and end time.
     *
     * @param taskName  The name of event task.
     * @param startTime The start time of the event.
     * @param endTime   The end time of the event.
     */
    public Events(String taskName, LocalDateTime startTime, LocalDateTime endTime) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = false;
    }

    /**
     * Constructs an event task with a given name, start time, end time, and completion status.
     *
     * @param taskName   The name of the event task.
     * @param startTime  The start time of the event.
     * @param endTime    The end time of the event.
     * @param isComplete The completion status of the event.
     */
    public Events(String taskName, LocalDateTime startTime, LocalDateTime endTime, boolean isComplete) {
        super(taskName);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = isComplete;
    }

    /**
     * Constructs an event task with only a task name.
     * Note: This constructor does not initialize start or end times.
     *
     * @param taskName The name of the event task.
     */
    public Events(String taskName) {

        super(taskName);
    }

    /**
     * Returns the status icon for an event task.
     *
     * @return A formatted status string with "[E]" indicating an event.
     */
    public String getStatusIcon() {

        return "[E]" + super.getStatusIcon();
    }

    /**
     * Marks this event task as done.
     *
     * @param index The index of the task in the list.
     */
    void markDone(int index) {
        super.markDone(index);
    }

    /**
     * Marks this event task as not done.
     *
     * @param index The index of the task in the list.
     */
    void markUndone(int index) {
        super.markUndone(index);
    }

    /**
     * Converts the event task into a formatted string for storage.
     *
     * @return A string representation of the event task for saving.
     */
    public String convertToText() {
        return "E | " + super.convertToText() + " | "
                + this.startTime.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " | "
                + this.endTime.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    /**
     * Returns a string representation of the event task, including its time range.
     *
     * @return A formatted string describing the event task.
     */
    @Override
    public String toString() {
        return super.toString() + " (from: " + this.startTime.toString() + " to: " + this.endTime + ")";
    }
}


