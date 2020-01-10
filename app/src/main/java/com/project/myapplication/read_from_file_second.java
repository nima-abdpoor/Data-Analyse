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
    private String nationalcodephons;
    private String number;
    private String operator;
    public static int rowsizepeople;
    public static int rowsizephone;
    private boolean setarrayindexes=true;
    private boolean setarrayindexesphones=true;
    public static String [] arrfirstname;
    public static String [] arrlastname;
    public static String [] arrnationalcode;
    public static String [] arrbirthday;
    public static String [] arrcity;
    public static String [] arraddress;
    public static String [] getArrnationalcodephones;
    public static String [] arrnumber;
    public static String [] arroperator;
    public static int i=0;
    public static int i2=-1;
    public static int iphone=0;
    public static int i2phones=-1;
    private void setarrayindexes() {
        if (setarrayindexes){
            arrfirstname=new String[rowsizepeople];
            arrlastname=new String[rowsizepeople];
            arrnationalcode=new String[rowsizepeople];
            arrbirthday=new String[rowsizepeople];
            arrbirthday=new String[rowsizepeople];
            arrcity=new String[rowsizepeople];
            arraddress=new String[rowsizepeople];
        }
    }
    private void setarrayindexesphones(){
        if (setarrayindexesphones){
            getArrnationalcodephones=new String[rowsizephone];
            arroperator=new String[rowsizephone];
            arroperator=new String[rowsizephone];
        }
    }
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

    public static String getLastname() {
        return arrlastname[i2];
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        arrlastname[i]=lastname;
    }

    public static String getNationalecode() {
        return arrnationalcode[i2];
    }

    public void setNationalecode(String nationalecode) {
        this.nationalecode = nationalecode;
        arrnationalcode[i]=nationalecode;
    }

    public static String getBirthday()
    {
        return arrbirthday[i2];
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        arrbirthday[i]=birthday;
    }

    public static String getCity() {

        return arrcity[i2];
    }

    public void setCity(String city) {
        this.city = city;
        arrcity[i]=city;
    }

    public static String getAddress() {
        return arraddress[i2];
    }
    public void setAddress(String address) {
        this.address = address;
        arraddress[i]=address;
        i++;
    }
    public void setNationalcodephons(String nationalcodephons) {
        setarrayindexesphones();
        this.nationalcodephons=nationalcodephons;
        getArrnationalcodephones[iphone]=nationalcodephons;
        setarrayindexesphones=false;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public static String getNationalcodephons() {
        return getArrnationalcodephones[i2phones];
    }

    public static String getNumber() {
        return arrnumber[i2phones];
    }

    public static String getOperator() {
        return arroperator[i2phones];
    }
}