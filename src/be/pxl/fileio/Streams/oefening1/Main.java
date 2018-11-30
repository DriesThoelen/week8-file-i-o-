package be.pxl.fileio.Streams.oefening1;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Telefoonboek telefoonboek = new Telefoonboek();

        System.out.printf("Geef je keuze in :%n1.Een nieuwe gebruiker toevoegen%n2.Een gebruiker opzoeken%nEender welk ander getal om af te sluiten.%n");
        int keuze = scanner.nextInt();

        switch (keuze) {
            case 1:
                scanner.nextLine();
                System.out.println("Geef de naam van een nieuwe gebruiker op");
                String naam = scanner.nextLine();

                Persoon newPersoon = new Persoon(naam);

                System.out.println("Geef een telefoonnummer op");
                String telefoonnummer = scanner.nextLine();

                newPersoon.addTelephoneNumber(telefoonnummer);

                telefoonboek.addPerson(newPersoon);
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Geef een naam voor te zoeken op");
                String querry = scanner.nextLine();
                Persoon persoon = telefoonboek.getPerson(querry);
                System.out.println(persoon);
            default:
                System.exit(0);
        }
    }
}
