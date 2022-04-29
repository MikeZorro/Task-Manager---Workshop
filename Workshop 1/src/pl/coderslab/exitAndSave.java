package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class exitAndSave {
    public static void exit(String fileName, String[][] data) {
        Path pathEnd = Paths.get(fileName);
        String[] toBeSaved = new String[data.length];
        for (int i = 0; i < toBeSaved.length; i++) {
            toBeSaved[i] = String.join(",", data[i]);
            try {
                Files.write(pathEnd, Arrays.asList(toBeSaved));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}