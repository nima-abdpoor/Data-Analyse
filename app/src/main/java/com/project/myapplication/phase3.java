package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class phase3 extends AppCompatActivity {
    ListView listView;
    List<String> mylist;
    Button button;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase3);
        listView =findViewById(R.id.ListView);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(phase3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mylist=new ArrayList<>();
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
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
        String query="drop table if exists phase2";
        sqLiteDatabase.execSQL(query);
        String query1="Create table phase2(" +
                "'accountnumber' INT ," +
                "'nationalcodephase2' INT " +
                ")";
        sqLiteDatabase.execSQL(query1);
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                "FROM  accounts " +
                " join people " +
                "on people.nationalcode = accounts.nationalcodeaccount "+
                " join transactions"+
                " on accounts.accountnumber = transactions.[from] "+
                " join ownerships"+
                " on ownerships.[from] = people.nationalcode "+
                " where  people.work ='قاچاقچی'"+
                "",null);
        while (cursor.moveToNext()) {
             relativenationalcode=cursor.getString(cursor.getColumnIndex("to"));
            sqLiteDatabase.execSQL("INSERT INTO 'phase2'('accountnumber')"+
                    " VALUES ('"+relativenationalcode+"')");
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
        }
        cursor1.close();
        mylist=getallpeople();
        Refreshdisplay();

    }
    private void Refreshdisplay(){
        if(mylist ==null)mylist=new ArrayList<>();
        arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(arrayAdapter);
    }
    public List<String> getallpeople(){
        ArrayList<String> newlist=new ArrayList<>();
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        Cursor cursor2=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                " FROM  people " +
                " join phase2 " +
                " on people.nationalcode = phase2.nationalcodephase2 "+
                "join phase1"+
                " on phase1.nationalcode =  phase2.nationalcodephase2"+
                "",null);
        while (cursor2.moveToNext()) {
           String nationalcode=cursor2.getString(cursor2.getColumnIndex("nationalcode"));
           String firstname=cursor2.getString(cursor2.getColumnIndex("firstname"));
           String lastname=cursor2.getString(cursor2.getColumnIndex("lastname"));
           String things=cursor2.getString(cursor2.getColumnIndex("things"));
           String datebought=cursor2.getString(cursor2.getColumnIndex("datebought"));
           peoplelist.add(firstname +" "+lastname+"\nthis nationalcode : "+nationalcode+"\n"+"bought "+things+" on : "+datebought);
            for (String element:peoplelist
            ) {
                if(!newlist.contains(element)){
                    newlist.add(element);
                }
            }
        }
        cursor2.close();
        return newlist;
    }
}
