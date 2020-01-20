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
        String query="drop table if exists phase1";
        db.execSQL(query);
        String query1="Create table phase1(" +
                "'nationalcode' INT ," +
                "'things' Text ," +
                "'relation' Text ," +
                "'datebought' INT " +
                ")";
        db.execSQL(query1);
        Cursor cursor=db.rawQuery("SELECT * " +
                "FROM  relationships " +
                "join people " +
                "on people.nationalcode = relationships.nationalcode "+
                " join ownerships"+
                " on people.nationalcode = ownerships.[from] "+
                " where ownerships.diffdate < 3 and work ='گمرگ ایران' "+
                "",null);
        while (cursor.moveToNext()) {
            String nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String things=cursor.getString(cursor.getColumnIndex("things"));
            String datebought=cursor.getString(cursor.getColumnIndex("boughtdate"));
            String relation=cursor.getString(cursor.getColumnIndex("relation"));
            String firstname=cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname=cursor.getString(cursor.getColumnIndex("lastname"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String birthday=cursor.getString(cursor.getColumnIndex("birthday"));
            String to=cursor.getString(cursor.getColumnIndex("to"));
            Log.i("java1",nationalcode+things+datebought+relation);
            String query2 = "insert INTO 'phase1' ( 'nationalcode' , 'things' , " +
                    "'datebought','relation') " +
                    "values ('"+nationalcode+"','"+things+"' " +
                    ", '"+datebought+"','"+relation+"')";
            db.execSQL(query2);
            String city=cursor.getString(cursor.getColumnIndex("city"));
            String work=cursor.getString(cursor.getColumnIndex("work"));
            things=cursor.getString(cursor.getColumnIndex("things"));
            String boughtdate=cursor.getString(cursor.getColumnIndex("boughtdate"));
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
