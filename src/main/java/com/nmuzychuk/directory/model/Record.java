package com.nmuzychuk.directory.model;

public class Record {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "{id: " + getId() +
                ", firstName: " + getFirstName() +
                ", lastName: " + getLastName() +
                ", phoneNumber: " + getPhoneNumber() + "}";
    }
}
