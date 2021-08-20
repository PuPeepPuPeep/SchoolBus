package com.example.schoolbus;

public class StudentRecModel {
    private String firstName;
    private String lastName;
    private String imgUrl;
    private String checkinStatus;

    public StudentRecModel(String firstName, String lastName, String imgUrl, String checkinStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgUrl = imgUrl;
        this.checkinStatus = checkinStatus;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCheckinStatus() {
        return checkinStatus;
    }

    public void setCheckinStatus(String checkinStatus) {
        this.checkinStatus = checkinStatus;
    }

    @Override
    public String toString() {
        return "StudentRecModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", checkinStatus='" + checkinStatus + '\'' +
                '}';
    }
}

