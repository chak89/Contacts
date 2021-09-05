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

    public void add( ) {
        Contacts contact;

        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();

        if(type.equals("person")) {

            Person person = new Person(Contacts.Type.PERSON);

            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            person.setName(name);

            System.out.print("Enter the surname: ");
            String surname = sc.nextLine();
            person.setSurname(surname);

            System.out.print("Enter the birth date: ");
            String birthDate = sc.nextLine();
            person.setBirthDate(birthDate);

            System.out.print("Enter the gender (M, F): ");
            String gender = sc.nextLine();
            person.setGender(gender);

            System.out.print("Enter the number: ");
            String number = sc.nextLine();
            person.setNumber(number);

            contact = person;

        }
        else if(type.equals("organization")) {
            Organization organization = new Organization(Contacts.Type.ORGANIZATION);

            System.out.print("Enter the organization name: ");
            String orgName = sc.nextLine();
            organization.setOrgName(orgName);

            System.out.print("Enter the address: ");
            String orgAddress = sc.nextLine();
            organization.setOrgAddress(orgAddress);

            System.out.print("Enter the number: ");
            String number = sc.nextLine();
            organization.setNumber(number);

            contact = organization;
        } else {
            return;
        }

        phoneBook.add(contact);
        System.out.println("The record added.\n");
    }

    public void remove() {
        if (phoneBook.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            list();
            System.out.print("Select a record: ");
            int record = sc.nextInt();
            phoneBook.remove(record-1);
            System.out.print("The record removed!");
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

            if (contact.getType().name().equals("PERSON")) {
                editPerson((Person) contact);
            }
            else if(contact.getType().name().equals("ORGANIZATION")) {
                editOrganization((Organization) contact);
            }

            System.out.println("The record updated!\n");
        }
    }

    public void editPerson(Person contact) {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = sc.nextLine();

        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.setName(sc.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                contact.setSurname(sc.nextLine());
                break;
            case "birthDate":
                System.out.print("Enter birth date: ");
                contact.setBirthDate(sc.nextLine());
                break;
            case "gender":
                System.out.print("Enter gender: ");
                contact.setGender(sc.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                contact.setNumber(sc.nextLine());
                break;
        }
    }

    public void editOrganization(Organization contact) {
        System.out.print("Select a field (name, address, number): ");
        String field = sc.nextLine();

        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.setOrgName(sc.nextLine());
                break;
            case "address":
                System.out.print("Enter address: ");
                contact.setOrgAddress(sc.nextLine());
                break;
            case "number":
                System.out.println("Enter number: ");
                contact.setNumber(sc.nextLine());
                break;
        }
    }



    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    public void info() {
        list();
        System.out.print("Enter index to show info: ");
        int index = Integer.parseInt(sc.nextLine());
        System.out.println(phoneBook.get(index-1));
    }

    public void list() {
        for (int i = 0; i < phoneBook.size(); i++) {
            System.out.println((i+1) + ". " + phoneBook.get(i).getNameInfo());
        }
    }

}
