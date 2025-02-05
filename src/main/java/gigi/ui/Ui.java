package gigi.ui;

import gigi.tasks.Tasklist;
import java.util.Scanner;

/**
 *
 * Handles user interactions with chatbot, Gigi.
 * This class provides methods to display messages and show errors or notifications.
 *
 * */

public class Ui {
    private final Scanner sc;

    /**
     * Constructs Ui instance for handling user interactions.
     */
    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Displays the welcome message when the chatbot starts.
     */
    public void showWelcome() {
        String logo = "\n" +
                "⠀ ／|_     \n" +
                "（ﾟ､ ｡ 7\n" +
                "⠀ |、ﾞ~ヽ\n" +
                "  じしf_, )ノ \n";
        System.out.println(
                "MEOW! \n"
                        + "I'm Gigi, the mighty demon keeping this place running. \n"
                        + "What do you want? \n");
    }

    /**
     * Displays separator line.
     */
    public void showLine() {

        System.out.println("____________________________________________________________");
    }

    /**
     * Displays error message.
     *
     * @param message The error message to be displayed
     * */
    public void showError(String message) {
        System.out.println("MEOW!! " + message);
    }

    /**
     * Reads and returns the next user command.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays a generic message.
     *
     * @param message The message to be displayed.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays a message indicating a task has been added.
     */
    public void showAddMessage() {
        System.out.println("Meow! I've pawed this task into the list:\n");
    }

    /**
     * Displays a message indicating a task has been deleted.
     */
    public void showDelMessage() {
        System.out.println("Meow! This task never existed:\n");
    }

    /**
     * Displays the exit message when the chatbot shuts down.
     */
    public void showByeMessage() {
        System.out.println("See ya! \n"
                + "Don't forget - this mighty fiery feline doesn't wait forever. \n"
                + "Meow!");
    }

    /**
     * Displays the current number of tasks in the task list.
     *
     * @param tasks The task list whose size is displayed.
     */

    public void showTaskNumber(Tasklist tasks) {
        System.out.printf("Now you have %d task(s) in the list.%n", tasks.getSize());
    }

    /**
     * Displays a message indicating a task has been marked as done.
     */
    public void showDoneMessage() {
        System.out.println("Meow! I've marked this task as done:\n");
    }

    /**
     * Displays a message indicating a task has been marked as not done.
     */
    public void showUndoneMessage() {
        System.out.println("Meow! I've marked this task as not done:\n");
    }

    /**
     * Displays an error message when the task list fails to load.
     */
    public void showLoadingError() {
        System.out.println("MEOW! Failed to load previous tasks.");
    }
}
