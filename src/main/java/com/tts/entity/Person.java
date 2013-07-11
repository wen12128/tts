package com.tts.entity;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Eric
 */
public class Person {
    protected String firstName;
    protected String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}