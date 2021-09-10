package contacts;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;
    private final PhoneBook phoneBook;
    private final boolean saveToDisk;
    private final String fileName;

    public UserInterface(PhoneBook phoneBook, boolean saveToDisk, String fileName) {
        this.sc = new Scanner(System.in);
        this.phoneBook = phoneBook;
        this.saveToDisk = saveToDisk;
        this.fileName = fileName;
    }

    public void userInput() {
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String command = sc.nextLine();

            switch (command) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "search":
                    search();
                    break;
                case "count":
                    count();
                    break;
                case "exit":
                    return;
            }
        }
    }

    public void add() {
        phoneBook.add();
        if (saveToDisk) {
            SaveToDisk();
        }
    }

    public void list() {
        phoneBook.list();
        if (saveToDisk) {
            SaveToDisk();
        }
    }

    public void search() {
        phoneBook.search();
        if (saveToDisk) {
            SaveToDisk();
        }
    }

    public void count() {
       phoneBook.count();
    }

    public void SaveToDisk() {
        try {
            ReadWriteFile.serialize(phoneBook,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
