package System;

import java.util.Scanner;

public class Process {
    public static String currentCommand = "home";
    public static String currentPath = ""; // Default Current Path
    static Scanner scanner = new Scanner(System.in);

    public static String[][] commands = {
            { "help", "Displays the list of available commands." },
            { "cd [path]", "Set current directory." },
            { "ls", "List of available commands." },
            { "tr [filename.ex] [newpath]", "Move file to specified path." }
    };

    public static void setCommand() {
        String input = scanner.nextLine().trim();
        String[] splitInput = input.split(" ");
        String command = splitInput[0];

        switch (command) {
            case "help":
                Commands.printHelp();
                break;

            case "cd":
                if (splitInput.length > 1) {
                    Commands.setPath(splitInput[1]);
                } else {
                    System.out.println("Usage: cd [path]");
                }
                break;

            case "ls":
                Commands.lsCommand();
                break;

            case "tr":
                Commands.fileTransport(splitInput[1], splitInput[2]);
                break;

            default:
                System.out.println("Unknown command. Please enter a correct command.");
                break;
        }
    }
}
