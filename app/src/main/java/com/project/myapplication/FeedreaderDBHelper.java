package com.project.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.project.myapplication.read_from_file_second.rowsizepeople;
import static com.project.myapplication.read_from_file_second.rowsizephone;

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
        mainActivity.readfilepeople();
        String firstname;
        String lastname;
        String nationalcodepeople;
        String birthday;
        String city;
        String address;
        for(int i = 0; i< rowsizepeople; i++) {
            firstname=read_from_file_second.getFirstname();
            lastname=read_from_file_second.getLastname();
            nationalcodepeople=read_from_file_second.getNationalecode();
            birthday=read_from_file_second.getBirthday();
            city=read_from_file_second.getCity();
            address=read_from_file_second.getAddress();
            String query2 = "insert INTO 'people' ( 'firstname' , 'lastname' , " +
                    "'nationalcode' , 'birthday' , 'city' , 'address') " +
                    "values ('"+firstname+"','"+lastname+"' " +
                    ", '"+nationalcodepeople+"','"+birthday+"','"+city+"','"+address+"')";
            Log.wtf("test",firstname+" | "+lastname+" | "+nationalcodepeople+ " | "+birthday+" | "+city+" | "+address);
            sqLiteDatabase.execSQL(query2);
            mainActivity.readfilephones();
            String nationalcodephone;
            String number;
            String operator;
            for (int j=0;j<rowsizephone;++j){
                nationalcodephone=read_from_file_second.getNationalcodephons();
                number=read_from_file_second.getNumber();
                operator=read_from_file_second.getOperator();
                String query3="INSERT INTO 'phones'( 'nationalcode' , 'number' ,'operator')"+
                        "values ('"+nationalcodephone+"','"+number+"' ,'"+operator+"')";
                Log.wtf("test",nationalcodephone+" | "+number+" | "+operator);
                sqLiteDatabase.execSQL(query3);
            }
        }
    }
}
