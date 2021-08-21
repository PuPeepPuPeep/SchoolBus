package com.example.schoolbus;

public class CheckinModel {
    private int checkin_id;
    private int admin_id;
    private int stu_id;
    private String checkin_status;

    public CheckinModel(int checkin_id, int admin_id, int stu_id, String checkin_status) {
        this.checkin_id = checkin_id;
        this.admin_id = admin_id;
        this.stu_id = stu_id;
        this.checkin_status = checkin_status;
    }

    @Override
    public String toString() {
        return "CheckinModel{" +
                "checkin_id=" + checkin_id +
                ", admin_id=" + admin_id +
                ", stu_id=" + stu_id +
                ", checkin_status='" + checkin_status + '\'' +
                '}';
    }

    public int getCheckin_id() {
        return checkin_id;
    }

    public void setCheckin_id(int checkin_id) {
        this.checkin_id = checkin_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getCheckin_status() {
        return checkin_status;
    }

    public void setCheckin_status(String checkin_status) {
        this.checkin_status = checkin_status;
    }
}
