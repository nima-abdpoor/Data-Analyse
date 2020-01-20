package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class phase3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase3);
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        //accounts.nationalcode , transactions.[to] , people.work
        int sizeto=0;
        String accountnumber;
        String nationalcode;
        String firstname;
        String lastname;
        String amount;
        String datebought;
        String relativenationalcode;
        String work;
        String date;
        String things;
        String nationalcodeaccount;
        String relation;
        int i=0;
        String [] arrto=new String[10000];
        String query="drop table if exists phase2";
        sqLiteDatabase.execSQL(query);
        String query1="Create table phase2(" +
                "'accountnumber' INT ," +
                "'nationalcodephase2' INT " +
                ")";
        sqLiteDatabase.execSQL(query1);
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * " +
                "FROM  accounts " +
                " join people " +
                "on people.nationalcode = accounts.nationalcodeaccount "+
                " join transactions"+
                " on accounts.accountnumber = transactions.[from] "+
                " join ownerships"+
                " on ownerships.[from] = people.nationalcode "+
                //"join phase1 "+
                //"on  = phase1.nationalcode"+
                " where  people.work ='قاچاقچی'"+
                "",null);
        while (cursor.moveToNext()) {
             nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
             firstname=cursor.getString(cursor.getColumnIndex("firstname"));
             lastname=cursor.getString(cursor.getColumnIndex("lastname"));
             relativenationalcode=cursor.getString(cursor.getColumnIndex("to"));
            sqLiteDatabase.execSQL("INSERT INTO 'phase2'('accountnumber')"+
                    " VALUES ('"+relativenationalcode+"')");
            amount=cursor.getString(cursor.getColumnIndex("amount"));
            things=cursor.getString(cursor.getColumnIndex("things"));
            date=cursor.getString(cursor.getColumnIndex("date"));
             work=cursor.getString(cursor.getColumnIndex("work"));
             nationalcodeaccount=cursor.getString(cursor.getColumnIndex("nationalcodeaccount"));
           Log.i("javab",firstname+" "+lastname+" is a person with "+nationalcode+" nathinalcode who transferd "+amount+"to person with "+relativenationalcode+" accoutn number and this nationalcode "+nationalcodeaccount+" who has bought "+things+" "+date+work);
            //String date=cursor.getString(cursor.getColumnIndex("things"));
            //String nationalcode=cursor.getString(cursor.getColumnIndex("date"));
            //Log.i("salam","nationalcode : "+firstname+" | "+"relaticve person : "+ relativenationalcode +" | "+"amount"+amount);
//            String birthday=cursor.getString(cursor.getColumnIndex("birthday"));
//            String to=cursor.getString(cursor.getColumnIndex("to"));
//            String city=cursor.getString(cursor.getColumnIndex("city"));
//            String work=cursor.getString(cursor.getColumnIndex("work"));
//            String things=cursor.getString(cursor.getColumnIndex("things"));
//            String boughtdate=cursor.getString(cursor.getColumnIndex("ownerships.boughtdate"));
 //           Log.i("salam","name : "+firstname+" | "+"lastname : "+ lastname +" | "+"+nationalcode : "+nationalcode+"|"+"relation : "+ relation+"date : "+ date+"birthday : "+ birthday+"to : "+ to+"city : "+ city+"work : "+ work+"thigns : "+ things+"bought : "+ boughtdate);
        }
        cursor.close();
        Cursor cursor1=sqLiteDatabase.rawQuery("SELECT accounts.nationalcodeaccount" +
                " FROM  phase2 " +
                " join accounts"+
                " on phase2.accountnumber = accounts.accountnumber"+
                " join phase1 "+
                " on phase1.nationalcode = accounts.nationalcodeaccount"+
                "",null);
        while (cursor1.moveToNext()) {
            sqLiteDatabase.execSQL("INSERT INTO 'phase2'('nationalcodephase2')"+
                    " VALUES ('"+cursor1.getString(cursor1.getColumnIndex("nationalcodeaccount"))+"')");
//            Log.i("pesar",arrto[i]);
        }
        cursor1.close();
        Cursor cursor2=sqLiteDatabase.rawQuery("SELECT * " +
                " FROM  people " +
                " join phase2 " +
                " on people.nationalcode = phase2.nationalcodephase2 "+
                "join phase1"+
                " on phase1.nationalcode =  phase2.nationalcodephase2"+
                "",null);
        while (cursor2.moveToNext()) {
            nationalcode=cursor2.getString(cursor2.getColumnIndex("nationalcode"));
            firstname=cursor2.getString(cursor2.getColumnIndex("firstname"));
            lastname=cursor2.getString(cursor2.getColumnIndex("lastname"));
            relation=cursor2.getString(cursor2.getColumnIndex("relation"));
            things=cursor2.getString(cursor2.getColumnIndex("things"));
            datebought=cursor2.getString(cursor2.getColumnIndex("datebought"));
            Log.i("phase3",firstname+" "+lastname+" is a person with "+nationalcode +" has "+relation+" relation "+things+datebought);
           }
    }
}
