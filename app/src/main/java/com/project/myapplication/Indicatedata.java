package com.project.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
public class Indicatedata extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicatedata);
        showtable();
//        ListView list_people=findViewById(R.id.list_people);
//        ArrayList<peopleinfo> peoples=new ArrayList<peopleinfo>();
//        LinkedHashMap<String,String> samplepeopledata=new LinkedHashMap<String, String>();
//        Set<String> keyset=samplepeopledata.keySet();
//        for (String key:keyset) {
//            String value =samplepeopledata.get(key);
//            peoples.add(new peopleinfo(key,value,null,null,null,null,null));
//        }
//        peopleListViewAdapter adapter=new peopleListViewAdapter(this,peoples);
//        list_people.setAdapter(adapter);
    }
    private void showtable() {
        FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
        SQLiteDatabase db=Fhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from people",null);
        while (cursor.moveToNext()) {
            String fristname=cursor.getString(cursor.getColumnIndex("firstname"));
            Log.i("checkdata",fristname);
        }
        cursor.close();
    }
}
