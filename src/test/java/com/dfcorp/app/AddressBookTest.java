package com.dfcorp.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


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
    @DisplayName("Remove a contact")
    class RemoveAContact {
        AddressBook testAddressBook;
        Contact mockContact;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
        }

        @AfterEach
        void tierDown() {
            testAddressBook = null;
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
            Contact mockContact2 = mock(Contact.class);
            Contact mockContact3 = mock(Contact.class);
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContact2);
            testAddressBook.addContact(mockContact3);
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
            assertEquals(expected,actual);

        }
    }
}
