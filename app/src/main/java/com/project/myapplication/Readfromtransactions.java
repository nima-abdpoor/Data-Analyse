package com.project.myapplication;

public class Readfromtransactions {

    private String from;
    private String to;
    private String transaction_ID;
    private String date;
    private String amount;

    public static int rowsizetransactions;
    private boolean setarrayindexes=true;
    public static String [] arrfrom;
    public static String [] arrto;
    public static String [] arrtransaction_ID;
    public static String [] arrdate;
    public static String [] arramount;
    public static int i=0;
    public static int i2=-1;

    private void setarrayindexes() {
        if (setarrayindexes){
            arrfrom=new String[rowsizetransactions];
            arrto=new String[rowsizetransactions];
            arrtransaction_ID=new String[rowsizetransactions];
            arrdate=new String[rowsizetransactions];
            arramount=new String[rowsizetransactions];
        }
    }
    public static String getFrom() {
        i2++;
        return arrfrom[i2];
    }

    public static String getTo() {
        return arrto[i2];
    }

    public static String getTransaction_ID() {
        return arrtransaction_ID[i2];
    }

    public static String getDate() {
        return arrdate[i2];
    }

    public static String getAmount() {
        return arramount[i2];
    }
    public void setFrom(String from) {
        setarrayindexes();
        arrfrom[i]= from;
        setarrayindexes=false;
    }

    public void setTo(String to) {
        this.to = to;
        arrto[i]=to;
    }

    public void setTransaction_ID(String transaction_ID) {
        this.transaction_ID = transaction_ID;
        arrtransaction_ID[i]=transaction_ID;
    }

    public void setDate(String date) {
        this.date = date;
        arrdate[i]=date;
    }

    public void setAmount(String amount) {
        this.amount = amount;
        arramount[i]=amount;
        i++;
    }

}
