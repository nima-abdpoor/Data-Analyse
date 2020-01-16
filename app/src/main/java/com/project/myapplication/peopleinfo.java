package com.project.myapplication;

public class peopleinfo {
    public String ID;
    public String firstname;
    public String lastname;
    public String nationalcode;
    public String birthday;
    public String work;

    public peopleinfo(String ID, String firstname, String lastname, String nationalcode, String birthday, String work, String address) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalcode = nationalcode;
        this.birthday = birthday;
        this.work = work;
        this.address = address;
    }

    public String address;
}
