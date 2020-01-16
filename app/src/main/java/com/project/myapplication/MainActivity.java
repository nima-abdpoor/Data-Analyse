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

import static com.project.myapplication.Readfromphones.rowsizephone;
import static com.project.myapplication.read_from_file_second.rowsizepeople;
public class MainActivity extends AppCompatActivity {
    public static int sizepeople=0;
    public static int sizephone=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read_from_file_second.i=0;
        Readfromphones.i=0;
            readfilepeople();
            readfilephones();
          }
    public void readfilepeople(){
        read_from_file_second readfromsecond=new read_from_file_second();
        InputStream inputStream = getResources().openRawResource(R.raw.people);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizepeople=100;

            try {
                while ( (line = bufferedReader.readLine()) != null) {
                    sizepeople++;
                    line=line.replace('"',' ');
                    String [] token=line.split(",");
                    readfromsecond.setFirstname(token[0]);
                    readfromsecond.setLastname(token[1]);
                    readfromsecond.setNationalecode(token[2]);
                    readfromsecond.setBirthday(token[3]);
                    readfromsecond.setCity(token[4]);
                    readfromsecond.setWork(token[5]);
                    readfromsecond.setAddress(token[6]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          public void readfilephones(){
          Readfromphones readfromphones=new Readfromphones();
          InputStream inputStream=getResources().openRawResource(R.raw.phones);
              BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
              String line;
              rowsizephone=46;

              try {
                  while ( (line = bufferedReader.readLine()) != null){
                      sizephone++;
                      line=line.replace('"','-');
                      line=line.replace("-","");
                      String [] token=line.split(",");
                      readfromphones.setNationalcodephone(token[0]);
                      readfromphones.setNumber(token[1]);
                      readfromphones.setOperator(token[2]);
                  }
              }
              catch (IOException e){
                  e.printStackTrace();
              }
              FeedreaderDBHelper Fhelper=new FeedreaderDBHelper(this);
              SQLiteDatabase db=Fhelper.getWritableDatabase();
          }
    public void confirmbottom(View view) {

    }
}

