package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {
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
}
