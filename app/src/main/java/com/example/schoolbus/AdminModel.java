package com.example.schoolbus;

public class AdminModel {
    private int admin_id;
    private String admin_firstname;
    private String admin_lastname;
    private String admin_username;
    private String admin_password;
    private String admin_tel;
    private String admin_image;
    private String admin_car;
    private String admin_token;

    public AdminModel(int admin_id, String admin_firstname, String admin_lastname, String admin_username, String admin_password, String admin_tel, String admin_image, String admin_car, String admin_token) {
        this.admin_id = admin_id;
        this.admin_firstname = admin_firstname;
        this.admin_lastname = admin_lastname;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
        this.admin_tel = admin_tel;
        this.admin_image = admin_image;
        this.admin_car = admin_car;
        this.admin_token = admin_token;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "admin_id=" + admin_id +
                ", admin_firstname='" + admin_firstname + '\'' +
                ", admin_lastname='" + admin_lastname + '\'' +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_tel='" + admin_tel + '\'' +
                ", admin_image='" + admin_image + '\'' +
                ", admin_car='" + admin_car + '\'' +
                ", admin_token='" + admin_token + '\'' +
                '}';
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_firstname() {
        return admin_firstname;
    }

    public void setAdmin_firstname(String admin_firstname) {
        this.admin_firstname = admin_firstname;
    }

    public String getAdmin_lastname() {
        return admin_lastname;
    }

    public void setAdmin_lastname(String admin_lastname) {
        this.admin_lastname = admin_lastname;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_tel() {
        return admin_tel;
    }

    public void setAdmin_tel(String admin_tel) {
        this.admin_tel = admin_tel;
    }

    public String getAdmin_image() {
        return admin_image;
    }

    public void setAdmin_image(String admin_image) {
        this.admin_image = admin_image;
    }

    public String getAdmin_car() {
        return admin_car;
    }

    public void setAdmin_car(String admin_car) {
        this.admin_car = admin_car;
    }

    public String getAdmin_token() {
        return admin_token;
    }

    public void setAdmin_token(String admin_token) {
        this.admin_token = admin_token;
    }
}
