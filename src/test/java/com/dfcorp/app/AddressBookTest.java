package com.dfcorp.app;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class AddressBookTest {
    AddressBook testAddressBook;

    @BeforeEach
    void setUp() {
        testAddressBook = new AddressBook();
    }

    @AfterEach
    void tierDown() {
        testAddressBook = null;
    }

    @Nested
    @DisplayName("Add a Contact")
    class AddAContact {

        @Test
        @DisplayName("test that checks that when a new Contact is added to the ArrayList contactList has its size increased by 1")
        void testAddContactIncreasesArrayListSizeBy1() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            byte expected = (byte) (testAddressBook.getContactList().size() + 1);
            // Act
            testAddressBook.addContact(mockContact);
            byte actual = (byte) testAddressBook.getContactList().size();
            // Assert
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("test that checks after a new Contact is added the ArrayList contains that contact")
        void testAddContactToArrayListIsActuallyAdded() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            // Act
            testAddressBook.addContact(mockContact);
            // Assert
            assertTrue(testAddressBook.getContactList().contains(mockContact));
        }

        @Test
        @DisplayName("test that checks when adding a Null Contact to the ArrayList it throws an Error")
        void testAddContactThatIsNullItThrowsError() {
            // Arrange
            Contact testContact = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(testContact));
        }
    }

    @Nested
    @DisplayName("Unique Contacts")
    class UniqueContacts {


        @Test
        @DisplayName("test that checks that when trying to add a duplicate contact it throws an error")
        void testDuplicateContactThrowsError() {
            // Arrange
            String testName = "Fabio";
            String testPhoneNumber = "+4407812394921";
            String testEmailAddress = "test@email.com";

            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn(testName);
            when(mockContact.getPhoneNumber()).thenReturn(testPhoneNumber);
            when(mockContact.getEmailAddress()).thenReturn(testEmailAddress);

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getName()).thenReturn(testName);
            when(mockContact2.getPhoneNumber()).thenReturn(testPhoneNumber);
            when(mockContact2.getEmailAddress()).thenReturn(testEmailAddress);

            testAddressBook.addContact(mockContact);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact2));
        }
    }

    @Nested
    @DisplayName("Remove a contact")
    class RemoveAContact {
        Contact mockContact;

        @BeforeEach
        void setUp() {
            mockContact = mock(Contact.class);
        }

        @AfterEach
        void tierDown() {
            mockContact = null;
        }

        @Test
        @DisplayName("test that checks when you remove a contact from the ArrayList it has its size decreased by 1")
        void testRemoveContactDecreasesArrayListSizeBy1() {
            // Arrange
            testAddressBook.addContact(mockContact);
            byte expected = (byte) (testAddressBook.getContactList().size() - 1);
            // Act
            testAddressBook.removeContact(mockContact);
            byte actual = (byte) testAddressBook.getContactList().size();
            // Assert
            assertEquals(expected, actual);

        }

        @Test
        @DisplayName("test that checks that when the ArrayList has multiple Contacts the one you remove it's actually removed")
        void testRemoveContactWhenContactListHasMultipleContacts() {
            // Arrange
            Contact mockContact1 = mock(Contact.class);
            when(mockContact1.getPhoneNumber()).thenReturn("+44782121212");
            when(mockContact1.getEmailAddress()).thenReturn("email1@email.com");

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getPhoneNumber()).thenReturn("+44782121213");
            when(mockContact2.getEmailAddress()).thenReturn("email@email.com");

            testAddressBook.addContact(mockContact1);
            testAddressBook.addContact(mockContact2);
            // Act
            testAddressBook.removeContact(mockContact2);
            // Assert
            assertFalse(testAddressBook.getContactList().contains(mockContact2));
        }

        @Test
        @DisplayName("test that checks that when removing a Contact that doesn't exist in the ArrayList nothing happens")
        void testRemoveNonExistingContactShouldHaveNoEffect() {
            // Arrange
            Contact mockContact2 = mock(Contact.class);
            testAddressBook.addContact(mockContact);
            byte expected = (byte) testAddressBook.getContactList().size();
            // Act
            testAddressBook.removeContact(mockContact2);
            byte actual = (byte) testAddressBook.getContactList().size();
            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    @DisplayName("Search a contact")
    class SearchAContact {

        @Test
        @DisplayName("test that checks that when a Contact its searched by name if it exist it should return that contact")
        void testSearchContactByNameAndHaveAContactReturned() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("James");

            ArrayList<Contact> expected = new ArrayList<>();
            expected.add(mockContact);

            testAddressBook.addContact(mockContact);
            // Act
            ArrayList<Contact> actual = testAddressBook.searchContact("James");
            // Assert
            assertEquals(actual, expected);
        }

        @Test
        @DisplayName("test that checks that when a Contact its searched by name if it exist it should return that contact")
        void testSearchContactByNameAndIfNoMatchReturnsAnEmptyArrayList() {
            // Arrange
            ArrayList<Contact> expected = new ArrayList<>();
            // Act
            ArrayList<Contact> actual = testAddressBook.searchContact("James");
            // Assert
            assertEquals(actual, expected);
        }

    }

    @Nested
    @DisplayName("Edit a contact")
    class EditAContact {
        Contact mockContact;
        String testPhoneNumber;
        String testEmailAddress;

        @BeforeEach
        void setUp() {
            testPhoneNumber = "+447911123456";
            testEmailAddress = "test@email.com";

            mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Fabio");
            when(mockContact.getPhoneNumber()).thenReturn(testPhoneNumber);
            when(mockContact.getEmailAddress()).thenReturn(testEmailAddress);
            testAddressBook.addContact(mockContact);

        }

        @AfterEach
        void tierDown() {
            mockContact = null;
            testPhoneNumber = null;
            testEmailAddress = null;
        }

        @Test
        @DisplayName("test that checks that when you edit a contact with valid information it changes that contact")
        void testEditContactWithValidInformationAndItSavesThatContact() {
            // Arrange
            String testName = "Fabio";
            String newTestPhone = "+4407812345677";
            String newEmailAddress = "test2@gmail.com";
            // Act
            testAddressBook.editContact(mockContact, testName, newTestPhone, newEmailAddress);
            when(mockContact.getName()).thenReturn(testName);
            when(mockContact.getPhoneNumber()).thenReturn(newTestPhone);
            when(mockContact.getEmailAddress()).thenReturn(newEmailAddress);
            // Assert
            assertAll(
                    () -> assertEquals(testName, mockContact.getName()),
                    () -> assertEquals(newTestPhone, mockContact.getPhoneNumber()),
                    () -> assertEquals(newEmailAddress, mockContact.getEmailAddress())
            );
        }

        @Test
        @DisplayName("test that checks that when you edit a contact with invalid information it changes that contact")
        void testEditContactWithInvalidInformationAndItShouldThrowAError() {
            // Arrange
            String testName = null;
            String testPhoneNumber = "+447911123456";
            String testEmailAddress = "test@email.com";
            // Act

            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(mockContact, testName, testPhoneNumber, testEmailAddress));
        }

        @Test
        @DisplayName("test that checks that when you edit a contact with a duplicate information it throws an error")
        void testEditContactWithDuplicateInformationThrowsError() {
            // Arrange
            String testName = "Fabio";
            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getName()).thenReturn(testName);
            when(mockContact2.getPhoneNumber()).thenReturn("+4407812345677");
            when(mockContact2.getName()).thenReturn("test2@gmail.com");
            testAddressBook.addContact(mockContact2);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(mockContact2, testName, testPhoneNumber, testEmailAddress));
        }
    }

    @Nested
    @DisplayName("View all Contacts")
    class ViewAllContacts {

        @Test
        @DisplayName("test that checks that when getContactList is called it returns all the contacts in a contactList")
        void testGetContactListReturnsAllContactsInTheList() {
            // Arrange
            ArrayList<Contact> expected = new ArrayList<>();
            Contact mockContact = mock(Contact.class);
            when(mockContact.getPhoneNumber()).thenReturn("+440782121234");
            when(mockContact.getEmailAddress()).thenReturn("email@test.com");

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getPhoneNumber()).thenReturn("+440782121231");
            when(mockContact2.getEmailAddress()).thenReturn("emai2l@test.com");

            expected.add(mockContact);
            expected.add(mockContact2);

            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> actual = testAddressBook.getContactList();
            // Assert
            assertEquals(expected, actual);

        }

           @Test
        @DisplayName("test that checks that when getContactList is called it returns empty contactList if the address doesn't contain any contacts")
        void testGetContactListReturnsEmptyArrayListIfNoContactInAddressBook() {
            // Arrange
            ArrayList<Contact> expected = new ArrayList<>();
            // Act
            ArrayList<Contact> actual = testAddressBook.getContactList();
            // Assert
            assertEquals(expected, actual);

        }
    }
}
