package online.denseleznev.emailapp;

import java.util.Scanner;

public class Email {

    private final String firstName;
    private final String lastName;
    private String password;
    private final int DEFAULT_PASSWORD_LENGTH = 8;
    private String department;
    private String email;
    private int mailboxCapacity;
    private String alternateEmail;
    private final String DOMAIN = "anycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // call a method asking for the department code
        this.department = setDepartment();

        // call a method that returns a random password which can be changed by user
        this.password = generatePassword(DEFAULT_PASSWORD_LENGTH);
        System.out.print("Generated password is: " + this.password +
            "\nEnter new password (hit 'Enter' to leave unchanged)");
        Scanner in = new Scanner(System.in);
        String newPassword = in.nextLine();
        if (!newPassword.equals("")) {
            this.changePassword(newPassword);
            System.out.println("Password changed to '" + this.password + "'");
        }

        // set the mailbox capacity
        System.out.print("Enter mailbox capacity (mb): ");
        in = new Scanner(System.in);
        this.mailboxCapacity = in.nextInt();

        // set alternate email address
        System.out.print("Enter alternate email: ");
        in = new Scanner(System.in);
        this.alternateEmail = in.nextLine();


        // combine elements to generate email address
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + DOMAIN;

    }

    // ask for the department
    private String setDepartment() {
        System.out.print
            ("New employee: " + this.firstName + " " + this.lastName +
                    ".\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {
            return "sales.";
        } else if (departmentChoice == 2) {
            return "dev.";
        } else if (departmentChoice == 3) {
            return "acct.";
        } else {
            return "";
        }
    }

    // generate a random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password);
    }

    // set the mailbox capacity
    private void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set the alternate email
    private void setAlternateEmail(String email) {
        this.alternateEmail = email;
    }

    // change the password
    private void changePassword(String password) {
        this.password = password;
    }

    public String showInfo() {
        return "\n\n\nDisplay name: " + this.firstName + " " + this.lastName + "\nCompany email: " + this.email +
                "\nMailbox capacity: " + this.mailboxCapacity + "mb\nAlternate email: " + this.alternateEmail;
    }
}
