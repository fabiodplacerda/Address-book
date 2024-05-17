package com.dfcorp.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserInputsTest {

    private Scanner scanner;

    @BeforeEach
    void setup() {
        scanner = Mockito.mock(Scanner.class);
    }

    @AfterEach
    void tearDown(){
        scanner = null;
    }

    @Test
    @DisplayName("test that checks that getContactDetailsMethod returns an array with user inputs")
    void testGetContactDetailsReturnArrayOfUserInputs() {
        // Arrange
        String testName = "Fabio";
        String testPhoneNumber = "0782121212";
        String testEmail = "email@gmail.com";
        when(scanner.nextLine()).thenReturn(testName, testPhoneNumber, testEmail);
        String[] expected = {testName, testPhoneNumber, testEmail};

        // Act
        String[] actual = UserInputs.getContactDetails(scanner);

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("test that checks that command method takes the user input an returns a lower case string")
    void testThatChecksThatGetCommandMethodReturnsALowerCaseString() {
        // Arrange
        String input = "Q";
        String expected = "q";
        when(scanner.nextLine()).thenReturn(input);
        // Act
        String actual = UserInputs.getCommand(scanner);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test that checks that the index method should return a int")
    void testThatCheckThatGetIndexReturnsANumber() {
        // Arrange
        String input = "5";
        int expected = 5;
        when(scanner.nextLine()).thenReturn(input);

        // Act
        int actual = UserInputs.getIndex(scanner);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test that checks that the getName method should returns a String")
    void testThatCheckThatGetNameReturnsAString() {
        // Arrange
        String input = "Fabio";
        String expected = "Fabio";
        when(scanner.nextLine()).thenReturn(input);

        // Act
        String actual = UserInputs.getName(scanner);

        // Assert
        assertEquals(expected, actual);
    }

}
