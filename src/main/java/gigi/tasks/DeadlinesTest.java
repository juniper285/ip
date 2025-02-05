package main.java.tasks;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DeadlinesTest {

    @Test
    public void testConstructorWithTwoArguments() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Submit project", deadline);
        assertEquals("Submit project", task.taskName);
        assertEquals(deadline, task.deadline, "Deadline should be correctly set");
        assertFalse(task.isComplete, "New Deadline task should be incomplete by default");
    }

    @Test
    public void testConstructorWithThreeArguments() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Submit project", deadline, true);
        assertEquals("Submit project", task.taskName);
        assertEquals(deadline, task.deadline, "Deadline should be correctly set");
        assertTrue(task.isComplete, "Task should be marked as complete");
    }

    @Test
    public void testGetStatusIcon() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Submit project", deadline);

        assertEquals("[D][ ] Submit project", task.getStatusIcon(), "Status icon should reflect an incomplete Deadline");

        task.markDone(0); // Assuming markDone toggles completion
        assertEquals("[D][X] Submit project", task.getStatusIcon(), "Status icon should reflect a completed Deadline");
    }

    @Test
    public void testConvertToText() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Submit project", deadline);
        String expectedText = "D | 0 | Submit project | 28 Feb 2025";
        assertEquals(expectedText, task.convertToText(), "Convert to text should match the expected format");
    }

    @Test
    public void testMarkDoneAndMarkUndone() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Submit project", deadline);

        // Test markDone
        task.markDone(0);
        assertTrue(task.isComplete, "Task should be marked as done");
        assertEquals("[D][X] Submit project", task.getStatusIcon(), "Status icon should reflect a completed Deadline");

        // Test markUndone
        task.markUndone(0);
        assertFalse(task.isComplete, "Task should be marked as undone");
        assertEquals("[D][ ] Submit project", task.getStatusIcon(), "Status icon should reflect an incomplete Deadline");
    }

    @Test
    public void testToString() {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 28, 23, 59);
        Deadlines task = new Deadlines("Complete assignment", deadline);
        String expectedString = "[D][ ] Complete assignment (by: 28 Feb 2025)";
        assertEquals(expectedString, task.toString(), "toString should return the proper string format");

        task.markDone(0);
        String expectedStringAfterDone = "[D][X] Complete assignment (by: 28 Feb 2025)";
        assertEquals(expectedStringAfterDone, task.toString(), "toString should update after marking as done");
    }
}
