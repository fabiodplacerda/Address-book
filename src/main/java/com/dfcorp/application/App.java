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
            switch (output) {
                case "1":

                    String[] userInputs = UserInterface.addCommand();

                    try {
                        addressBook.addContact(new Contact(userInputs[0], userInputs[1], userInputs[2]));
                        System.out.println("Contact added successfully\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Failed to added contact: " + e.getMessage() + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        Contact contactToRemove = UserInterface.removeCommand(contactList);
                        addressBook.removeContact(contactToRemove);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The contact you are trying to remove doesn't exist\n");
                    }

                    break;

                case "3":

                    System.out.println("Choose which contact you would like to Edit. Please user the numbers\n");

                    try {
                        Contact contactToEdit = UserInterface.singleContact(contactList);
                        String[] userInputsEdit = UserInterface.editCommand(contactToEdit);
                        addressBook.editContact(contactToEdit, userInputsEdit[0], userInputsEdit[1], userInputsEdit[2]);
                        System.out.println("Contact edited successfully\n ");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Failed to edit contact: " + e.getMessage() + "\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The contact you are trying to edit doesn't exist\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "4":
                    String userInput = UserInterface.searchCommand();
                    if (addressBook.searchContact(userInput).isEmpty()) {
                        System.out.println("There are no contacts with this name\n");
                    } else {
                        System.out.println("Here is your result");
                        for (Contact contact : addressBook.searchContact(userInput)) {
                            System.out.println(contact);
                        }
                        System.out.println("\n");
                    }
                    break;
                case "5":

                    UserInterface.allContactsCommand(contactList);
                    System.out.println("\n");
                    break;
                case "q":
                    UserInterface.exitProgram();
                    return;
                default:
                    System.out.println("Invalid command! Please Choose numbers (1-5)\n");
                    break;

            }
        }
    }
}
