package com.dfcorp.app.utils;

import com.dfcorp.app.AddressBook;
import com.dfcorp.app.Contact;

import java.util.ArrayList;

public abstract class Message {

    public static void print(String message){
        System.out.println(message + "\n");
    }

    public static void printContact(Contact contact){
        System.out.println(contact);
    }

    public static void printContactSelection(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i + ". " + contactList.get(i));
        }

    }

     public static void printAllContacts(ArrayList<Contact> contactList) {
        if (contactList.isEmpty()) {
            System.out.println("You have no contacts on your list...");
        } else {
            System.out.println("Here is you full contact list");
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + ". " + contactList.get(i));
            }
        }

    }

    public static void printSearchResults(String name ,AddressBook addressBook){
    if (addressBook.searchContact(name).isEmpty()) {
                        Message.print("There are no contacts with this name");
                    } else {
                        Message.print("Here is your result");
                        for (Contact contact : addressBook.searchContact(name)) {
                            Message.printContact(contact);
                        }
                    }
    }

}
