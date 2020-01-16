package com.project.myapplication;
public class Readfromaccounts {
    private String nationalcodeaccount;
    private String bankname;
    private String sheba;
    private String accountnumber;
    public static int rowsizeaccount;
    private boolean setarrayindexes=true;
    public static String [] arrnationalcodeaccount;
    public static String [] arrbankname;
    public static String [] arrsheba;
    public static String [] arraccountnumber;
    public static int i=0;
    public static int i2=-1;
    private void setarrayindexes() {
        if (setarrayindexes){
            arrnationalcodeaccount=new String[rowsizeaccount];
            arrbankname=new String[rowsizeaccount];
            arrsheba=new String[rowsizeaccount];
            arraccountnumber=new String[rowsizeaccount];
        }
    }
    public static String getNationalcodeaccount() {
        i2++;
        return arrnationalcodeaccount[i2];
    }
    public static String getBankname() {
        return arrbankname[i2];
    }
    public static String getSheba() {
        return arrsheba[i2];
    }
    public static String getAccountnumber() {
        return arraccountnumber[i2];
    }
    public void setNationalcodeaccount(String nationalcodeaccount) {
        setarrayindexes();
        arrnationalcodeaccount[i]= nationalcodeaccount;
        setarrayindexes=false;
    }
    public void setBankname(String bankname) {
        this.bankname = bankname;
        arrbankname[i]=bankname;
    }
    public void setSheba(String sheba) {
        this.sheba = sheba;
        arrsheba[i]=sheba;
    }
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
        arraccountnumber[i]=accountnumber;
        i++;
    }
}
