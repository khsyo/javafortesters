package com.javafortesters.domainentities;

public class InvalidPassword extends Exception {
    public InvalidPassword(String message) {
        super(message);
    }
}
