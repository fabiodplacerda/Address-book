package com.dfcorp.application;

import com.dfcorp.app.AddressBook;
import com.dfcorp.app.Contact;
import com.dfcorp.app.UserInputs;
import com.dfcorp.app.utils.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        ArrayList<Contact> contactList = addressBook.getContactList();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;


        while (isRunning) {
            Message.print("What action would you like to perform? (Choose 1-5)\n1. Add a Contact\n2. Remove a Contact\n3. Edit a Contact\n4. Search a Contact by name\n5. Get all Contacts in this address book\nQ. Exit program");
            String output = UserInputs.getCommand(scanner.nextLine());
            switch (output) {
                case "1":
                    Message.print("You are adding a new contact please provide a valid Name, Phone number and Email Address");
                    String[] userInputAdd = UserInputs.getContactDetails(scanner);

                    try {
                        addressBook.addContact(new Contact(userInputAdd[0], userInputAdd[1], userInputAdd[2]));
                        Message.print("Contact added successfully");
                    } catch (IllegalArgumentException e) {
                        Message.print("Failed to added contact: " + e.getMessage());
                    }

                    break;
                case "2":
                    Message.print("Choose which contact you would like to remove. Please user the numbers");
                    try {
                        Message.printAllContacts(contactList);
                        Contact contactToRemove = contactList.get(UserInputs.getIndex(scanner));
                        addressBook.removeContact(contactToRemove);
                        Message.print(contactToRemove + " has been removed from address book!");
                    } catch (IndexOutOfBoundsException e) {
                        Message.print("The contact you are trying to remove doesn't exist");
                    }
                    break;

                case "3":

                    Message.print("Choose which contact you would like to Edit. Please user the numbers");
                    Message.printContactSelection(contactList);
                    try {

                        Contact contactToEdit = contactList.get(UserInputs.getIndex(scanner));
                        Message.print("You are editing," + contactToEdit);
                        String[] userInputEdit = UserInputs.getContactDetails(scanner);
                        addressBook.editContact(contactToEdit, userInputEdit[0], userInputEdit[1], userInputEdit[2]);
                        Message.print("Contact edited successfully");
                    } catch (NumberFormatException e) {
                        Message.print("Invalid input please provide a number");
                    } catch (IllegalArgumentException e) {
                        Message.print("Failed to edit contact: " + e.getMessage());
                    } catch (IndexOutOfBoundsException e) {
                        Message.print("The contact you are trying to edit doesn't exist");
                    }
                    break;
                case "4":
                    Message.print("You are searching for a contact please provide the name of that contact");
                    String contactByName = scanner.nextLine();
                    Message.printSearchResults(contactByName, addressBook);
                    break;
                case "5":
                    Message.printAllContacts(contactList);
                    Message.print("\n");
                    break;
                case "q":
                    Message.print("Exiting the program....");
                    return;
                default:
                    Message.print("Invalid command! Please Choose numbers (1-5)");
                    break;

            }
        }
    }
}
