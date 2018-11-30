package be.pxl.fileio.Serialization.oefening1;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String accountnumber;
    private String telephonenumber;
    private String name;
    private String address;
    private double balance;
    private int lastDigitOfAccountnumber = 0;

    {
        lastDigitOfAccountnumber++;
    }

    public BankAccount(String name, String telephonenumber, String address, double balance) {
        this.accountnumber = "REK" + String.format("%03d", lastDigitOfAccountnumber);
        this.name = name;
        this.telephonenumber = telephonenumber;
        this.address = address;
        this.balance = balance;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Accountnumber: %s%n" +
                             "Name: %s%n" +
                             "Telephonenumber: %s%n" +
                             "Address: %s%n" +
                             "Balance: € %.2f%n", accountnumber, name, telephonenumber, address, balance);
    }
}
