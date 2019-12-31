package com.project.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.project.myapplication.read_from_file_second.rowsize;

public class FeedreaderDBHelper  extends SQLiteOpenHelper {
    public static final int database_version=1;
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
    }

    @Override
    public  void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String f;
        for(int i=0 ; i< rowsize ; i++) {
            f=read_from_file_second.getFirstname();
            String query2 = "insert INTO 'people' ('ID' , 'firstname' , 'lastname' , " +
                    "'nationalcode' , 'birthday' , 'city' , 'address') " +
                    "values ('"+i+"','"+f+"','abdpoor' " +
                    ", 'nima@gmail.com','sdf','sdf','sdf')";
            Log.wtf("test",f);
            sqLiteDatabase.execSQL(query2);
        }
    }
}
