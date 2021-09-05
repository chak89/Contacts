package contacts;

import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;
    private final PhoneBook phoneBook;

    public UserInterface(PhoneBook phoneBook) {
        this.sc = new Scanner(System.in);
        this.phoneBook = phoneBook;
    }

    public void userInput() {
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String command = sc.nextLine();

            switch (command) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    count();
                    break;
                case "info":
                    info();
                    break;
                case "exit":
                    return;
            }
        }
    }

    public void add() {
        phoneBook.add();
    }

    public void remove() {
        phoneBook.remove();
    }

    public void edit() {
        phoneBook.edit();
    }

    public void count() {
        phoneBook.count();
    }

    public void info() {
        phoneBook.info();
    }
}
