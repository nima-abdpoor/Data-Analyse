package com.project.myapplication;
public class Readfromcalls {
    private String from;
    private String to;
    private String callID;
    private String date;
    private String duration;
    public static int rowsizecalls;
    private boolean setarrayindexes=true;
    public static String [] arrfrom;
    public static String [] arrto;
    public static String [] arrcallID;
    public static String [] arrdate;
    public static String [] arrduration;
    public static int i=0;
    public static int i2=-1;
    private void setarrayindexes() {
        if (setarrayindexes){
            arrfrom=new String[rowsizecalls];
            arrto=new String[rowsizecalls];
            arrcallID=new String[rowsizecalls];
            arrdate=new String[rowsizecalls];
            arrduration=new String[rowsizecalls];
        }
    }
    public static String getFrom() {
        i2++;
        return arrfrom[i2];
    }
    public static String getTo() {
        return arrto[i2];
    }
    public static String getCallID() {
        return arrcallID[i2];
    }
    public static String getDate() {
        return arrdate[i2];
    }
    public static String getDuration() {
        return arrduration[i2];
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
    public void setCallID(String callID) {
        this.callID = callID;
        arrcallID[i]=callID;
    }
    public void setDate(String date) {
        this.date = date;
        arrdate[i]=date;
    }
    public void setDuration(String duration) {
        this.duration = duration;
        arrduration[i]=duration;
        i++;
    }

}
