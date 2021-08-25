package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    List<Contacts> phoneBook;
    Scanner sc;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void add(String name, String surname, String number) {
        phoneBook.add(new Contacts(name,surname,number));
        System.out.println("The record added.");
    }

    public void remove() {
        if (phoneBook.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            list();
            System.out.print("Select a record: ");
            int record = sc.nextInt();
            phoneBook.remove(record-1);
            System.out.println("The record removed!");
        }
    }

    public void edit() {
        if (phoneBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            list();
            System.out.print("Select a record: ");
            int record = Integer.parseInt(sc.nextLine());
            Contacts contact = phoneBook.get(record - 1);

            System.out.print("Select a field (name, surname, number): ");
            String field = sc.nextLine();

            switch (field) {
                case "name":
                    System.out.print("Enter name: ");
                    contact.setName(sc.nextLine());
                    break;
                case "surname":
                    System.out.print("Enter surname: ");
                    contact.setSurName(sc.nextLine());
                    break;
                case "number":
                    System.out.print("Enter number: ");
                    contact.setNumber(sc.nextLine());
                    break;
            }

            System.out.println("The record updated!");
        }
    }

    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    public void list() {
        for (int i = 0; i < phoneBook.size(); i++) {
            System.out.println((i+1) + ". " + phoneBook.get(i));
        }
    }

}
