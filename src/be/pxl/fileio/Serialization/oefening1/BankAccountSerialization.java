package be.pxl.fileio.Serialization.oefening1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BankAccountSerialization {

    public static void main(String[] args) {
        //BankAccount bankAccount = new BankAccount("Nele Custers", "0489/12.34.56", "Lectorstraat 1", 0);
        transferMoney("REK001", 500);
        BankAccount bankAccount = readBankAccount();
        System.out.println(bankAccount);
    }

    public static BankAccount readBankAccount() {
        Path path = Paths.get("data/bankaccount.ser");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))){
            return (BankAccount) objectInputStream.readObject();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeBankAccount(BankAccount bankAccount) {
        Path path = Paths.get("data/bankaccount.ser");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
            objectOutputStream.writeObject(bankAccount);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void transferMoney(String accountnumber, double amount) {
        BankAccount bankAccount = readBankAccount();
        if (bankAccount.getAccountnumber().equals(accountnumber)) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
        }
        writeBankAccount(bankAccount);
    }
}
