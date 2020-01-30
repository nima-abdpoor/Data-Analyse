package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Phase2 extends AppCompatActivity {
    ListView listView;
    List<String> mylist;
    TextView textView;
    TextView textView2;
    Button button;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase2);
        listView =findViewById(R.id.ListView);
        textView=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        button =findViewById(R.id.button);
        button.setVisibility(View.GONE);
        mylist=new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Phase2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Refreshdisplay(){
        if(mylist ==null)mylist=new ArrayList<>();
        arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(arrayAdapter);
    }
    public List<String> getallpeople(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        textView.setText("all people : 10000 نفر");
        Cursor cursor=sqLiteDatabase.rawQuery("select * from 'people'",null);
        while (cursor.moveToNext()){
            String firstname= cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname=cursor.getString(cursor.getColumnIndex("lastname"));
            String nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String birthday =cursor.getString(cursor.getColumnIndex("birthday"));
            String work =cursor.getString(cursor.getColumnIndex("work"));
            String city =cursor.getString(cursor.getColumnIndex("city"));
            peoplelist.add(firstname +" "+lastname+"\nwith this nationalcode : "+nationalcode+"\nis born on : "+birthday+"\nis working in : "+work+"\nand now is in : "+city);
        }
        return peoplelist;
    }
    public List<String> getallhomes(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        textView.setText("all homes : 19816");
        Cursor cursor=sqLiteDatabase.rawQuery("select * from 'homes'",null);
        while (cursor.moveToNext()){
            String nationalcode= cursor.getString(cursor.getColumnIndex("nationalcode"));
            String price=cursor.getString(cursor.getColumnIndex("price"));
            String postalcode=cursor.getString(cursor.getColumnIndex("postalcode"));
            String size =cursor.getString(cursor.getColumnIndex("size"));
            String address =cursor.getString(cursor.getColumnIndex("address"));
            peoplelist.add("this nationalcode : "+nationalcode+"\nbought a home with : "+postalcode+" postalcode, \nthe price is : "+price+" tomans and it has "+size+" meter size \nin: "+address);
        }
        return peoplelist;
    }
    public List<String> getallcars(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        textView.setText("all cars : 20023");
        Cursor cursor=sqLiteDatabase.rawQuery("select * from 'cars'",null);
        while (cursor.moveToNext()){
            String car= cursor.getString(cursor.getColumnIndex("car"));
            String nationalcode=cursor.getString(cursor.getColumnIndex("nationalcode"));
            String pallet=cursor.getString(cursor.getColumnIndex("pallet"));
            String color =cursor.getString(cursor.getColumnIndex("color"));
            peoplelist.add("this nationalcode : "+nationalcode+"\nhas a "+pallet+" with : "+car+" pallet, \nthe color is : "+color);
        }
        return peoplelist;
    }
    public List<String> getallownerships(){
        FeedreaderDBHelper feedreaderDBHelper=new FeedreaderDBHelper(this);
        SQLiteDatabase sqLiteDatabase=feedreaderDBHelper.getReadableDatabase();
        List<String> peoplelist=new ArrayList<>();
        textView.setText("all ownerships");
        Cursor cursor=sqLiteDatabase.rawQuery("select * from 'ownerships'",null);
        while (cursor.moveToNext()){
            String from= cursor.getString(cursor.getColumnIndex("from"));
            String things=cursor.getString(cursor.getColumnIndex("things"));
            String boughtdate=cursor.getString(cursor.getColumnIndex("boughtdate"));
            String amount =cursor.getString(cursor.getColumnIndex("amount"));
            peoplelist.add("this nationalcode : "+from+"\nhas a "+things+" with : "+amount+" tomans value, \nbought in : "+boughtdate);
        }
        return peoplelist;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Get all peoples").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                textView2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                mylist =getallpeople();
                Refreshdisplay();
                return false;
            }
        });
        menu.add("Get all homes").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                textView2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                mylist =getallhomes();
                Refreshdisplay();
                return false;
            }
        });
        menu.add("Get all cars").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                textView2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                mylist=getallcars();
                Refreshdisplay();
                return false;
            }
        });
        menu.add("Get all ownerships").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                textView2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                mylist=getallownerships();
                Refreshdisplay();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

