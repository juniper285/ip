import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Gigi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> input = new ArrayList<>(); // Array to store commands
        String line = "____________________________________________________________ \n";
        String logo = "\n" +
                "⠀ ／|_     \n" +
                "（ﾟ､ ｡ 7\n" +
                "⠀ |、ﾞ~ヽ\n" +
                "  じしf_, )ノ \n";

        System.out.println(line);
        System.out.println(
                "MEOW! \n"
                        + "I'm Gigi, the mighty demon keeping this place running. \n"
                        + "What do you want? \n");
        System.out.println(line);

        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                System.out.println(line);
                System.out.println(
                        "See ya! Don't forget - this mighty fiery feline doesn't wait forever. Meow!");
                System.out.println(line);
            }
        }
    }
}

