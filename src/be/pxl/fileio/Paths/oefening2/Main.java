package be.pxl.fileio.Paths.oefening2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path userHomePath = Paths.get(System.getProperty("user.home"));
        Path newPath = userHomePath.resolve("Opdrachten/Opdracht1/Fase2");
        System.out.println(newPath.toString());
        System.out.println(newPath.getFileName());
        System.out.println(newPath.getName(0));
        System.out.println(newPath.getNameCount());
        System.out.println(newPath.subpath(0,2));
        System.out.println(newPath.getParent());
        System.out.println(newPath.getRoot());
    }
}
