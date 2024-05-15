package com.dfcorp.application;

import com.dfcorp.app.AddressBook;
import com.dfcorp.app.Contact;
import com.dfcorp.app.UserInterface;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        ArrayList<Contact> contactList = addressBook.getContactList();
        boolean isRunning = true;


        while (isRunning) {
            String output = UserInterface.menu();

            if (output.equals("1")) {

                String[] userInputs = UserInterface.addCommand();

                try {
                    addressBook.addContact(new Contact(userInputs[0], userInputs[1], userInputs[2]));
                    System.out.println("Contact added successfully\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to added contact: " + e.getMessage() + "\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (output.equals("2")) {
                try {
                    Contact contactToRemove = UserInterface.removeCommand(contactList);
                    addressBook.removeContact(contactToRemove);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The contact you are trying to remove doesn't exist\n");
                }

            } else if (output.equals("3")) {

                System.out.println("Choose which contact you would like to Edit. Please user the numbers\n");

                try {
                    Contact contactToEdit = UserInterface.singleContact(contactList);
                    String[] userInputs = UserInterface.editCommand(contactToEdit);
                    addressBook.editContact(contactToEdit, userInputs[0], userInputs[1], userInputs[2]);
                    System.out.println("Contact edited successfully\n ");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to edit contact: " + e.getMessage() + "\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The contact you are trying to edit doesn't exist\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (output.equals("4")) {
                String userInput = UserInterface.searchCommand();
                if (addressBook.searchContact(userInput).isEmpty()) {
                    System.out.println("There are no contacts with this name\n");
                } else {
                    for (Contact contact : addressBook.searchContact(userInput)) {
                        System.out.println(contact);
                    }
                }

            } else if (output.equals("5")) {

                UserInterface.allContactsCommand(contactList);
                System.out.println("\n");

            } else if (output.equals("q")) {
                UserInterface.exitProgram();
                return;
            } else {
                System.out.println("Invalid command! Please Choose numbers (1-5)\n");

            }
        }
    }
}
