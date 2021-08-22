package contacts;

public class Contacts {
    private String name;
    private String sureName;
    private String number;


    public Contacts(String name, String sureName, String number) {
        this.name = name;
        this.sureName = sureName;
        this.number = number;

        System.out.println("A record created!\n" +
                "A Phone Book with a single record created!");
    }


}
