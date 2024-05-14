package com.dfcorp.app;

import com.dfcorp.app.utils.Validator;
import java.util.ArrayList;


public class AddressBook {
    final private ArrayList<Contact> contactList = new ArrayList<>();

    public AddressBook() {
    }

    public void addContact(Contact contact) {
        if (Validator.isContactNull(contact)) throw new IllegalArgumentException("Invalid Contact");
        this.contactList.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contactList.remove(contact);
    }

    public void editContact(Contact contact, String newName, String newPhoneNumber, String newEmailAddress) {
        if(Validator.isNull(newName) || Validator.isNull(newPhoneNumber) || Validator.isNull(newEmailAddress)) throw new IllegalArgumentException("Invalid values");
        if(isDuplicate(newPhoneNumber,newEmailAddress)) throw new IllegalArgumentException("The contacts in address book must be unique");
        for (Contact contactInArrayList : contactList) {
            if (contact.equals(contactInArrayList)) {
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmailAddress(newEmailAddress);
            }
        }

    }

    public ArrayList<Contact> searchContact(String name) {
        ArrayList<Contact> contactsToReturn = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                contactsToReturn.add(contact);
            }
            ;
        }
        return contactsToReturn;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    private boolean isDuplicate (String phoneNumber, String emailAddress){
        for( Contact contactInList : contactList){
            if(contactInList.getPhoneNumber().equals(phoneNumber) || contactInList.getEmailAddress().equals(emailAddress)){
                return true;
            }
        }
        return false;
    }


}
