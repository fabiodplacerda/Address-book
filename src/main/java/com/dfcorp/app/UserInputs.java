package com.dfcorp.app;

import java.util.Scanner;

public abstract class UserInputs {

    // Method that gets an is
    public static String getCommand(Scanner scanner) {
        String command = scanner.nextLine();
        return command.toLowerCase();
    }

    // Method that gets user inputs in the console and returns a Array
    public static String[] getContactDetails(Scanner scanner) {
        System.out.println("Please provide the following details:");

        System.out.println("Name (only letters):");
        String name = scanner.nextLine();

        System.out.println("Phone Number (only numbers and starting with 0):");
        String phoneNumber = scanner.nextLine();

        System.out.println("Email (example@email.com):");
        String email = scanner.nextLine();

        return new String[]{name, phoneNumber, email};

    }

    // Method that gets user input and returns a number
    public static int getIndex(Scanner scanner){
        String contactIndex = scanner.nextLine();
        return Integer.parseInt(contactIndex);
    }

    public static String getName (Scanner scanner){
        String name = scanner.nextLine();
        return name;
    }

}
