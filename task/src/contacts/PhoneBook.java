package contacts;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Contacts> phoneBook;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        Contacts contact;
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();

        if (type.equals("person")) {

            Person person = new Person();

            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            person.setName(name);

            System.out.print("Enter the surname: ");
            String surname = sc.nextLine();
            person.setSurname(surname);

            System.out.print("Enter the birth date: ");
            String birthDate = sc.nextLine();
            person.setBirth(birthDate);

            System.out.print("Enter the gender (M, F): ");
            String gender = sc.nextLine();
            person.setGender(gender);

            System.out.print("Enter the number: ");
            String number = sc.nextLine();
            person.setNumber(number);

            contact = person;

        } else if (type.equals("organization")) {
            Organization organization = new Organization();

            System.out.print("Enter the organization name: ");
            String orgName = sc.nextLine();
            organization.setName(orgName);

            System.out.print("Enter the address: ");
            String orgAddress = sc.nextLine();
            organization.setAddress(orgAddress);

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

    public void remove(Contacts result) {
        if (phoneBook.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            phoneBook.remove(result);
            System.out.print("The record removed!\n\n");
        }
    }


    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search query: ");
        String query = sc.nextLine();

        List<Contacts> matchedQueries = new ArrayList<>();

        for (Contacts contact : phoneBook) {
            Pattern pattern = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(contact.toString());

            if (matcher.find()) {
                matchedQueries.add(contact);
            }
        }

        System.out.println("Found " + matchedQueries.size() + " results:");
        for (int i = 0; i < matchedQueries.size(); i++) {
            System.out.println((i + 1) + ". " + matchedQueries.get(i).getNameInfo());
        }
        System.out.println();

        //Enter search menu
        searchMenu(matchedQueries);
    }

    //Search menu
    public void searchMenu(List<Contacts> matchedQueries) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[search] Enter action ([number], back, again): ");
        String input = sc.nextLine();

        //[number]
        if (input.matches("\\d+")) {
            Contacts result = matchedQueries.get(Integer.parseInt(input) - 1);
            System.out.println(result);

            //Enter record menu
            recordMenu(result);


        } else if (input.equals("back")) {
        } else if (input.equals("again")) {
            search();
        }
    }

    //Record menu
    public void recordMenu(Contacts result) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String input = sc.nextLine();

        switch (input) {
            case "edit":
                edit(result);
                break;
            case "delete":
                remove(result);
                break;
            case "menu":
                break;
        }
    }

    public void edit(Contacts result) {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {

            List<Field> nameFields = result.getInstanceDeclaredFields();
            StringBuilder str = new StringBuilder();
            str.append("Select a field (");
            for (Field field : nameFields) {
                str.append(field.getName()).append(", ");
            }
            str.delete(str.length() - 2, str.length());
            str.append("): ");

            System.out.print(str);
            String methodToCall = sc.nextLine();

            System.out.print("Enter " + methodToCall + ": ");
            String stringValue = sc.nextLine();

            result.getSetter(methodToCall, stringValue);
            System.out.println("Saved");
            System.out.println(result);

            System.out.println("The record updated!\n");
        }
    }


    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
        System.out.println();
    }

    public void list() {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.size() > 0) {
            for (int i = 0; i < phoneBook.size(); i++) {
                System.out.println((i + 1) + ". " + phoneBook.get(i).getNameInfo());
            }

            System.out.println();
            System.out.print("[list] Enter action ([number], back): ");
            String input = sc.nextLine();

            //[number]
            if (input.matches("\\d+")) {
                Contacts result = phoneBook.get(Integer.parseInt(input) - 1);
                System.out.println(result);

                //Enter record menu
                recordMenu(result);
            } else if (input.equals("back")) {
            }
        }

    }

}
