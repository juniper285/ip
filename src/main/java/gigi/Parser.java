package gigi;

import gigi.commands.ByeCommand;
import gigi.commands.Command;
import gigi.commands.DeadlineCommand;
import gigi.commands.DeleteCommand;
import gigi.commands.EventCommand;
import gigi.commands.FindCommand;
import gigi.commands.ListCommand;
import gigi.commands.MarkCommand;
import gigi.commands.ToDoCommand;
import gigi.commands.UnmarkCommand;
import gigi.exceptions.GigiException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Parses user input and converts it into corresponding command objects.
 * This class handles extracting command words and arguments,
 * as well as parsing date and time inputs.
 */
 public class Parser {
    private static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("d MMM yyyy HH:mm"),
            DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a"),
            DateTimeFormatter.ofPattern("d MMM yyyy h:mm a"),
            DateTimeFormatter.ofPattern("d MMMM yyyy h:mm a"),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
    );
    private static final List<DateTimeFormatter> DATE_FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("d MMM yyyy"),
            DateTimeFormatter.ofPattern("d MMMM yyyy")
    );

    /**
     * Parses user input and returns the corresponding command object.
     *
     * @param input The raw user input.
     * @return The corresponding {@code Command} object.
     * @throws GigiException If the command is invalid.
     */
    public static Command parse(String input) throws GigiException {
        String[] parts = input.split("\\s+", 2);
        String commandWord = parts[0];
        String details = parts.length > 1 ? parts[1] : "";

        return switch (commandWord) {
            case ToDoCommand.COMMAND_WORD -> startToDo(details);
            case DeadlineCommand.COMMAND_WORD -> startDeadline(details);
            case EventCommand.COMMAND_WORD -> startEvent(details);
            case DeleteCommand.COMMAND_WORD -> startDelete(details);
            //case ClearCommand.COMMAND_WORD -> new ClearCommand();
            case ByeCommand.COMMAND_WORD -> new ByeCommand();
            case ListCommand.COMMAND_WORD -> new ListCommand();
            case FindCommand.COMMAND_WORD -> new FindCommand(details);
            case MarkCommand.COMMAND_WORD -> new MarkCommand(Integer.parseInt(details));
            case UnmarkCommand.COMMAND_WORD -> new UnmarkCommand(Integer.parseInt(details));
            //case HelpCommand.COMMAND_WORD -> new HelpCommand();
            default -> throw new GigiException("MEOW! Invalid command. What do you mean?");   //new HelpCommand();
        };
    }

    private static Command startToDo(String details) throws GigiException {
        return new ToDoCommand(details);
    }

    private static Command startDeadline(String details) throws GigiException {
        if (!details.contains(" /by ")) {
            throw new GigiException("MEOW!!! The deadline must include a '/by' clause.");
        }
        String[] deadlineDetails = details.split(" /by ", 2);
        if (deadlineDetails.length < 2 || deadlineDetails[0].isBlank() || deadlineDetails[1].isBlank()) {
            throw new GigiException("MEOW!!! The description and date of a deadline cannot be empty.");
        }
        return new DeadlineCommand(deadlineDetails[0], parseDateTime(deadlineDetails[1]));
    }

    private static Command startEvent(String details) throws GigiException {
        String[] eventDetails = details.split(" /from | /by ", 3);
        if (eventDetails.length < 3) {
            throw new GigiException("MEOW! Events must have a description, '/from' date, and '/by' deadline.");
        }
        return new EventCommand(eventDetails[0], parseDateTime(eventDetails[1]), parseDateTime(eventDetails[2]));
    }

    private static Command startDelete(String details) throws GigiException {
        try {
            return new DeleteCommand(Integer.parseInt(details));
        } catch (NumberFormatException e) {
                throw new GigiException("MEOW! Please provide a valid task number to delete.");
            }
    }

    public static LocalDateTime parseDateTime(String dateTimeString) throws GigiException {
        dateTimeString = dateTimeString.trim();

        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDateTime.parse(dateTimeString, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }

        for (DateTimeFormatter formatter : DATE_FORMATTERS) {
            try {
                LocalDate date = LocalDate.parse(dateTimeString, formatter);
                return date.atStartOfDay();
            } catch (DateTimeParseException ignored) {
            }
        }

        throw new GigiException("MEOW! Invalid date format.");
    }

}
