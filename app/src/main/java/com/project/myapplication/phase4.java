package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class phase4 extends AppCompatActivity {
    ListView listView;
    List<String> mylist;
    List<String> mylist2;
    Button button;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase4);
        listView =findViewById(R.id.ListView);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(phase4.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mylist=new ArrayList<>();
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
        mylist =getallpeople();
        Refreshdisplay();


    }
    public Cursor indicatephase4(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        Cursor cursor4=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                " FROM calls " +
                " join ghachghchiphones " +
                " on ghachghchiphones.number = calls.[from] "+
                " join suspectsphones"+
                " on suspectsphones.numbersuspect = calls.[to] "+
                "",null);
        return cursor4;
    }
    private void Refreshdisplay(){
        if(mylist ==null)mylist=new ArrayList<>();
        arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(arrayAdapter);
    }
    public List<String> getallpeople(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
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
            String end ="this nationalcode : "+nationalcode3+"\nwith this number : "+phonenumber+"\ntime : "+duration;
            mylist.add(end);
        }
        cursor4.close();
        return mylist;
    }
}
