package duke.ui;

import java.util.Scanner;

import duke.tasks.Task;
import duke.tasks.TaskList;

/**
 * Event implements methods for displaying messages in Duke.
 *
 * @author Isaac Li Haoyang
 * @version v0.1
 */
public class UI {

    private static final Scanner sc = new Scanner(System.in);

    public void showLineBreak() {
        System.out.println("    ____________________________________________________________\n");
    }

    public void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        showLineBreak();
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        showLineBreak();
    }

    public void goodbyeMessage() {
        System.out.println("     Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public boolean checkValid(String input) {
        String[] str = input.split(" ");
        return (str.length > 1);
    }

    public void printListMessage(TaskList taskList) {
        System.out.println("    " + " You have " + taskList.getSize() + " tasks in the list.");
    }

    public void findMessage() {
        System.out.println("    Here are the matching tasks in your list: ");
    }
    public void addTaskMessage(Task task, int listSize) {
        System.out.println("    " + " Got it. I've added this task: ");
        System.out.println("       " + task);
        System.out.println("    " + " Now you have " + listSize + " tasks in the list.");
    }

    public void deleteTaskMessage(Task task, int listSize) {
        System.out.println("    " + " Got it. I've removed this task: ");
        System.out.println("       " + task);
        System.out.println("    " + " Now you have " + listSize + " tasks in the list.");
    }

    public void deleteAllMessage() {
        System.out.println("    " + " Got it. I've removed all tasks");
        System.out.println("    " + " Now you have 0 tasks in the list.");
    }

    public void markTaskMessage(Task task) {
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + task);
    }

    public void unmarkTaskMessage(Task task) {
        System.out.println("    OK, I've marked this task as not done yet:");
        System.out.println("      " + task);
    }

    public void incorrectCommandMessage() {
        System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(.");
    }

    public void undoMessage() {
        System.out.println("    OK, I've undone the previous command.");
        System.out.println("    Here is your task list:");
    }

    public void showLoadingError() {
        System.out.println("    " + " Loading error!");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
