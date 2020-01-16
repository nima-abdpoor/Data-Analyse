package com.project.myapplication;
public class Readfromhomes {
    private String nationalcode;
    private String price;
    private String postalcode;
    private String size;
    private String address;
    public static int rowsizehome;
    private boolean setarrayindexes=true;
    public static String [] arrnationalcodehome;
    public static String [] arrprice;
    public static String [] arrpostalcode;
    public static String [] arrsize;
    public static String [] arraddress;
    public static int i=0;
    public static int i2=-1;
    public static String getNationalcode() {
        i2++;
        return arrnationalcodehome[i2];
    }
    public void setNationalcode(String nationalcode) {
        setarrayindexes();
        arrnationalcodehome[i]= nationalcode;
        setarrayindexes=false;
    }
    private void setarrayindexes() {
        if (setarrayindexes){
            arrnationalcodehome=new String[rowsizehome];
            arrprice=new String[rowsizehome];
            arrpostalcode=new String[rowsizehome];
            arrsize =new String[rowsizehome];
            arraddress=new String[rowsizehome];
        }
    }
    public static String getPrice() {
        return arrprice[i2];
    }
    public static String getPostalcode() {
        return arrpostalcode[i2];
    }
    public static String getSize() {
        return arrsize[i2];
    }
    public static String getAddress() {
        return arraddress[i2];
    }
    public void setPrice(String price) {
        this.price = price;
        arrprice[i]=price;
    }
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
        arrpostalcode[i]=postalcode;
    }
    public void setSize(String size) {
        this.size = size;
        arrsize[i]=size;
    }
    public void setAddress(String address) {
        this.address = address;
        arraddress[i]=address;
        i++;
    }
}
