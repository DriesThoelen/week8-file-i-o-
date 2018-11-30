package be.pxl.fileio.Files.oefening1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Path bijlage1Path = Paths.get("src\\be\\pxl\\fileio\\Files\\oefening1\\bijlage1.txt");
        Path outputPath = Paths.get("src\\be\\pxl\\fileio\\Files\\oefening1\\output.txt");

        try {
            TreeSet<String> allLinesTreeset = new TreeSet<>(Files.readAllLines(bijlage1Path));

            for (String line: allLinesTreeset) {
                System.out.println(line);
            }

            Files.deleteIfExists(outputPath);
            Files.write(outputPath, allLinesTreeset);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
