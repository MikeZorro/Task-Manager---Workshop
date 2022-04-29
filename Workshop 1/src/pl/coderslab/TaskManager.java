package pl.coderslab;


import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;


public class TaskManager {
    public static String[] option = {"add", "remove", "list", "exit" };
    public static String [][] toDo;

    public static void options(String[] arr) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : arr) {
            System.out.println(option);
        }
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
    public static void addTask(){
        Scanner scanner = new Scanner((System.in));
        System.out.println("Please describe the task:");
        String description = scanner.nextLine ();
        System.out.println("Please add task due date");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task important: true/false");
        String isImportant = scanner.nextLine();
        toDo = Arrays.copyOf(toDo, toDo.length +1);
        toDo[toDo.length -1] = new String [3];
        toDo[toDo.length -1][0] = description;
        toDo[toDo.length -1][1] = dueDate;
        toDo[toDo.length -1][2] =  isImportant;

    }
    public static void removeTask(String[][] data, int index) {
        try {
            if (index < data.length) {
                toDo = ArrayUtils.remove(data, index);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Element not exist in tab");
        }
    }

    public static void main(String[] args) {
        options(option);
        toDo = FileLoader.fileLoader("tasks.csv");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    exitAndSave.exit("tasks.csv", toDo);
                    System.out.println(ConsoleColors.RED + "That's all for now. Bye, bye.");
                    System.exit(0);
                    break;
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask(toDo, TaskRemovalHelper.getTheNumber());
                    System.out.println("Task was deleted! Less to worry about!");
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

