package com.dfcorp.app.utils;

import com.dfcorp.app.Contact;

import java.util.regex.Pattern;

public abstract class Validator {
    private static boolean isStringEmpty(String string){
        return string.trim().isEmpty();
    }

    private static boolean isNull(String string){
        return string == null;
    }

    private static boolean matchesNameRegex(String name){
        return Pattern.matches("[a-zA-Z\\s]+", name);
    }

    private static boolean matchesPhoneNumberRegex (String phoneNumber){
        return Pattern.matches("0[0-9\\s]+", phoneNumber);
    }

    private static boolean matchesEmailAddressRegex (String emailAddress){
        return  Pattern.matches(".+@.+", emailAddress);
    }

    public static String validateName (String name) {
        if(isNull(name)|| isStringEmpty(name) || !matchesNameRegex(name)) throw new IllegalArgumentException("Invalid Name");
        return name;
    }

      public static String validatePhoneNumber (String phoneNumber){
        if( isNull(phoneNumber)|| isStringEmpty(phoneNumber) || !matchesPhoneNumberRegex(phoneNumber)
                || phoneNumber.length() > 11) throw new IllegalArgumentException("Invalid Phone Number");
        return phoneNumber.trim();
    }

    public static String validateEmailAddress (String emailAddress){
        if(isNull(emailAddress) || isStringEmpty(emailAddress) ||!matchesEmailAddressRegex(emailAddress)) throw new IllegalArgumentException("Invalid Email Address");
        return emailAddress;
    }

    public static boolean isContactNull (Contact contact){
        return contact == null;
    }
}
