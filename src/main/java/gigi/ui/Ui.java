package gigi.ui;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

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

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showError(String message) {
        System.out.println("MEOW!! " + message);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showAddMessage() {
        System.out.println("Meow! I've pawed this task into the list:\n");
    }

    public void showDelMessage() {
        System.out.println("Meow! This task never existed:\n");
    }

    public void showByeMessage() {
        System.out.println("See ya! \n"
                + "Don't forget - this mighty fiery feline doesn't wait forever. \n"
                + "Meow!");
    }

    public void showDoneMessage() {
        System.out.println("Meow! I've marked this task as done:\n");
    }

    public void showUndoneMessage() {
        System.out.println("Meow! I've marked this task as not done:\n");
    }

    public void showLoadingError() {
        System.out.println("MEOW! Failed to load previous tasks.");
    }
}
