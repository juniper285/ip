# Gigi Chatbot - User Guide

Gigi is a command-line-based chatbot designed to help users manage their tasks efficiently. It allows users to add, list, delete, mark, and find tasks using a simple text-based interface. Gigi stores tasks persistently, ensuring that your tasks are saved and accessible even after restarting the application.


## Quick Start
Prerequisites: JDK 17, update Intellij to the most recent version.

1. Ensure you have Java 17 or above installed on your computer.
2. Download the latest Gigi.jar file from the official repository.
3. Copy the file to the folder where you want to store your tasks.
4. Open a terminal or command prompt, navigate to the folder, and run the application using:
     java -jar Gigi.jar
6. Gigi will greet you with a welcome message. Start entering commands to manage your tasks!

## Features
1. Adding a ToDo Task: todo

Adds a new ToDo task to the task list.

Format: todo TASK_DESCRIPTION
Example: todo Buy groceries

2. Adding a Deadline Task: deadline

Adds a new Deadline task with a specified due date.

Format: deadline TASK_DESCRIPTION /by YYYY-MM-DD HH:mm
Example: deadline Submit report /by 2024-02-28 23:59

3. Adding an Event Task: event

Adds a new Event task with a specified start and end time.

Format: event TASK_DESCRIPTION /from YYYY-MM-DD HH:mm /to YYYY-MM-DD HH:mm
Example: event Project meeting /from 2024-03-01 14:00 /to 2024-03-01 16:00

4. Listing All Tasks: list

Displays all tasks currently in the task list.

5. Marking a Task as Done: mark

Marks a specific task as completed.

Format: mark INDEX
Example: mark 2

6. Unmarking a Task: unmark

Marks a specific task as not done.

Format: unmark INDEX
Example: unmark 2

7. Finding a Task: find

Finds and displays tasks containing a specific keyword.

Format: find KEYWORD
Example: find report

8. Deleting a Task: delete

Deletes a specific task from the task list.

Format: delete INDEX
Example: delete 3

9. Exiting Gigi: bye

Saves the current task list and exits the application.

## Data Storage

Gigi automatically saves all tasks to ./data/Gigi.txt after every change.
If the task file is missing, Gigi creates a new one.
