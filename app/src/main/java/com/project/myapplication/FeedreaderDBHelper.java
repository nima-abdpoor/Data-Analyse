package com.project.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


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
    }

    @Override
    public  void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String firstname;
        String lastname;
        String nationalcodepeople;
        String birthday;
        String city;
        String work;
        String address;
        for(int i = 0; i< MainActivity.sizepeople; i++) {
            firstname=read_from_file_second.getFirstname();
            lastname=read_from_file_second.getLastname();
            nationalcodepeople=read_from_file_second.getNationalecode();
            birthday=read_from_file_second.getBirthday();
            city=read_from_file_second.getCity();
            work=read_from_file_second.getWork();
            address=read_from_file_second.getAddress();
            String query1 = "insert INTO 'people' ( 'firstname' , 'lastname' , " +
                    "'nationalcode' , 'birthday' , 'city' , 'work' , 'address') " +
                    "values ('"+firstname+"','"+lastname+"' " +
                    ", '"+nationalcodepeople+"','"+birthday+"','"+city+"', '"+work+"' ,'"+address+"')";
            //Log.wtf("test",firstname+" | "+lastname+" | "+nationalcodepeople+ " | "+birthday+" | "+city+" | "+work+" | "+address+" |");
            sqLiteDatabase.execSQL(query1);
            }
        String nationalcodephone;
        String number;
        String operator;
        for(int j=0;j<MainActivity.sizephone;j++){
            nationalcodephone=Readfromphones.getNationalcodephone();
            number=Readfromphones.getNumber();
            operator=Readfromphones.getOperator();
            String query2="INSERT INTO 'phones'('nationalcode','number','operator')"+
                    " VALUES ('"+nationalcodephone+"','"+number+"','"+operator+"')";
            sqLiteDatabase.execSQL(query2);
            //Log.wtf("test2",nationalcodephone+" | "+number+" | "+operator+ " | ");
        }
        }
    }

