package be.pxl.fileio.Streams.oefening1;

import java.util.ArrayList;

public class Persoon {
    private String name;
    private ArrayList<String> telephoneNumbers;

    public Persoon(String name) {
        this.name = name;
        this.telephoneNumbers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTelephoneNumbera() {
        return telephoneNumbers;
    }

    public void addTelephoneNumber(String telephoneNumber) {
        this.telephoneNumbers.add(telephoneNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Name: %s%n", name));
        for (String telefoonnummer:telephoneNumbers) {
            sb.append(String.format("Telefoonnummer: %s%n", telefoonnummer));
        }

        return sb.toString();
    }
}
