# Domain Models, Class Diagrams and Test Plan

## User Story 1: Add Contact

As a user\
I want to be able to add a contact to my address book\
So that I can store my contacts

### Tests user story 1
- **Test 1.1:** Add a Contact and see that the ArrayList size its increased by 1.
- **Test 1.2:** Add a Contact and see that the ArrayList actually contains that contact.
- **Test 1.3:** A null Contact should not be added to the ArrayList.


## User Story 2: Remove Contact

As a user\
I want to be able to remove a contact from my address book\
So that I can manage my contacts


### Tests user story 2
- **Test 2.1:** Remove a Contact and see that the ArrayList size decreases by 1.
- **Test 2.2:** Remove a Contact and see its actual remove from the ArrayList.
- **Test 2.3:** If the contact doesn't exist in the ArrayList nothing should happen.

## User Story 3: Search Contact

As a user\
I want to be able to search for a contact by name\
So that I can select a specific person in my address book

### Tests user story 3
- **Test 3.1:** search for a Contact by name and as a result should be able to see the contact and its details.
- **Test 3.2:** searching for an inexisting contact should have returned a feedback message.

## User Story 4: Edit Contact

As a user\
I want to be able to edit a contact's details\
So that I can update my contacts

### Tests user story 4

- **Test 4.1:** Edit a contact with valid information, and it should change the contact.
- **Test 4.2:** Edit a contact with non-valid information, and it should not alter the contact.
- **Test 4.3:** Edit a contact with missing information, should not alter that contact.

## User Story 5: Unique Contacts

As a user\
I want to have only unique contact\
So that I don't have any duplicate contacts

### Test user story 5

- **Test 5.1:** Duplicate contact shouldn't be added to the address book.

## User Story 6: View all Contacts

As a user\
I want to be able to view all my contacts in the address book\
So that I can see all of my contacts that I have stored

### Test user story 6

- **Test 6.1:** View all the contacts in the address book should return all contacts in the ArraysList. 
- **Test 6.2:** Try to view all contacts but if ArrayList is empty, it should return a message to the user.

## User Story 7: Console Interaction

As a user\
I want to be able to interact with this application by using the console interface\
So that I can use the application 

```mermaid
classDiagram
    class AddressBook{
       -contactList ArrayList <Contact>
       +addContact(Contact contact) void
       +removeContact (Contact contact) Void
       +editContact (Contact contact) void
       +searchContact (String name) Contact
       +getContactList() ArrayList <Contact>
    }
    
    class Contact{
        -name String
        -phoneNumber String
        -emailAddress String
        +getName() String
        +getPhoneNumber() String
        +getEmailAddress() String
        +setName(String name) void
        +setPhoneNumber(String phoneNumber) void
        +setEmailAddress(String email) void
        -validateName(String name) void
        -validatePhoneNumber(String phoneNumber) void
        -validateEmailAddress(String email) void
        -validateString(String string)$ void
    }
    
```


