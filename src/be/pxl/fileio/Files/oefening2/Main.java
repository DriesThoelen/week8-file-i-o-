package be.pxl.fileio.Files.oefening2;

import org.omg.CORBA.Environment;

import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path bijlage1Path = Paths.get("src\\be\\pxl\\fileio\\Files\\oefening2\\bijlage1.txt");
        Path outputPath = Paths.get("src\\be\\pxl\\fileio\\Files\\oefening2\\output.txt");

        try {
            List<String> allLinesList = Files.readAllLines(bijlage1Path);
            TreeSet<String> allLinesTreeset = new TreeSet<>(Files.readAllLines(bijlage1Path));
            HashMap<String,WordCount> allLinesHashMap = new HashMap();

            for (String line:allLinesList) {
                if (allLinesHashMap.containsKey(line)) {
                    allLinesHashMap.get(line).setCount(allLinesHashMap.get(line).getCount() + 1);
                } else {
                    allLinesHashMap.put(line, new WordCount(line, 1));
                }
            }

            for (String key : allLinesHashMap.keySet()) {
                System.out.println(allLinesHashMap.get(key));
            };

            ArrayList<WordCount> wordCountList = new ArrayList<WordCount>(allLinesHashMap.values());
            Collections.sort(wordCountList);
            //Files.deleteIfExists(outputPath);
            Files.write(outputPath, allLinesTreeset);
            Files.write(outputPath, wordCountList, StandardOpenOption.APPEND);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


