package com.dfcorp.app;

import com.dfcorp.app.utils.Validator;

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
        this.name = validateName(name);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validatePhoneNumber(phoneNumber);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = validateEmailAddress(emailAddress);
    }

    private String validateName (String name) {
        if(Validator.isNull(name)|| Validator.isStringEmpty(name) || !Validator.matchesNameRegex(name)) throw new IllegalArgumentException("Invalid Name");
        return name;
    }

    private String validatePhoneNumber (String phoneNumber){
        if( Validator.isNull(phoneNumber)|| Validator.isStringEmpty(phoneNumber) || !Validator.matchesPhoneNumberRegex(phoneNumber)
                || phoneNumber.length() > 15) throw new IllegalArgumentException("Invalid Phone Number");
        return phoneNumber.trim();
    }

    private String validateEmailAddress (String emailAddress){
        if(Validator.isNull(emailAddress) || Validator.isStringEmpty(emailAddress) ||!Validator.matchesEmailAddressRegex(emailAddress)) throw new IllegalArgumentException("Invalid Email Address");
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Phone number: " + phoneNumber +
                ", Email address: " + emailAddress;

    }

}
