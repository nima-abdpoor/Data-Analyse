package com.project.myapplication;

public class Readfromownership {
    private String from;
    private String to;
    private String ownershipID;
    private String date;
    private String amount;
    private int diffdate;

    public static int rowsizeownership;
    private boolean setarrayindexes=true;
    public static String [] arrfrom;
    public static String [] arrto;
    public static String [] arrownershipID;
    public static String [] arrdate;
    public static String [] arramount;
    public static int [] arrdiffdate;
    public static int i=0;
    public static int i2=-1;

    private void setarrayindexes() {
        if (setarrayindexes) {
            arrfrom = new String[rowsizeownership];
            arrto = new String[rowsizeownership];
            arrownershipID = new String[rowsizeownership];
            arrdate = new String[rowsizeownership];
            arramount = new String[rowsizeownership];
            arrdiffdate = new int[rowsizeownership];
        }
    }
    public static String getFrom() {
        i2++;
        return arrfrom[i2];
    }

    public static String getTo() {
        return arrto[i2];
    }

    public static String getOwnershipID() {
        return arrownershipID[i2];
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

    public void setOwnershipID(String ownershipID) {
        this.ownershipID = ownershipID;
        arrownershipID[i]=ownershipID;
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
    public void setdiffdate(int diffdate){
        this.diffdate=diffdate;
        arrdiffdate[i]=diffdate;
    }
    public static int getdiffdate(){
        return arrdiffdate[i2];
    }
}
