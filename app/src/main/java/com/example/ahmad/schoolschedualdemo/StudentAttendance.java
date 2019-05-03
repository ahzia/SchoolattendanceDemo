package com.example.ahmad.schoolschedualdemo;

public class StudentAttendance {
private String Name;
//private String Date;
private String phone;
private String ID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public StudentAttendance(){
}
public class attendance{
    private boolean attend;

    public boolean isAttend() {
        return attend;
    }
    public void setAttend(boolean attend) {
        this.attend = attend;
    }
}
}
