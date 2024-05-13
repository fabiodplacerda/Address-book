package com.dfcorp.app;



import java.util.ArrayList;


public class AddressBook {
   final private ArrayList <Contact> contactList = new ArrayList<>();

    public AddressBook(){}

    public void addContact(Contact contact){
        if(contact == null) throw new IllegalArgumentException("Invalid Contact");
        this.contactList.add(contact);
    }

    public void removeContact( Contact contact){
        this.contactList.remove(contact);
    }

    public ArrayList searchContact (String name){
        ArrayList <Contact> contactsToReturn = new ArrayList<>();
        for(Contact contact : contactList){
            if(contact.getName().equals(name)){
                 contactsToReturn.add(contact);
            };
        }
        return contactsToReturn;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }
}
