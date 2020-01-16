package com.project.myapplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.RequiresPermission;

public class FeedreaderDBHelper  extends SQLiteOpenHelper {
    MainActivity mainActivity=new MainActivity();
    public static final int database_version=2;
    public static final String database_name="Feedreader.db";
    public FeedreaderDBHelper( Context context) {
        super(context, database_name, null, database_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query="Create table people(" +
                "'ID' integer primary key autoincrement not null ," +
                "'firstname' Text ," +
                "'lastname' Text ," +
                "'nationalcode' text ," +
                "'birthday' text ," +
                "'city' text  ," +
                "'work' text  ," +
                "'address' text  " +
                ")";
        sqLiteDatabase.execSQL(Query);
        String Query2="CREATE TABLE phones("+
                "'ID' integer primary key autoincrement not null ," +
                "'nationalcode' Text ," +
                "'number' Text ," +
                "'operator' Text " +
        ")";
        sqLiteDatabase.execSQL(Query2);
        String Query3="CREATE TABLE cars("+
                "'ID' integer primary key autoincrement not null ," +
                "'car' Text,"+
                "'nationalcode' TEXT,"+
                "'pallet' TEXT,"+
                "'color' TEXT"+
                ")";
        sqLiteDatabase.execSQL(Query3);
        String Query4="CREATE TABLE homes("+
                "'ID' integer primary key autoincrement not null ," +
                "'nationalcode' Text,"+
                "'price' TEXT,"+
                "'postalcode' TEXT,"+
                "'size' TEXT,"+
                "'address' TEXT"+
                ")";
        sqLiteDatabase.execSQL(Query4);
        String Query5="CREATE TABLE accounts("+
                "'ID' integer primary key autoincrement not null ," +
                "'nationalcode' Text,"+
                "'bankname' TEXT,"+
                "'sheba' TEXT,"+
                "'accountnumber' TEXT"+
                ")";
        sqLiteDatabase.execSQL(Query5);
        String Query6="CREATE TABLE calls("+
                "'ID' integer primary key autoincrement not null ," +
                "'from' Text,"+
                "'to' TEXT,"+
                "'callID' TEXT,"+
                "'date' TEXT,"+
                "'duration' TEXT"+
                ")";
        sqLiteDatabase.execSQL(Query6);
        String Query7="CREATE TABLE transactions("+
                "'ID' integer primary key autoincrement not null ," +
                "'from' Text,"+
                "'to' TEXT,"+
                "'transactionID' TEXT,"+
                "'date' TEXT,"+
                "'amount' TEXT"+
                ")";
        sqLiteDatabase.execSQL(Query7);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//        String firstname;
//        String lastname;
//        String nationalcodepeople;
//        String birthday;
//        String city;
//        String work;
//        String address;
//        for(int i = 0; i< MainActivity.sizepeople; i++) {
//            firstname=read_from_file_second.getFirstname();
//            lastname=read_from_file_second.getLastname();
//            nationalcodepeople=read_from_file_second.getNationalecode();
//            birthday=read_from_file_second.getBirthday();
//            city=read_from_file_second.getCity();
//            work=read_from_file_second.getWork();
//            address=read_from_file_second.getAddress();
//            String query1 = "insert INTO 'people' ( 'firstname' , 'lastname' , " +
//                    "'nationalcode' , 'birthday' , 'city' , 'work' , 'address') " +
//                    "values ('"+firstname+"','"+lastname+"' " +
//                    ", '"+nationalcodepeople+"','"+birthday+"','"+city+"', '"+work+"' ,'"+address+"')";
//            Log.wtf("test",firstname+" | "+lastname+" | "+nationalcodepeople+ " | "+birthday+" | "+city+" | "+work+" | "+address+" |");
//            sqLiteDatabase.execSQL(query1);
//            }
//        String nationalcodephone;
//        String number;
//        String operator;
//        for(int j=0;j<MainActivity.sizephone;j++){
//            nationalcodephone=Readfromphones.getNationalcodephone();
//            number=Readfromphones.getNumber();
//            operator=Readfromphones.getOperator();
//            String query2="INSERT INTO 'phones'('nationalcode','number','operator')"+
//                    " VALUES ('"+nationalcodephone+"','"+number+"','"+operator+"')";
//            sqLiteDatabase.execSQL(query2);
//            Log.wtf("test2",nationalcodephone+" | "+number+" | "+operator+ " | ");
//        }
//        String color;
//        String car;
//        String nationalcode;
//        String pallet;
//        for (int k=0;k<MainActivity.sizecars;k++){
//            car=Readfromcars.getCar();
//            nationalcode=Readfromcars.getNationalcode();
//            pallet=Readfromcars.getPallet();
//            color=Readfromcars.getColor();
//            String query3="INSERT INTO 'cars'('car','nationalcode','pallet','color')"+
//                    " VALUES ('"+car+"','"+nationalcode+"','"+pallet+"','"+color+"')";
//            sqLiteDatabase.execSQL(query3);
//            Log.wtf("test2",car+" | "+nationalcode+" | "+pallet+" |"+color);
//        }
//        String nationalcodehome;
//        String price;
//        String postalcode;
//        String size;
//        String addresshome;
//        for (int k=0;k<MainActivity.sizehome;k++){
//            nationalcodehome=Readfromhomes.getNationalcode();
//            price=Readfromhomes.getPrice();
//            postalcode= Readfromhomes.getPostalcode();
//            size= Readfromhomes.getSize();
//            addresshome= Readfromhomes.getAddress();
//            String query3="INSERT INTO 'homes'('nationalcode','price','postalcode','size','address')"+
//                    " VALUES ('"+nationalcodehome+"','"+price+"','"+postalcode+"','"+size+"','"+addresshome+"')";
//            sqLiteDatabase.execSQL(query3);
//            Log.wtf("test2",nationalcodehome+" | "+price+" | "+postalcode+" | "+size+" | "+addresshome);
//        }
//        String nationalcodeaccounts;
//        String bankname;
//        String sheba;
//        String accountnumber;
//        for (int k=0;k<MainActivity.sizeaccounts;k++){
//            nationalcodeaccounts=Readfromaccounts.getNationalcodeaccount();
//            bankname=Readfromaccounts.getBankname();
//            sheba= Readfromaccounts.getSheba();
//            accountnumber= Readfromaccounts.getAccountnumber();
//            String query3="INSERT INTO 'accounts'('nationalcode','bankname','sheba','accountnumber')"+
//                    " VALUES ('"+nationalcodeaccounts+"','"+bankname+"','"+sheba+"','"+accountnumber+"')";
//            sqLiteDatabase.execSQL(query3);
//            Log.wtf("test2",nationalcodeaccounts+" | "+bankname+" | "+sheba+" | "+accountnumber+" | ");
//        }
//        String from;
//        String to;
//        String callID;
//        String date;
//        String duration;
//        for (int k=0;k<MainActivity.sizecalls;k++){
//            from= Readfromcalls.getFrom();
//            to=Readfromcalls.getTo();
//            callID=Readfromcalls.getCallID();
//            date= Readfromcalls.getDate();
//            duration= Readfromcalls.getDuration();
//            String query4="INSERT INTO 'calls'('from','to','callID','date','duration')"+
//                    " VALUES ('"+from+"','"+to+"','"+callID+"','"+date+"','"+duration+"')";
//            sqLiteDatabase.execSQL(query4);
//            Log.wtf("test3",from+" | "+to+" | "+callID+" | "+date+" | "+duration);
//        }
        String fromtrans;
        String totrans;
        String transactionID;
        String datetrans;
        String amount;
        for (int k=0;k<MainActivity.sizetransactions;k++){
            fromtrans= Readfromtransactions.getFrom();
            totrans=Readfromtransactions.getTo();
            transactionID=Readfromtransactions.getTransaction_ID();
            datetrans= Readfromtransactions.getDate();
            amount= Readfromtransactions.getAmount();
            String query4="INSERT INTO 'transactions'('from','to','transactionID','date','amount')"+
                    " VALUES ('"+fromtrans+"','"+totrans+"','"+transactionID+"','"+datetrans+"','"+amount+"')";
            sqLiteDatabase.execSQL(query4);
            Log.wtf("test3",fromtrans+" | "+totrans+" | "+transactionID+" | "+datetrans+" | "+amount);
        }
        }



    }
