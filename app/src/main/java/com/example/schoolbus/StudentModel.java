package com.example.schoolbus;

public class StudentModel {

    private int stu_id;
    private String stu_firstname;
    private String stu_lastname;
    private String stu_image;
    private String stu_address;
    private String stu_school;
    private int user_id;
    private String stu_created;

    public StudentModel(int stu_id, String stu_firstname, String stu_lastname, String stu_image, String stu_address, String stu_school, int user_id, String stu_created) {
        this.stu_id = stu_id;
        this.stu_firstname = stu_firstname;
        this.stu_lastname = stu_lastname;
        this.stu_image = stu_image;
        this.stu_address = stu_address;
        this.stu_school = stu_school;
        this.user_id = user_id;
        this.stu_created = stu_created;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "stu_id=" + stu_id +
                ", stu_firstname='" + stu_firstname + '\'' +
                ", stu_lastname='" + stu_lastname + '\'' +
                ", stu_image='" + stu_image + '\'' +
                ", stu_address='" + stu_address + '\'' +
                ", stu_school='" + stu_school + '\'' +
                ", user_id=" + user_id +
                ", stu_created='" + stu_created + '\'' +
                '}';
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_firstname() {
        return stu_firstname;
    }

    public void setStu_firstname(String stu_firstname) {
        this.stu_firstname = stu_firstname;
    }

    public String getStu_lastname() {
        return stu_lastname;
    }

    public void setStu_lastname(String stu_lastname) {
        this.stu_lastname = stu_lastname;
    }

    public String getStu_image() {
        return stu_image;
    }

    public void setStu_image(String stu_image) {
        this.stu_image = stu_image;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStu_created() {
        return stu_created;
    }

    public void setStu_created(String stu_created) {
        this.stu_created = stu_created;
    }
}
