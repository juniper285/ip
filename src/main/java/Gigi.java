import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Gigi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> input = new ArrayList<>();
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
            else if (command.equals("list")) {
                System.out.println(line);
                System.out.println("Don't forget what you have to do:");
                for (int i = 0; i < input.size(); i++) {
                    if (input.get(i) != null) {
                        System.out.println((i+1) + ". " + input.get(i).toString());
                    }
                }
                System.out.println(line);
            }
            else if (command.startsWith("mark")) {
                String[] splitCommand = command.split("\\s+");
                int index = Integer.parseInt(splitCommand[1]) - 1;
                System.out.println(line);
                System.out.println("Nice! I've marked this task as done:\n");
                input.get(index).markDone(index);
                System.out.println(input.get(index).toString());
                System.out.println(line);
            }

            else if (command.startsWith("unmark")) {
                String[] splitCommand = command.split("\\s+");
                int index = Integer.parseInt(splitCommand[1]) - 1;
                System.out.println(line);
                System.out.println("OK, I've marked this task as not done yet:\n");
                input.get(index).markUndone(index);
                System.out.println(input.get(index).toString());
                System.out.println(line);
            }

            else {
                        if (command.startsWith("todo") ) {
                            String description = command.substring(5).trim();
                            ToDos itemT = new ToDos(description);
                            System.out.println(line);
                            System.out.println("Aye! I've pawed this task into the list - don't make me scratch it out later. Meow!");
                            System.out.println(itemT.toString());
                            input.add(itemT);
                            if (input.size() == 1) {
                                System.out.println("Remember now, you have " + input.size() + " task to do.");
                                System.out.println(line);
                            } else {
                                System.out.println("Remember now, you have " + input.size() + " tasks to do.");
                                System.out.println(line);
                            }

                        }
                        else if (command.startsWith("deadline")) {
                            String command2 = command.substring(9).trim();
                            String[] splitCommand = command2.split(" /by ");
                            String description = splitCommand[0];
                            String date = splitCommand[1];
                            System.out.println(line);
                            System.out.println("Aye! I've pawed this task into the list - don't make me scratch it out later. Meow!");
                            Deadlines itemD = new Deadlines(description, date);
                            System.out.println(itemD.toString());
                            input.add(itemD);
                            if (input.size() == 1) {
                                System.out.println("Remember now, you have " + input.size() + " task to do.");
                                System.out.println(line);
                            } else {
                                System.out.println("Remember now, you have " + input.size() + " tasks to do.");
                                System.out.println(line);
                            }
                        }
                        else if (command.startsWith("event")) {
                            String command3 = command.substring(6).trim();
                            String[] splitCom = command3.split(" /from | /to ");
                            System.out.println("Aye! I've pawed this task into the list - don't make me scratch it out later. Meow!");
                            String taskName = splitCom[0];
                            String from = splitCom[1];
                            String to = splitCom[2];
                            Event itemE = new Event(taskName, from, to);
                            System.out.println(itemE.toString());
                            input.add(itemE);
                            if (input.size() == 1) {
                                System.out.println("Remember now, you have " + input.size() + " task to do.");
                                System.out.println(line);
                            } else {
                                System.out.println("Remember now, you have " + input.size() + " tasks to do.");
                                System.out.println(line);
                            }
                        }
            }
        }
    }
}

