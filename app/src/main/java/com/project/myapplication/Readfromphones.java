package com.project.myapplication;
public class Readfromphones {

    private String nationalcodephone;
    private String number;
    private String operator;

    public static int rowsizephone;
    private boolean setarrayindexes=true;
    public static String [] arrnationalcodephone;
    public static String [] arrnumber;
    public static String [] arroperator;
    public static int i=0;
    public static int i2=-1;
    public static String getNationalcodephone() {
        i2++;
        return arrnationalcodephone[i2];
    }
    public void setNationalcodephone(String nationalcodephone) {
        setarrayindexes();
        arrnationalcodephone[i]= nationalcodephone;
        setarrayindexes=false;
    }
    private void setarrayindexes() {
        if (setarrayindexes){
            arrnationalcodephone=new String[rowsizephone];
            arrnumber=new String[rowsizephone];
            arroperator=new String[rowsizephone];
        }
    }
    public void setNumber(String number) {
        this.number = number;
        arrnumber[i]=number;
    }
    public void setOperator(String operator) {
        this.operator = operator;
        arroperator[i]=operator;
        i++;
    }
    public static String getNumber() {
        return arrnumber[i2];
    }
    public static String getOperator() {
        return arroperator[i2];
    }
}
