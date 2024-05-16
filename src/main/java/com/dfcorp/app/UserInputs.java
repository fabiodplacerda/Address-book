package com.dfcorp.app;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterface {


    public static String command(String command) {
        return command.toLowerCase();
    }

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

    public static int index (Scanner scanner){
        String contactIndex = scanner.nextLine();
        return Integer.parseInt(contactIndex);
    }

}
