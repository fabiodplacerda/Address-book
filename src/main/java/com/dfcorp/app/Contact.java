package com.dfcorp.app;

import com.dfcorp.app.utils.Validator;

public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = Validator.validateName(name);
        this.phoneNumber = Validator.validatePhoneNumber(phoneNumber);
        this.emailAddress = Validator.validateEmailAddress(emailAddress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Validator.validateName(name);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Validator.validatePhoneNumber(phoneNumber);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = Validator.validateEmailAddress(emailAddress);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Phone number: " + phoneNumber +
                ", Email address: " + emailAddress;

    }

}
