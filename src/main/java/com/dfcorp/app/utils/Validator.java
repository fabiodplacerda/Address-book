package com.dfcorp.app.utils;

import com.dfcorp.app.Contact;

import java.util.regex.Pattern;

public abstract class Validator {
    public static boolean isStringEmpty (String string){
        return string.trim().isEmpty();
    }

    public static boolean isNull ( String string){
        return string == null;
    }

    public static boolean matchesNameRegex (String name){
        return Pattern.matches("[a-zA-Z\\s]+", name);
    }

    public static boolean matchesPhoneNumberRegex (String phoneNumber){
        return Pattern.matches("0[0-9\\s]+", phoneNumber);
    }

    public static boolean matchesEmailAddressRegex (String emailAddress){
        return  Pattern.matches(".+@.+", emailAddress);
    }

    public static boolean isContactNull (Contact contact){
        return contact == null;
    }
}
