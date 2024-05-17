package com.dfcorp.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Nested
    @DisplayName("Contact Constructor Tests")
    class ContactConstructorTests {

        @Test
        @DisplayName("test that checks that values are set by constructor")
        void testValuesSetByConstructor() {
            // Arrange
            String testName = "James";
            String testPhoneNumber = "07123456789";
            String testEmail = "testEmail@gmail.com";
            // Act
            Contact testContact = new Contact(testName, testPhoneNumber, testEmail);
            // Assert
            assertAll(
                    () -> assertEquals(testName, testContact.getName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmailAddress())
            );
        }
    }

    @Nested
    @DisplayName("Contact Name Tests")
    class ContactNameTests {
        String testPhoneNumber;
        String testEmail;

        @BeforeEach
        void setUp() {
            testPhoneNumber = "07123456789";
            testEmail = "testEmail@gmail.com";
        }

        @AfterEach
        void tearDown() {
            testPhoneNumber = null;
            testEmail = null;
        }

        @Test
        @DisplayName("test that checks that when in the constructor the name is null it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenNameIsNull() {
            // Arrange
            String testName = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that when in the constructor name is an empty string, it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenNameIsEmptyString() {
            // Arrange
            String testName = " ";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that name only should contain letters if it doesn't, it should throw IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenNameIsNotOnlyLetters() {
            // Arrange
            String testName = "Fabio1";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }
    }

    @Nested
    @DisplayName("Contact phoneNumber Tests")
    class ContactPhoneNumberTests {
        String testName;
        String testEmail;

        @BeforeEach
        void setUp() {
            testName = "James";
            testEmail = "testEmail@gmail.com";
        }

        @AfterEach
        void tearDown() {
            testName = null;
            testEmail = null;
        }

        @Test
        @DisplayName("test that checks that when in the constructor the phoneNumber is null it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenPhoneNumberIsNull() {
            // Arrange
            String testPhoneNumber = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that when in the constructor phoneNumber is an empty string, it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenPhoneNumberIsEmptyString() {
            // Arrange
            String testPhoneNumber = " ";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that phoneNumber only should contain digits if it doesn't, it should throw IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenPhoneNumberIsNotOnlyDigits() {
            // Arrange
            String testPhoneNumber = "o7123456789";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that phoneNumber length shouldn't be longer then 15 if it is throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenPhoneNumberLengthIsGreaterThen15() {
            // Arrange
            String testPhoneNumber = "0712345678921313131231";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }
    }

    @Nested
    @DisplayName("Contact email tests")
    class ContactEmailTests {

        String testName;
        String testPhoneNumber;

        @BeforeEach
        void setUp() {
            testName = "James";
            testPhoneNumber = "07123456789";
        }

        @AfterEach
        void tearDown() {
            testName = null;
            testPhoneNumber = null;
        }

        @Test
        @DisplayName("test that checks that when in the constructor the email is null it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenEmailIsNull() {
            // Arrange
            String testEmail = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that when in the constructor the email is empty string it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenEmailIsEmptyString() {
            // Arrange
            String testEmail = " ";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that when in the constructor the email doesn't follow the standardize email string it IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenEmailIsNotValid() {
            // Arrange
            String testEmail = "testemail";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }
    }

}
