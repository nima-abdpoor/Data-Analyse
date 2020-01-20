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
        //showtable();
    }
    private void showtable() {
        FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
        SQLiteDatabase db=Fhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from relationships",null);
        while (cursor.moveToNext()) {
            String fristname=cursor.getString(cursor.getColumnIndex("from"));
            Log.i("checkdata",fristname);
        }
        cursor.close();
    }
}
