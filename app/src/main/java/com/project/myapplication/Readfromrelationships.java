package com.project.myapplication;

public class Readfromrelationships {
    private String from;
    private String to;
    private String relation;
    private String date;

    public static int rowsizerealationships;
    private boolean setarrayindexes=true;
    public static String [] arrfrom;
    public static String [] arrto;
    public static String [] arrrelation;
    public static String [] arrdate;
    public static int i=0;
    public static int i2=-1;

    private void setarrayindexes() {
        if (setarrayindexes){
            arrfrom=new String[rowsizerealationships];
            arrto=new String[rowsizerealationships];
            arrrelation=new String[rowsizerealationships];
            arrdate=new String[rowsizerealationships];
        }
    }
    public static String getFrom() {
        i2++;
        return arrfrom[i2];
    }

    public static String getTo() {
        return arrto[i2];
    }

    public static String getRelation() {
        return arrrelation[i2];
    }

    public static String getDate() {
        return arrdate[i2];
    }
    public void setFrom(String from) {
        if (setarrayindexes){
            setarrayindexes();
            setarrayindexes=false;
        }
        arrfrom[i]= from;
    }

    public void setTo(String to) {
        this.to = to;
        arrto[i]=to;
    }

    public void setRelation(String relation) {
        this.relation = relation;
        arrrelation[i]=relation;
    }

    public void setDate(String date) {
        this.date = date;
        arrdate[i]=date;
        i++;
    }

}

