public class Gigi {
    private static final String FILE_PATH = "./data/Gigi.txt";

    private Storage storage;
    private Tasklist tasks;
    private Ui ui;

    public Gigi(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new Tasklist(storage.loadTasksFromFile());
        } catch (GigiException e) {
            ui.showLoadingError();
            tasks = new Tasklist();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c;
                c = Parser.parse(fullCommand);
                c.execute(tasks,ui,storage);
                isExit = c.isExit();
            } catch (GigiException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Gigi(FILE_PATH).run();
    }
}

//        public static void main(String[] args) {
//            new Gigi("data/tasks.txt").run();
//        }
//    }
//
//    public void run() {
//        //...
//    }
//
//    private static final String FILE_PATH = "./data/Gigi.txt";
//    private static final List<DateTimeFormatter> formatters = List.of(
//            DateTimeFormatter.ofPattern("MM/dd/yyyy"),   // Example: 12/31/2024
//            DateTimeFormatter.ofPattern("dd/MM/yyyy"),   // Example: 31/12/2024
//            DateTimeFormatter.ofPattern("yyyy-MM-dd"),   // Example: 2024-12-31
//            DateTimeFormatter.ofPattern("d MMM yyyy"),   // Example: Dec 31 2024
//            DateTimeFormatter.ofPattern("d MMMM yyyy")   // Example: December 31 2024
//    );
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Task> input = loadTasksFromFile();
//        String line = "____________________________________________________________ \n";
//        String logo = "\n" +
//                "⠀ ／|_     \n" +
//                "（ﾟ､ ｡ 7\n" +
//                "⠀ |、ﾞ~ヽ\n" +
//                "  じしf_, )ノ \n";
//
//        System.out.println(line);
//        System.out.println(
//                "MEOW! \n"
//                        + "I'm Gigi, the mighty demon keeping this place running. \n"
//                        + "What do you want? \n");
//        System.out.println(line);
//
//        while (sc.hasNextLine()) {
//            String command = sc.nextLine();
//            System.out.println(line);
//            try {
//                command = command.toLowerCase();
//                String[] splitCommand = command.split("\\s+", 2);
//                String action = splitCommand[0];
//                String details = splitCommand.length > 1 ? splitCommand[1] : "";
//
//                switch(action) {
//                    case "bye" -> {
//                        saveTasksToFile(input);
//                        System.out.println(
//                                "See ya! \n" +
//                                        "Don't forget - this mighty fiery feline doesn't wait forever. \n" +
//                                        "Meow!");
//                        return;
//                    }
//
//                    case "list" -> {
//                        if (input.isEmpty()) {
//                            throw new DukeException("MEOW!!! You have nothing on your list.");
//                        }
//                        System.out.println("Don't forget what you have to do:");
//                        for (int i = 0; i < input.size(); i++) {
//                            if (input.get(i) != null) {
//                                System.out.println((i + 1) + ". " + input.get(i).toString());
//                            }
//                        }
//                    }
//                    case "mark" -> {
//                        String[] splitDescription = details.split("\\s+");
//                        int index = Integer.parseInt(splitDescription[0]) - 1;
//                        if (index + 1 > input.size()) {
//                            throw new DukeException("MEOW! You don't have that many tasks");
//                        }
//                        System.out.println("Nice! I've marked this task as done:\n");
//                        input.get(index).markDone(index);
//                        System.out.println(input.get(index).toString());
//                    }
//
//                    case "unmark" -> {
//                        String[] splitDescription = details.split("\\s+");
//                        int index = Integer.parseInt(splitDescription[0]) - 1;
//                        if (index + 1 > input.size()) {
//                            throw new DukeException("MEOW! You don't have that many tasks");
//                        }
//                        System.out.println("Meow, I've marked this task as not done yet:\n");
//                        input.get(index).markUndone(index);
//                        System.out.println(input.get(index).toString());
//                    }
//
//                    case "delete" -> {
//                        String[] splitDescription = details.split("\\s+");
//                        int index = Integer.parseInt(splitDescription[0]) - 1;
//                        if (index + 1 > input.size()) {
//                            throw new DukeException("MEOW! You don't have that many tasks");
//                        }
//                        System.out.println("MEOW. This task never existed: \n");
//                        System.out.println(input.get(index).toString());
//                        input.remove(index);
//                        System.out.println("You have " + input.size() + " tasks to do.");
//                    }
//
//                    case "todo" -> {
//                        if (details.isBlank()) {
//                            throw new DukeException("Where is your todo?");
//                        }
//                        ToDos itemT = new ToDos(details);
//                        System.out.println("Meow! I've pawed this task into the list - don't make me scratch it out later. \n");
//                        System.out.println(itemT.toString());
//                        input.add(itemT);
//                        System.out.printf("\nRemember now, you have %d task(s) to do.%n", input.size());
//                    }
//
//                    case "deadline" -> {
//                        if (details.isBlank()) {
//                            throw new DukeException("Where is your deadline?");
//                        }
//                        if (!command.contains(" /by ")) {
//                            throw new DukeException("MEOW!!! The deadline must include a '/by' clause.");
//                        }
//                        String[] deadlineDetails = details.split(" /by ");
//                        if (deadlineDetails.length < 2 || deadlineDetails[0].isBlank() || deadlineDetails[1].isBlank()) {
//                            throw new DukeException("MEOW!!! The description and date of a deadline cannot be empty.");
//                        }
//                        String deadlineTask = deadlineDetails[0];
//                        String date = deadlineDetails[1];
//                        LocalDate deadlineDate = null;
//                        for (DateTimeFormatter formatter : formatters) {
//                            try {
//                                deadlineDate = LocalDate.parse(date, formatter);
//                                break; // Stop if successful
//                            } catch (DateTimeParseException ignored) {
//                            }
//                        }
//                        if (deadlineDate == null) {
//                            throw new DukeException("MEOW! Must be in a recognized date format.");
//                        }
//                        System.out.println("Meow! I've pawed this task into the list - don't make me scratch it out later.");
//                        Deadlines itemD = new Deadlines(deadlineTask, deadlineDate);
//                        System.out.println(itemD.toString());
//                        input.add(itemD);
//                        System.out.printf("Remember now, you have %d task(s) to do.%n", input.size());
//                    }
//                    case "event" -> {
//                        if (details.isBlank()) {
//                            throw new DukeException("Where is your event?");
//                        }
//                        if (!details.contains(" /from " ) || !details.contains(" /to ")) {
//                            throw new DukeException("MEOW!!! The event must include '/from' and '/to' clauses.");
//                        }
//                        String[] eventDetails = details.split("(?<=/from )|(?<=/to )");
//                        if (eventDetails.length < 3 | Arrays.stream(eventDetails).anyMatch(String::isBlank)) {
//                            throw new DukeException("MEOW!!! The description, start time, and end time of an event cannot be empty.");
//                        }
//                        System.out.println("Meow! I've pawed this task into the list - don't make me scratch it out later.");
//                        String taskName = eventDetails[0];
//                        String from = eventDetails[1].trim().replace("/from ", "");
//                        String to = eventDetails[2].trim().replace("/to ", "");
//                        LocalDate fromDate = null;
//                        LocalDate toDate = null;
//                        for (DateTimeFormatter formatter : formatters) {
//                            try {
//                                fromDate = LocalDate.parse(from, formatter);
//                                toDate = LocalDate.parse(to, formatter);
//                                break; // Stop if successful
//                            } catch (DateTimeParseException ignored) {
//                            }
//                        }
//                        System.out.println("from " + fromDate);
//                        System.out.println("to " +toDate);
//                        if (fromDate == null || toDate == null) {
//                            throw new DukeException("MEOW! Must be in a recognized date format.");
//                        }
//
//                        Events itemE = new Events(taskName, fromDate, toDate);
//                        System.out.println(itemE.toString());
//                        input.add(itemE);
//                        System.out.printf("Remember now, you have %d task(s) to do.%n", input.size());
//                    }
//                    default -> {
//                        throw new DukeException("I've got no clue what that means - care to explain?");
//                    }
//                }
//            } catch (DukeException e) {
//                System.out.println(e.getMessage());
//
//            }
//            System.out.println(line);
//        }
//    }
//
//    private static void saveTasksToFile(ArrayList<Task> input) {
//        try {
//            PrintWriter pw = new PrintWriter(FILE_PATH);
//            for (Task task : input) {
//                pw.println(task.convertToText());
//            }
//            pw.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("MEOW! Unable to save tasks to file: \n" +
//                    e.getMessage());
//        }
//    }
//
//    private static ArrayList<Task> loadTasksFromFile() {
//        ArrayList<Task> input = new ArrayList<>();
//        File file = new File(FILE_PATH);
//        if (!file.exists()) {
//            return input;
//        }
//        try (Scanner sc = new Scanner(file)) {
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                if (line.isBlank()) {
//                    continue;
//                }
//                String[] info = line.split(" \\| ");
//                String taskType = info[0];
//                boolean isDone = Boolean.parseBoolean(info[1]);
//                switch (taskType) {
//                    case "T" -> input.add(new ToDos(info[2], isDone));
//                    case "D" -> input.add(new Deadlines(info[2], LocalDate.parse(info[3]), isDone));
//                    case "E" -> input.add(new Events(info[2], LocalDate.parse(info[3]), LocalDate.parse(info[4]), isDone));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("MEOW! Unable to load tasks from file: \n" +
//                    e.getMessage());
//        }
//        System.out.println("MEOW! Tasks loaded from file.");
//        return input;
//
//    }
//}
