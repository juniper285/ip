package java.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToDosTest {

    @Test
    public void testConstructorWithSingleArgument() {
        ToDos todo = new ToDos("Read book");
        assertEquals("Read book", todo.taskName);
        assertFalse(todo.isComplete, "New ToDo should be incomplete by default");
    }

    @Test
    public void testConstructorWithTwoArguments() {
        ToDos todo = new ToDos("Write code", true);
        assertEquals("Write code", todo.taskName);
        assertTrue(todo.isComplete, "ToDo should be marked as complete");
    }

    @Test
    public void testGetStatusIcon() {
        ToDos todo = new ToDos("Read book");
        assertEquals("[T][ ] Read book", todo.getStatusIcon(), "Status icon should reflect a ToDo with incomplete status");

        todo.markDone(0); // Assuming markDone toggles the completion
        assertEquals("[T][X] Read book", todo.getStatusIcon(), "Status icon should reflect a ToDo with completed status");
    }

    @Test
    public void testConvertToText() {
        ToDos todo = new ToDos("Read book");
        String expectedText = "T | 0 | Read book";
        assertEquals(expectedText, todo.convertToText(), "Convert to text should match the expected format");
    }

    @Test
    public void testMarkDoneAndMarkUndone() {
        ToDos todo = new ToDos("Read book");

        // Test markDone
        todo.markDone(0);
        assertTrue(todo.isComplete, "Task should be marked as done");
        assertEquals("[T][X] Read book", todo.getStatusIcon(), "Status icon should reflect a completed ToDo");

        // Test markUndone
        todo.markUndone(0);
        assertFalse(todo.isComplete, "Task should be marked as undone");
        assertEquals("[T][ ] Read book", todo.getStatusIcon(), "Status icon should reflect an incomplete ToDo");
    }

    @Test
    public void testToString() {
        ToDos todo = new ToDos("Study Java");
        assertEquals("[T][ ] Study Java", todo.toString(), "toString should return the proper string format");

        todo.markDone(0);
        assertEquals("[T][X] Study Java", todo.toString(), "toString should update after marking as done");
    }
}
