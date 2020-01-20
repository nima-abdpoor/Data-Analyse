package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class phase1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase1);
        FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
        SQLiteDatabase db=Fhelper.getReadableDatabase();
        //Log.i("salam","salam");
        Cursor cursor=db.rawQuery("SELECT * " +
                "FROM  relationships " +
                "join people " +
                "on people.nationalcode = relationships.nationalcode "+
                " join ownerships"+
                " on people.nationalcode = ownerships.[from] "+
                " where  ownerships.diffdate < 3 and work ='گمرک' "+
                "",null);
        while (cursor.moveToNext()) {
            String firstname=cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname=cursor.getString(cursor.getColumnIndex("lastname"));
            String relation=cursor.getString(cursor.getColumnIndex("relation"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String birthday=cursor.getString(cursor.getColumnIndex("birthday"));
            String to=cursor.getString(cursor.getColumnIndex("to"));
            String city=cursor.getString(cursor.getColumnIndex("city"));
            String work=cursor.getString(cursor.getColumnIndex("work"));
            String things=cursor.getString(cursor.getColumnIndex("things"));
            String boughtdate=cursor.getString(cursor.getColumnIndex("ownerships.boughtdate"));
            Log.i("salam","name : "+firstname+" | "+"lastname : "+ lastname +" | "+"+nationalcode : "+nationalcode+"|"+"relation : "+ relation+"date : "+ date+"birthday : "+ birthday+"to : "+ to+"city : "+ city+"work : "+ work+"thigns : "+ things+"bought : "+ boughtdate);
        }
        cursor.close();
//        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
//        SQLiteDatabase db=feedreaderDBHelper.getReadableDatabase();
//        Cursor cursor=db.rawQuery("select * from people",null);
//        while (cursor.moveToNext()) {
//            String fristname=cursor.getString(cursor.getColumnIndex("nationalcode"));
//            String lastname=cursor.getString(cursor.getColumnIndex("lastname"));
//            String nationalcode=cursor.getString(cursor.getColumnIndex("birthday"));
//            String work=cursor.getString(cursor.getColumnIndex("city"));
//            Log.i("hani",fristname+"|"+lastname+"|"+nationalcode+"|"+work);
//        }
//        cursor.close();
    }
}
