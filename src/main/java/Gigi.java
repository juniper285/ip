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
            try {
                if (command.equals("bye")) {
                    System.out.println(line);
                    System.out.println(
                            "See ya! Don't forget - this mighty fiery feline doesn't wait forever. Meow!");
                    System.out.println(line);
                }

                else if (command.equals("list")) {
                    if (input.size() == 0) {
                        throw new DukeException("MEOW!!! You have nothing on your list.");
                    }
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
                    if (index + 1 > input.size()) {
                        throw new DukeException("MEOW! You don't have that many tasks");
                    }
                    System.out.println(line);
                    System.out.println("Nice! I've marked this task as done:\n");
                    input.get(index).markDone(index);
                    System.out.println(input.get(index).toString());
                    System.out.println(line);
                }

                else if (command.startsWith("unmark")) {
                    String[] splitCommand = command.split("\\s+");
                    int index = Integer.parseInt(splitCommand[1]) - 1;
                    if (index + 1 > input.size()) {
                        throw new DukeException("MEOW! You don't have that many tasks");
                    }
                    System.out.println(line);
                    System.out.println("OK, I've marked this task as not done yet:\n");
                    input.get(index).markUndone(index);
                    System.out.println(input.get(index).toString());
                    System.out.println(line);
                }

                else {
                    try {
                        if (command.startsWith("todo") ) {
                            if (command.length() < 5) {
                                throw new DukeException("Where is your todo?");
                            }
                            String description = command.substring(5).trim();
                            if (description.isEmpty() || description.equals(" ")) {
                                throw new DukeException("Where is your todo?");
                            }
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
                            if (command.length() < 9) {
                                throw new DukeException("Where is your deadline?");
                            }
                            if (!command.contains(" /by ")) {
                                throw new DukeException("MEOW!!! The deadline must include a '/by' clause.");
                            }
                            String command2 = command.substring(9).trim();
                            if (command2.isEmpty() || command2.equals(" ")) {
                                throw new DukeException("Where is your deadline?");
                            }
                            String[] splitCommand = command2.split(" /by ");
                            if (splitCommand[0].trim().isEmpty() || splitCommand[1].trim().isEmpty()) {
                                throw new DukeException("MEOW!!! The description and date of a deadline cannot be empty.");
                            }
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
                            if (command.length() < 6) {
                                throw new DukeException("Where is your event?");
                            }
                            if (!command.contains(" /from ") || !command.contains(" /to ")) {
                                throw new DukeException("MEOW!!! The event must include '/from' and '/to' clauses.");
                            }
                            String command3 = command.substring(6).trim();
                            if (command3.isEmpty() || command3.equals(" ")) {
                                throw new DukeException("Where is your deadline?");
                            }
                            String[] splitCom = command3.split(" /from | /to ");
                            if (splitCom[0].trim().isEmpty() || splitCom[1].trim().isEmpty() || splitCom[2].trim().isEmpty()) {
                                throw new DukeException("MEOW!!! The description, start time, and end time of an event cannot be empty.");
                            }
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
                        else {
                            throw new DukeException("I've got no clue what that means - care to explain?");
                        }
                    } catch (DukeException e) {
                        System.out.println(line);
                        System.out.println(e.getMessage());
                        System.out.println(line);
                    }
                }
            } catch (DukeException e) {
                System.out.println(line);
                System.out.println(e.getMessage());
                System.out.println(line);

            }
        }
    }
}
