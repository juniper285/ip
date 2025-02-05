package main.java.tasks;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class EventsTest {

    @Test
    public void testConstructorWithStartAndEndTime() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Team meeting", startTime, endTime);

        assertEquals("Team meeting", event.taskName, "Task name should be correctly set");
        assertEquals(startTime, event.startTime, "Start time should be correctly set");
        assertEquals(endTime, event.endTime, "End time should be correctly set");
        assertFalse(event.isComplete, "New Events task should be incomplete by default");
    }

    @Test
    public void testConstructorWithCompletionStatus() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Project presentation", startTime, endTime, true);

        assertEquals("Project presentation", event.taskName, "Task name should be correctly set");
        assertEquals(startTime, event.startTime, "Start time should be correctly set");
        assertEquals(endTime, event.endTime, "End time should be correctly set");
        assertTrue(event.isComplete, "Task should be marked as complete");
    }

    @Test
    public void testGetStatusIcon() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Team meeting", startTime, endTime);

        assertEquals("[E][ ] Team meeting", event.getStatusIcon(), "Status icon should reflect an incomplete event");

        event.markDone(0); // Assuming markDone toggles completion
        assertEquals("[E][X] Team meeting", event.getStatusIcon(), "Status icon should reflect a completed event");
    }

    @Test
    public void testConvertToText() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Team meeting", startTime, endTime);

        String expectedText = "E | 0 | Team meeting | 20 Feb 2025 | 20 Feb 2025";
        assertEquals(expectedText, event.convertToText(), "Convert to text should match the expected format");
    }

    @Test
    public void testMarkDoneAndMarkUndone() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Team meeting", startTime, endTime);

        // Test markDone
        event.markDone(0);
        assertTrue(event.isComplete, "Task should be marked as done");
        assertEquals("[E][X] Team meeting", event.getStatusIcon(), "Status icon should reflect a completed event");

        // Test markUndone
        event.markUndone(0);
        assertFalse(event.isComplete, "Task should be marked as undone");
        assertEquals("[E][ ] Team meeting", event.getStatusIcon(), "Status icon should reflect an incomplete event");
    }

    @Test
    public void testToString() {
        LocalDateTime startTime = LocalDateTime.of(2025, 2, 20, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 2, 20, 12, 0);
        Events event = new Events("Code review session", startTime, endTime);

        String expectedString = "[E][ ] Code review session (from: 2025-02-20T10:00 to: 2025-02-20T12:00)";
        assertEquals(expectedString, event.toString(), "toString should return the proper string format");

        event.markDone(0);
        String expectedStringAfterDone = "[E][X] Code review session (from: 2025-02-20T10:00 to: 2025-02-20T12:00)";
        assertEquals(expectedStringAfterDone, event.toString(), "toString should update after marking as done");
    }
}
