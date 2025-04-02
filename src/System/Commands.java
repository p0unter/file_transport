package System;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Commands {
    public static void setPath(String path) {
        Process.currentPath = path.trim().replace("/", File.separator);
        System.out.println("Set path: " + Process.currentPath);
    }

    public static void printHelp() {
        UI.printCommands();
    }

    public static void lsCommand() {
        File folder = new File(Process.currentPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.printf("Name: %s\tSize (byte): %s\n", file.getName(), file.length());
                    }
                }
            } else {
                System.out.println("Folder is empty.");
            }
        } else {
            System.out.println("Folder does not exist.");
        }
    }

        public static void fileTransport(String fileName, String newPath) {
        String originalPath = Process.currentPath + File.separator + fileName;

        String newPathWithFileName = newPath + File.separator + fileName;

        try {
            Path originalFilePath = Paths.get(originalPath);
            Path newFilePath = Paths.get(newPathWithFileName);

            /* File Transport Place */
            Files.move(originalFilePath, newFilePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println(fileName + " File transfer complete.");
        } catch (IOException e) {
            System.out.println("An error occurred while moving the file: " + e.getMessage());
        }
    }
}
