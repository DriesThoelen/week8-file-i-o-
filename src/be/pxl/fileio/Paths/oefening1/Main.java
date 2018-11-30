package be.pxl.fileio.Paths.oefening1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path userHomePath = Paths.get(System.getProperty("user.home"));
        System.out.println(userHomePath.toString());
        System.out.println(userHomePath.getClass().getName());
        Path newPath = userHomePath.resolve("Opdrachten/Opdracht1/Fase2");
    }
}
