package online.denseleznev.emailapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // get first name and last name from system input
        System.out.print("Enter first name: ");
        Scanner in = new Scanner(System.in);
        final String firstName = in.next();

        System.out.print("Enter last name: ");
        in = new Scanner(System.in);
        final String lastName = in.next();

        // create new email object
        Email email = new Email(firstName, lastName);

        // show info about created email
        System.out.println(email.showInfo());
    }
}
