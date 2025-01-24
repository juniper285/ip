import java.io.*;
import java.util.*;

public class Gigi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] input = new Task[101]; // Array to store commands
        int inputCount = 0;

        String logo = "\n" +
                "⠀ ／|_     \n" +
                "（ﾟ､ ｡ 7\n" +
                "⠀ |、ﾞ~ヽ\n" +
                "  じしf_, )ノ \n";

        System.out.println("____________________________________________________________ \n");
        System.out.println(logo +
                "MEOW! \n"
                + "I'm Gigi, the mighty demon keeping this place running. \n"
                + "What do you want? \n");
        System.out.println("____________________________________________________________ \n");

        while (true) {
            String command = sc.nextLine();

            if (command.equals("bye")) {
                System.out.println("____________________________________________________________ \n");
                System.out.println(
                        "See ya! Don’t forget — this mighty fiery feline doesn’t wait forever. Meow!");
                System.out.println("____________________________________________________________ \n");
            }

            else if (command.equals("list")) {
                System.out.println("____________________________________________________________ \n");
                System.out.println("Don't forget what you have to do:");
                for (int i = 1; i <= inputCount; i++) {
                    if (input[i] != null) {
                        System.out.println(i + ". " + input[i].toString());
                    }
                }
                System.out.println("____________________________________________________________ \n");
            }

            else if (command.startsWith("mark")) {
                String[] splitCommand = command.split("\\s+");
                int index = Integer.parseInt(splitCommand[1]);
                System.out.println("____________________________________________________________ \n");
                System.out.println("Nice! I've marked this task as done:\n");
                input[index].markDone(index);
                System.out.println(input[index].toString());
                System.out.println("____________________________________________________________ \n");
            }

            else if (command.startsWith("unmark")) {
                String[] splitCommand = command.split("\\s+");
                int index = Integer.parseInt(splitCommand[1]);
                System.out.println("____________________________________________________________ \n");
                System.out.println("OK, I've marked this task as not done yet:\n");
                input[index].markUndone(index);
                System.out.println(input[index].toString());
                System.out.println("____________________________________________________________ \n");
            }

            else {
                try {
                    if (command.startsWith("todo") ) {
                        System.out.println("Aye! I’ve pawed this task into the list — don’t make me scratch it out later. Meow!");
                        ToDos itemT = new ToDos(command.substring(5).trim());
                        System.out.println(itemT.toString());
                        input[++inputCount] = itemT;
                        if (inputCount == 1) {
                            System.out.println("Remember now, you have " + inputCount + " task to do.");
                        } else {
                            System.out.println("Remember now, you have " + inputCount + " tasks to do.");
                        }
                    }
                    else if (command.startsWith("deadline")) {
                        System.out.println("Aye! I’ve pawed this task into the list — don’t make me scratch it out later. Meow!");
                        String command2 = command.substring(9).trim();
                        String[] splitCommand = command.split(" /by ");
                        Deadlines itemD = new Deadlines(splitCommand[0], splitCommand[1]);
                        System.out.println(itemD.toString());
                        input[++inputCount] = itemD;
                        if (inputCount == 1) {
                            System.out.println("Remember now, you have " + inputCount + " task to do.");
                        } else {
                            System.out.println("Remember now, you have " + inputCount + " tasks to do.");
                        }
                    }
                    else if (command.startsWith("event")) {
                        System.out.println("Aye! I’ve pawed this task into the list — don’t make me scratch it out later. Meow!");
                        String command3 = command.substring(6).trim();
                        String[] splitCom = command.split(" /from | /to ");
                        String taskName = splitCom[0];
                        String from = splitCom[1];
                        String to = splitCom[2];
                        Event itemE = new Event(taskName, from, to);
                        System.out.println(itemE.toString());
                        input[++inputCount] = itemE;
                        if (inputCount == 1) {
                            System.out.println("Remember now, you have " + inputCount + " task to do.");
                        } else {
                            System.out.println("Remember now, you have " + inputCount + " tasks to do.");
                        }
                    }
                    else {
                        throw new Exception("No Task type.");
                    }
                } catch (Exception e) {
                    System.out.println("____________________________________________________________ \n");
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("____________________________________________________________ \n");
                }
            }
        }
    }
}
