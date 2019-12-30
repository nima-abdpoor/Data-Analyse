package com.project.myapplication;

import android.util.Log;

public class read_from_file_second {
    //read from people
    private String firstname;
    private String lastname;
    private String nationalecode;
    private String birthday;
    private String city;
    private String address;
    public String [] arrfirstname=new String[11133];
    public String [] arrlastname=new String[11133];
    public String [] arrnationalcode=new String[11133];
    public String [] arrbirthday=new String[11133];
    public String [] arrcity=new String[11133];
    public String [] arraddress=new String[11133];
    public static int i=0;

    public String getFirstname() {
        return "";
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        if(i>11130){
            Log.i("tag",firstname);
        }
        arrfirstname[i]=firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        arrlastname[i]=lastname;
    }

    public String getNationalecode() {
        return nationalecode;
    }

    public void setNationalecode(String nationalecode) {
        this.nationalecode = nationalecode;
        arrnationalcode[i]=nationalecode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        arrbirthday[i]=birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        arrcity[i]=city;
    }

    public String getAddress() {
        for(int j=0; j<10; j++)
            Log.wtf("address",arraddress[j]);
        return "";
    }

    public void setAddress(String address) {
        this.address = address;
        arraddress[i]=address;
        i++;
    }

}
