package com.example.schoolbus;

public class UserModel {

    private int user_id;
    private String user_firstname;
    private String user_lastname;
    private String user_tel;
    private String user_username;
    private String user_password;
    private String user_created;

    public UserModel(int user_id, String user_firstname, String user_lastname, String user_tel, String user_username, String user_password, String user_created){
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_tel = user_tel;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_created = user_created;
    }

    public UserModel(){
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_username='" + user_username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_created='" + user_created + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_created() {
        return user_created;
    }

    public void setUser_created(String user_created) {
        this.user_created = user_created;
    }
}
