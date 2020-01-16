package com.project.myapplication;
import android.util.Log;
public class read_from_file_second {
    //read from people
    private String firstname;
    private String lastname;
    private String nationalecode;
    private String birthday;
    private String city;
    private String work;
    private String address;
    public static int rowsizepeople;
    private boolean setarrayindexes=true;
    public static String [] arrfirstname;
    public static String [] arrlastname;
    public static String [] arrnationalcode;
    public static String [] arrbirthday;
    public static String [] arrcity;
    public static String [] arrwork;
    public static String [] arraddress;
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
        setarrayindexes =false;
    }
    private void setarrayindexes() {
        if (setarrayindexes){
            arrfirstname=new String[rowsizepeople];
            arrlastname=new String[rowsizepeople];
            arrnationalcode=new String[rowsizepeople];
            arrbirthday=new String[rowsizepeople];
            arrbirthday=new String[rowsizepeople];
            arrcity=new String[rowsizepeople];
            arrwork=new String[rowsizepeople];
            arraddress=new String[rowsizepeople];
        }
    }
    public static String getLastname()
    {
        return arrlastname[i2];
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
        arrlastname[i]=lastname;
    }
    public static String getNationalecode()
    {
        return arrnationalcode[i2];
    }
    public void setNationalecode(String nationalecode) {
        this.nationalecode = nationalecode;
        arrnationalcode[i]=nationalecode;
    }
    public static String getBirthday() {
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
    public static String getWork(){
        return arrwork[i2];
    }
    public void setWork(String work){
        this.work=work;
        arrwork[i]=work;
    }
    public static String getAddress() {
        return arraddress[i2];
    }
    public void setAddress(String address) {
        this.address = address;
        arraddress[i]=address;
        i++;
    }
}
