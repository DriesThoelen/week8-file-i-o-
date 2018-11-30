package be.pxl.fileio.Streams.oefening1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

public class Telefoonboek {

    private ArrayList<Persoon> personenLijst;
    private Path phonedirectoryPath;

    public Telefoonboek() {
        personenLijst = new ArrayList<>();
        phonedirectoryPath = Paths.get("src\\be\\pxl\\fileio\\Streams\\oefening1\\phonedirectory.txt");

        try (BufferedReader reader = Files.newBufferedReader(phonedirectoryPath)) {

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(";");
                Persoon persoon = new Persoon(splitLine[0]);
                for (int i = 1; i < splitLine.length; i++) {
                    persoon.addTelephoneNumber(splitLine[i]);
                }
                personenLijst.add(persoon);
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    public void addPerson(Persoon persoon) {
        personenLijst.add(persoon);
        write();
    }

    public Persoon getPerson(String name) {
       Persoon persoon = null;
       Optional<Persoon> optionalPersoon = personenLijst.stream().filter(p -> p.getName().equals(name)).findAny();

        if (optionalPersoon.isPresent()) {
            persoon = optionalPersoon.get();
        }

        return persoon;
    }

    public void write() {
        try (BufferedWriter writer = Files.newBufferedWriter(phonedirectoryPath)) {
            for (Persoon persoon:personenLijst) {
                StringBuilder lineBuilder = new StringBuilder(persoon.getName());
                for (String telephoneNumber:persoon.getTelephoneNumbera()) {
                    lineBuilder.append(";" + telephoneNumber);
                }
                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
