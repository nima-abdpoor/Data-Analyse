package com.project.myapplication;
public class Readfromcars {
    private String color;
    private String car;
    private String nationalcode;
    private String pallet;
    public static int rowsizecars;
    private boolean setarrayindexes=true;
    public static String [] arrcar;
    public static String [] arrnationalcode;
    public static String [] arrpallet;
    public static String [] arrcolor;
    public static int i=0;
    public static int i2=-1;
    private void setarrayindexes() {
        if (setarrayindexes){
            arrcolor=new String[rowsizecars];
            arrcar=new String[rowsizecars];
            arrnationalcode=new String[rowsizecars];
            arrpallet=new String[rowsizecars];
        }
    }
    public static String getColor() {
    return arrcolor[i2];
    }
    public static String getCar() {
        i2++;
        return arrcar[i2];
    }
    public static String getNationalcode() {
        return arrnationalcode[i2];
    }
    public static String getPallet() {
        return arrpallet[i2];
    }
    public void setColor(String color) {
        arrcolor[i]= color;
        i++;
    }
    public void setCar(String car) {
        setarrayindexes();
        this.car = car;
        arrcar[i]=car;
        setarrayindexes=false;
    }
    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
        arrnationalcode[i]=nationalcode;
    }
    public void setPallet(String pallet) {
        this.pallet = pallet;
        arrpallet[i]=pallet;
    }
}
