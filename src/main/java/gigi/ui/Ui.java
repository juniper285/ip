package gigi.ui;

import java.util.Scanner;

import gigi.tasks.Tasklist;

/**
 * Handles user interactions with chatbot, Gigi.
 * This class provides methods to display messages and show errors or notifications.
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
    public String showWelcome() {
        String logo = "\n"
                + "⠀ ／|_     \n"
                + "（ﾟ､ ｡ 7\n"
                + "⠀ |、ﾞ~ヽ\n"
                + "  じしf_, )ノ \n";
        return
                "MEOW! \n"
                        + "I'm Gigi, the mighty demon keeping this place running. \n"
                        + "What do you want? \n";
    }

    /**
     * Displays separator line.
     */
    public String showLine() {
        return "____________________________________________________________";
    }

    /**
     * Displays error message.
     *
     * @param message The error message to be displayed
     * */
    public String showError(String message) {
        return "MEOW!! " + message;
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
    public String showMessage(String message) {
        return message;
    }

    /**
     * Displays a message indicating a task has been added.
     */
    public String showAddMessage() {
        return "Meow! I've pawed this task into the list:\n";
    }

    /**
     * Displays a message indicating a task has been deleted.
     */
    public String showDelMessage() {
        return "Meow! This task never existed:\n";
    }

    /**
     * Displays message for exiting program.
     */
    public String showByeMessage() {
        return "See ya! \n"
                + "Don't forget - this mighty fiery feline doesn't wait forever. \n"
                + "Meow!";
    }

    /**
     * Displays message to indicate size of task list.
     */
    public String showTaskNumber(Tasklist tasks) {
        return String.format("Now you have %d task(s).%n", tasks.getSize());
    }

    /**
     * Displays a message indicating a task has been marked as done.
     */
    public String showDoneMessage() {
        return "Meow! I've marked this task as done:\n";
    }

    /**
     * Displays a message indicating a task has been marked as not done.
     */
    public String showUndoneMessage() {
        return "Meow! I've marked this task as not done:\n";
    }

    /**
     * Displays an error message when the task list fails to load.
     */
    public void showLoadingError() {
        System.out.println("MEOW! Failed to load previous tasks.");
    }
}
