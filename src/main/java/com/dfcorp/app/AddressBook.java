package com.dfcorp.app;

import com.dfcorp.app.utils.Validator;

import java.util.ArrayList;


public class AddressBook {
    final private ArrayList<Contact> contactList = new ArrayList<>();

    // Method that adds a contact to the AddressBook
    public void addContact(Contact contact) {
        if (Validator.isContactNull(contact)) throw new IllegalArgumentException("Invalid Contact");
        if (isDuplicate(contact.getPhoneNumber(), contact.getEmailAddress()))
            throw new IllegalArgumentException("Phone number or Email, already exist in the address book. Please provide unique phone number or email");

        this.contactList.add(contact);
    }

    // Method that removes a contact from the AddressBook
    public void removeContact(Contact contact) {
        this.contactList.remove(contact);
    }

    // Method that edits a contact in the AddressBook, iterating over the contactList
    public void editContact(Contact contact, String newName, String newPhoneNumber, String newEmailAddress) {
        Validator.validateName(newName);
        Validator.validatePhoneNumber(newPhoneNumber);
        Validator.validateEmailAddress(newEmailAddress);
        if (isDuplicate(newPhoneNumber, newEmailAddress))
            throw new IllegalArgumentException("The contacts in address book must be unique");
        for (Contact contactInArrayList : contactList) {
            if (contact.equals(contactInArrayList)) {
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmailAddress(newEmailAddress);
            }
        }

    }

    // Method that searches for a contact using the name associated with that contact (case-insensitive)
    public ArrayList<Contact> searchContact(String name) {
        ArrayList<Contact> contactsToReturn = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().equals(name.toLowerCase())) {
                contactsToReturn.add(contact);
            }
        }
        return contactsToReturn;
    }

    // Method that returns the full contactList
    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    // Method that checks if there are phone number or email address already exists in the AddressBook
    private boolean isDuplicate(String phoneNumber, String emailAddress) {
        for (Contact contactInList : contactList) {
            if (contactInList.getPhoneNumber().equals(phoneNumber) || contactInList.getEmailAddress().equals(emailAddress)) {
                return true;
            }
        }
        return false;
    }
}
