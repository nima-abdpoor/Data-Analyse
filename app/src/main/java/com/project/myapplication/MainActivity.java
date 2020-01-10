package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static com.project.myapplication.read_from_file_second.rowsizepeople;
import static com.project.myapplication.read_from_file_second.rowsizephone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
        SQLiteDatabase db=Fhelper.getWritableDatabase();
        read_from_file_second.i=0;
    }
    public void readfilepeople(){
        read_from_file_second readfromsecond=new read_from_file_second();
        InputStream inputStream =getResources().openRawResource(R.raw.people);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizepeople =11133;

            try {
                bufferedReader.readLine();
                while ( (line = bufferedReader.readLine()) != null && readfromsecond.i < rowsizepeople) {
                    line=line.replace('"','-');
                    line=line.replace("-","");
                    String [] token=line.split(",");
                    readfromsecond.setFirstname(token[0]);
                    readfromsecond.setLastname(token[1]);
                    readfromsecond.setNationalecode(token[2]);
                    readfromsecond.setBirthday(token[3]);
                    readfromsecond.setCity(token[4]);
                    readfromsecond.setAddress(token[5]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void readfilephones(){
        read_from_file_second readforphones=new read_from_file_second();
        InputStream inputStream=getResources().openRawResource(R.raw.phones);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizephone =49;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                line=line.replace('"','-');
                line=line.replace("-","");
                String [] token=line.split(",");
            }
        }
        catch (IOException e){
        }
        }
    public void confirmbottom(View view) {

    }
}

