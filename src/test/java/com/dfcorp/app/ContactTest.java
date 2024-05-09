package com.dfcorp.app;

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

}
