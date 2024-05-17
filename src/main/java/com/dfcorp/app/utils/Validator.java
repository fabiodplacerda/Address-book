package com.dfcorp.app.utils;

import com.dfcorp.app.Contact;

import java.util.regex.Pattern;

public abstract class Validator {

    final private static String NAME_REGEX = "[a-zA-Z\\s]+";
    final private static String PHONE_NUMBER_REGEX = "0[0-9\\s]+";
    final private static String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static boolean isStringEmpty(String string) {
        return string.trim().isEmpty();
    }

    private static boolean isNull(String string) {
        return string == null;
    }

    private static boolean matchesNameRegex(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }

    private static boolean matchesPhoneNumberRegex(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }

    private static boolean matchesEmailAddressRegex(String emailAddress) {
        return Pattern.matches(EMAIL_REGEX, emailAddress);
    }

    public static String validateName(String name) {
        if (isNull(name) || isStringEmpty(name) || !matchesNameRegex(name))
            throw new IllegalArgumentException("Invalid Name");
        return name;
    }

    public static String validatePhoneNumber(String phoneNumber) {
        if (isNull(phoneNumber) || isStringEmpty(phoneNumber) || !matchesPhoneNumberRegex(phoneNumber)
                || phoneNumber.length() > 11) throw new IllegalArgumentException("Invalid Phone Number");
        return phoneNumber.trim();
    }

    public static String validateEmailAddress(String emailAddress) {
        if (isNull(emailAddress) || isStringEmpty(emailAddress) || !matchesEmailAddressRegex(emailAddress))
            throw new IllegalArgumentException("Invalid Email Address");
        return emailAddress;
    }

    public static boolean isContactNull(Contact contact) {
        return contact == null;
    }
}
