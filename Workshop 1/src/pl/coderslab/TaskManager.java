package pl.coderslab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static String[] option = {"add", "remove", "list", "exit" };
    static String [][] toDo;

    public static void options(String[] arr) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : arr) {
            System.out.println(option);
        }
    }

    public static String[][] fileLoader(String fileName) {
        Path path1 = Paths.get(fileName);
        if (!Files.exists(path1)) {
            System.out.println("File not exist.");
            System.out.println(path1);
            System.exit(0);
        }
        String[][] data = null;

        try {
            List<String> strings = Files.readAllLines(path1);
            data = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    data[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static void toDoList(String [][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j] + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        System.out.println("lets go!");
        options(option);
        toDo = fileLoader("tasks.csv");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    break;
                case "add":
                    break;
                case "remove":
                    break;
                case "list":
                    toDoList(toDo);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            options(option);
        }
    }
}

