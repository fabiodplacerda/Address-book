package com.dfcorp.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Nested
    @DisplayName("Contact Constructor Tests")
    class ContactConstructorTests{

        @Test
        @DisplayName("test that checks that values are set by constructor")
        void testValuesSetByConstructor(){
            // Arrange
            String testName = "James";
            String testPhoneNumber = "+447911123456";
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
    class ContactNameTests{
        String testPhoneNumber;
        String testEmail;
        @BeforeEach
        void setUp (){
            testPhoneNumber = "+447911123456";
            testEmail = "testEmail@gmail.com";
        }

        @Test
        @DisplayName("test that checks that when in the constructor name is null it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenNameIsNull(){
            // Arrange
            String testName = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }

        @Test
        @DisplayName("test that checks that when in the constructor name is empty string it throws IllegalArgumentException")
        void testConstructorThrowsIllegalArgumentExceptionWhenNameIsEmptyString(){
            // Arrange
            String testName = " ";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
        }
    }

}
