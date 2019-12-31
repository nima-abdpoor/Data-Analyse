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
    public static int rowsize;
    private boolean setarrayindexes=true;
    public static String [] arrfirstname;
    public String [] arrlastname;
    public String [] arrnationalcode;
    public String [] arrbirthday;
    public String [] arrcity;
    public String [] arraddress;
    public static int i=0;
    public static int i2=-1;

    public static String getFirstname() {
        i2++;
        return arrfirstname[i2];
    }

    public void setFirstname(String firstname) {
        setarrayindexes();
        this.firstname = firstname;
        arrfirstname[i]=firstname;
        //Log.i("firs",arrfirstname[i]);
        setarrayindexes =false;
    }

    private void setarrayindexes() {
        if (setarrayindexes){
            arrfirstname=new String[rowsize];
            arrlastname=new String[rowsize];
            arrnationalcode=new String[rowsize];
            arrbirthday=new String[rowsize];
            arrbirthday=new String[rowsize];
            arrcity=new String[rowsize];
            arraddress=new String[rowsize];
        }
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
