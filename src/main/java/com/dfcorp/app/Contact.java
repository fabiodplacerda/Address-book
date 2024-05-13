package com.dfcorp.app;

import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = validateName(name);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.emailAddress = validateEmailAddress(emailAddress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private String validateName (String name) {

        if(name == null || validateString(name) || !Pattern.matches("[a-zA-Z\\s]+", name)) throw new IllegalArgumentException("Invalid Name");
        return name;
    }

    private String validatePhoneNumber (String phoneNumber){
        if(phoneNumber == null || validateString(phoneNumber) || !Pattern.matches("[\\+0-9\\s]+", phoneNumber)
                || phoneNumber.length() > 15) throw new IllegalArgumentException("Invalid Phone Number");
        return phoneNumber.trim();
    }

    private String validateEmailAddress (String emailAddress){
        if(emailAddress == null || validateString(emailAddress) || !Pattern.matches(".+@.+", emailAddress)) throw new IllegalArgumentException("Invalid Email Address");
        return emailAddress;
    }


    private boolean validateString (String string){
        return string.trim().isEmpty();
    }
}
