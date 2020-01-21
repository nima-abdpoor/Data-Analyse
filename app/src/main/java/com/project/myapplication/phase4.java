package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class phase4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase4);
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        String query2="drop table if exists suspectsphones";
        sqLiteDatabase.execSQL(query2);
        String query3="Create table suspectsphones(" +
                "'nationalcodesuspect' INT ," +
                "'numbersuspect' INT " +
                ")";
        sqLiteDatabase.execSQL(query3);
        Cursor cursor2=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                " FROM  phase2 " +
                " join phones " +
                " on phones.nationalcode = phase2.nationalcodephase2 "+
                //"WHERE people.work like 'قاچاقچی'"+
                "",null);
        while (cursor2.moveToNext()) {
           String nationalcode2=cursor2.getString(cursor2.getColumnIndex("nationalcode"));
           String phonenumber=cursor2.getString(cursor2.getColumnIndex("number"));
            sqLiteDatabase.execSQL("INSERT INTO 'suspectsphones'('nationalcodesuspect','numbersuspect')"+
                    " VALUES ('"+nationalcode2+"','"+phonenumber+"')");
            Log.i("phase4",nationalcode2+" | "+phonenumber);
        }
        cursor2.close();
        String query="drop table if exists ghachghchiphones";
        sqLiteDatabase.execSQL(query);
        String query1="Create table ghachghchiphones(" +
                "'number' INT " +
                ")";
        sqLiteDatabase.execSQL(query1);
        Cursor cursor3=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                " FROM people " +
                " join phones " +
                " on phones.nationalcode = people.nationalcode "+
                "WHERE people.work like 'قاچاقچی'"+
                "",null);
        while (cursor3.moveToNext()) {
            //String nationalcode3=cursor3.getString(cursor3.getColumnIndex("nationalcode"));
            String phonenumber=cursor3.getString(cursor3.getColumnIndex("number"));
            sqLiteDatabase.execSQL("INSERT INTO 'ghachghchiphones'('number')"+
                    " VALUES ('"+phonenumber+"')");
            Log.i("phase45"," | "+phonenumber);
        }
        cursor3.close();
        Cursor cursor4=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                " FROM calls " +
                " join ghachghchiphones " +
                " on ghachghchiphones.number = calls.[from] "+
                " join suspectsphones"+
                " on suspectsphones.numbersuspect = calls.[to] "+
                "",null);
        while (cursor4.moveToNext()) {
            String nationalcode3=cursor4.getString(cursor4.getColumnIndex("nationalcodesuspect"));
            String phonenumber=cursor4.getString(cursor4.getColumnIndex("number"));
            String duration=cursor4.getString(cursor4.getColumnIndex("duration"));
            Log.i("end",nationalcode3+" | "+duration+" | "+phonenumber);
        }
        cursor4.close();
    }
}
