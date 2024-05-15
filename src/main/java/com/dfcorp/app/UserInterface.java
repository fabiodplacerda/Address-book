package com.dfcorp.app;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterface {

    static Scanner scanner = new Scanner(System.in);


    public static String menu() {
        System.out.println("What action would you like to perform? (Choose 1-5)\n1. Add a Contact\n2. Remove a Contact\n3. " +
                "Edit a Contact\n4. Search a Contact by name\n5. Get all Contacts in this address book\nQ. Exit program");
        return scanner.nextLine().toLowerCase();
    }

    public static String[] addCommand() {
        String[] result = new String[3];
        System.out.println("You are adding a new contact please provide a valid Name, Phone number and Email Address" +
                "\nWhat name would you like to have on your contact?");

        result[0] = scanner.nextLine();
        System.out.println("What phone Number would you like to have on your contact?");
        result[1] = scanner.nextLine();
        System.out.println("What Email address would you like to have on your contact?");
        result[2] = scanner.nextLine();

        return result;

    }

    public static Contact removeCommand(ArrayList<Contact> contactList) {
        System.out.println("Choose which contact you would like to remove. Please user the numbers");
        Contact contactToRemove = singleContact(contactList);
        System.out.println(contactToRemove + " has been removed from address book!\n");
        return contactToRemove;
    }

    public static String[] editCommand(Contact contact) {
        String[] result = new String[3];

        System.out.println("You are editing," + contact + "\nPlease choose a new name");
        result[0] = scanner.nextLine();
        System.out.println("Choose a new phone number");
        result[1] = scanner.nextLine();
        System.out.println("Choose a new email");
        result[2] = scanner.nextLine();

        return result;

    }

    public static String searchCommand() {
        System.out.println("You are searching for a contact please provide the name of that contact");
        return scanner.nextLine();
    }

    public static void allContactsCommand(ArrayList<Contact> contactList) {
        if (contactList.size() == 0) {
            System.out.println("You have no contacts on your list...");
        } else {
            System.out.println("Here is you full contact list");
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + ". " + contactList.get(i));
            }
        }

    }

    public static void exitProgram(){
         System.out.println("Exiting the program....");
    }

    public static Contact singleContact(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i + ". " + contactList.get(i));
        }
        String contactIndex = scanner.nextLine();
        return contactList.get(Integer.valueOf(contactIndex));

    }

//    private static void sleepTime(int time) {
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
