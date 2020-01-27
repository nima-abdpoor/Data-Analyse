package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class phase1Activity extends AppCompatActivity {
    ListView listView;
    List<String> mylist;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase1);
        listView =findViewById(R.id.ListView);
        mylist=new ArrayList<>();
        FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
        SQLiteDatabase db=Fhelper.getReadableDatabase();
        String query="drop table if exists phase1";
        db.execSQL(query);
        String query1="Create table phase1(" +
                "'nationalcode' INT ," +
                "'things' Text ," +
                "'relation' Text ," +
                "'datebought' INT " +
                ")";
        db.execSQL(query1);
        mylist =indicate();
        Refreshdisplay();
    }
    private void Refreshdisplay(){
        if(mylist ==null)mylist=new ArrayList<>();
        arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(arrayAdapter);
    }
    public List<String> indicate(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT DISTINCT * " +
                "FROM  relationships " +
                "join people " +
                "on people.nationalcode = relationships.nationalcode "+
                " join ownerships"+
                " on people.nationalcode = ownerships.[from] "+
                " where ownerships.diffdate < 3 and work ='گمرگ ایران' "+
                "",null);
        while (cursor.moveToNext()) {
            String things=cursor.getString(cursor.getColumnIndex("things"));
            String datebought=cursor.getString(cursor.getColumnIndex("boughtdate"));
            String relation=cursor.getString(cursor.getColumnIndex("relation"));
            String firstname=cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname=cursor.getString(cursor.getColumnIndex("lastname"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String birthday=cursor.getString(cursor.getColumnIndex("birthday"));
            String to=cursor.getString(cursor.getColumnIndex("to"));
            String query2 = "insert INTO 'phase1' ( 'nationalcode' , 'things' , " +
                    "'datebought','relation') " +
                    "values ('"+nationalcode+"','"+things+"' " +
                    ", '"+datebought+"','"+relation+"')";
            sqLiteDatabase.execSQL(query2);
            String city=cursor.getString(cursor.getColumnIndex("city"));
            String work=cursor.getString(cursor.getColumnIndex("work"));
            things=cursor.getString(cursor.getColumnIndex("things"));
            String boughtdate=cursor.getString(cursor.getColumnIndex("boughtdate"));
            //Log.i("phase2","name : "+firstname+" | "+"lastname : "+ lastname +" | "+"+nationalcode : "+nationalcode+"|"+"relation : "+ relation+"date : "+ date+"birthday : "+ birthday+"to : "+ to+"city : "+ city+"work : "+ work+"thigns : "+ things+"bought : "+ boughtdate);
            peoplelist.add(firstname+" "+lastname+"\nwith this nationalcode : "+nationalcode +"\nhas relation with "+to+" and the relation is :"+relation+"\nwho born on : "+birthday+"\nand bought : "+things);
        }
        cursor.close();
        return peoplelist;
    }
}
