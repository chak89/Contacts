package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the person:");
        String name = sc.nextLine();

        System.out.println("Enter the surname of the person:");
        String sureName = sc.nextLine();

        System.out.println("Enter the number:");
        String number = sc.nextLine();

        Contacts contacts = new Contacts(name,sureName,number);

    }
}
