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
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
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
                case "list":
                    list();
                    break;
                case "exit":
                    return;
            }
        }
    }

    public void add() {
        System.out.print("Enter the name of the person: ");
        String name = sc.nextLine();


        System.out.print("Enter the surname of the person: ");
        String surname = sc.nextLine();

        System.out.print("Enter the number: ");
        String number = sc.nextLine();

        phoneBook.add(name,surname,number);
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

    public void list() {
        phoneBook.list();
    }
}
