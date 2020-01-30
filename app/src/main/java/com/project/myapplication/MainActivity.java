package com.project.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static com.project.myapplication.Readfromphones.rowsizephone;
import static com.project.myapplication.read_from_file_second.rowsizepeople;
import static com.project.myapplication.Readfromcars.rowsizecars;
import static com.project.myapplication.Readfromhomes.rowsizehome;
import static com.project.myapplication.Readfromaccounts.rowsizeaccount;
import static com.project.myapplication.Readfromcalls.rowsizecalls;
import static com.project.myapplication.Readfromtransactions.rowsizetransactions;
import static com.project.myapplication.Readfromownership.rowsizeownership;
import static com.project.myapplication.Readfromrelationships.rowsizerealationships;
public class MainActivity extends AppCompatActivity {
    public static int sizepeople=0;
    public static int sizephone=0;
    public static int sizecars=0;
    public static int sizehome=0;
    public static int sizeaccounts=0;
    public static int sizecalls=0;
    public static int sizetransactions=0;
    public static int sizeownerships=0;
    public static int sizerelationships=0;
    CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this is for version 2 of app
//        circleMenu =findViewById(R.id.circlemenu);
//        circleMenu
//                .setMainMenu(Color.parseColor("#FF5722"),R.drawable.add2,R.drawable.remove)
//                .addSubMenu(Color.parseColor("#FFFFFF"),R.drawable.phase1)
//                .addSubMenu(Color.parseColor("#FFFFFF"),R.drawable.phase2)
//                .addSubMenu(Color.parseColor("#FFFFFF"),R.drawable.three)
//                .addSubMenu(Color.parseColor("#FFFFFF"),R.drawable.four)
//                .addSubMenu(Color.parseColor("#FFFFFF"),R.drawable.help)
//                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
//                    @Override
//                    public void onMenuSelected(int index) {
//                        if(index == 0){
//                            Intent intent4 = new Intent(MainActivity.this,Phase2.class);
//                            startActivity(intent4);
//                        }
//                        else if(index == 1){
//                            Intent intent = new Intent(MainActivity.this,phase1Activity.class);
//                            startActivity(intent);
//                        }
//                        else if(index == 2){
//                            activityforphse3();
//                        }
//                        else if(index == 3){
//                            Intent intent3 = new Intent(MainActivity.this,phase4.class);
//                            startActivity(intent3);
//                        }
//                        else if(index == 4){
//                            help();
//                        }
//                    }
//                });
//        circleMenu.setTranslationX(-1000f);
//        circleMenu.setTranslationY(-1000f);
//        circleMenu.setScaleX(0.2f);
//        circleMenu.setScaleY(0.2f);
//        customAnimation();
        read_from_file_second.i=0;
        Readfromphones.i=0;
        Readfromcars.i=0;
        Readfromcalls.i=0;
        Readfromtransactions.i=0;
        Readfromrelationships.i=0;
        Readfromhomes.i=0;
        Readfromownership.i=0;
        Readfromaccounts.i=0;
        Readfromownership.i=0;
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isfirstrun=sharedPreferences.getBoolean("FIRSTRUN",true);
        if (isfirstrun) {
            Toast.makeText(this,"reading file",Toast.LENGTH_SHORT).show();
            readfilepeople();
            readfilephones();
            readfilecars();
            readfilehomes();
            readfileaccounts();
            readfilecalls();
            readfiletransactions();
            readfileownerships();
            readfilerelationships();
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("FIRSTRUN",false);
            editor.commit();
        }


    }
//    private void customAnimation() {
//        circleMenu.animate()
//                .translationX(0)
//                .translationY(0)
//                .rotation(200f)
//                .rotationBy(5 * 360f)
//                .scaleX(1f)
//                .scaleY(1f)
//                .setDuration(2000);
//    }
    public void readfilepeople(){
        read_from_file_second readfromsecond=new read_from_file_second();
        InputStream inputStream = getResources().openRawResource(R.raw.people);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizepeople=10000;
            try {
                bufferedReader.readLine();
                while ( (line = bufferedReader.readLine()) != null) {
                    sizepeople++;
//                    line=line.replace('"','*');
//                    line=line.replace("*,*","_");
//                    line=line.replace("*","_");
//                    line=line.replace(',',' ');
//                    String [] token=line.split("_");
                    String [] token=line.split(",");
                    readfromsecond.setFirstname(token[0]);
                    readfromsecond.setLastname(token[1]);
                    readfromsecond.setNationalecode(token[2]);
                    readfromsecond.setBirthday(token[3]);
                    readfromsecond.setCity(token[4]);
                    readfromsecond.setWork(token[5]);
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
              rowsizephone=5005;
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
          }
    public void readfilecars(){
        Readfromcars readfromcars=new Readfromcars();
        InputStream inputStream=getResources().openRawResource(R.raw.car);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizecars=20023;
        try {
            while ( (line = bufferedReader.readLine()) != null){
                sizecars++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromcars.setCar(token[0]);
                readfromcars.setNationalcode(token[1]);
                readfromcars.setPallet(token[2]);
                readfromcars.setColor(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilehomes(){
        Readfromhomes readfromhomes=new Readfromhomes();
        InputStream inputStream=getResources().openRawResource(R.raw.home);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizehome=19816;
        try {
            while ( (line = bufferedReader.readLine()) != null){
                sizehome++;
                line=line.replace('"','-');
                line=line.replace("-,-","_");
                line=line.replace("-","_");
                line=line.replace(',',' ');
                String [] token=line.split("_");
                readfromhomes.setNationalcode(token[1]);
                readfromhomes.setPrice(token[2]);
                readfromhomes.setPostalcode(token[3]);
                readfromhomes.setSize(token[4]);
                readfromhomes.setAddress(token[5]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfileaccounts(){
        Readfromaccounts readfromaccounts=new Readfromaccounts();
        InputStream inputStream=getResources().openRawResource(R.raw.account);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizeaccount=20042;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizeaccounts++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromaccounts.setNationalcodeaccount(token[0]);
                readfromaccounts.setBankname(token[1]);
                readfromaccounts.setSheba(token[2]);
                readfromaccounts.setAccountnumber(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilecalls(){
        Readfromcalls readfromcalls=new Readfromcalls();
        InputStream inputStream=getResources().openRawResource(R.raw.calls);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizecalls=30000;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizecalls++;

                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromcalls.setFrom(token[0]);
                readfromcalls.setTo(token[1]);
                readfromcalls.setCallID(token[2]);
                readfromcalls.setDate(token[3]);
                readfromcalls.setDuration(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfiletransactions(){
        Readfromtransactions readfromtransactions=new Readfromtransactions();
        InputStream inputStream=getResources().openRawResource(R.raw.transaction);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizetransactions=29999;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizetransactions++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromtransactions.setFrom(token[0]);
                readfromtransactions.setTo(token[1]);
                readfromtransactions.setTransaction_ID(token[2]);
                readfromtransactions.setDate(token[3]);
                readfromtransactions.setAmount(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfileownerships(){
        Readfromownership readfromownership=new Readfromownership();
        InputStream inputStream=getResources().openRawResource(R.raw.ownership);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        String line2 = "";
        int salam=0;
        rowsizeownership=33351;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizeownerships++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromownership.setFrom(token[0]);
                readfromownership.setTo(token[1]);
                readfromownership.setOwnershipID(token[2]);
                readfromownership.setDate(token[3]);
                token[3]=token[3].replace("-","");
                token[3]=token[3].replace(" ","");
                salam=Integer.parseInt(token[3]);
                salam=2020-salam/10000;
                readfromownership.setdiffdate(salam);
                readfromownership.setAmount(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilerelationships(){
        Readfromrelationships readfromrelationships=new Readfromrelationships();
        InputStream inputStream=getResources().openRawResource(R.raw.relationship);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizerealationships=60000;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizerelationships++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromrelationships.setFrom(token[0]);
                readfromrelationships.setTo(token[1]);
                readfromrelationships.setRelation(token[2]);
                readfromrelationships.setDate(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        FeedreaderDBHelper feedreaderDBHelper1=new FeedreaderDBHelper(this);
        SQLiteDatabase db=feedreaderDBHelper1.getWritableDatabase();
    }
    public void confirmbottom(View view) {
    }
                 //this is for version 2 of app
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        SubMenu intentSubmenu =  menu.addSubMenu("phase1");
//        intentSubmenu.add("phase1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent4 = new Intent(MainActivity.this,Phase2.class);
//                startActivity(intent4);
//                return false;
//            }
//        });
//        intentSubmenu.add("phase3").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent2 = new Intent(MainActivity.this,phase3.class);
//                startActivity(intent2);
//                return false;
//            }
//        });
//        intentSubmenu.add("phase2").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(MainActivity.this,phase1Activity.class);
//                startActivity(intent);
//                return false;
//            }
//        });
//        intentSubmenu.add("phase4").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent3 = new Intent(MainActivity.this,phase4.class);
//                startActivity(intent3);
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
    public void activityforphse3(){
        Intent intent3 = new Intent(MainActivity.this,phase3.class);
        startActivity(intent3);
    }
    public void help(){
        String filepath= String.valueOf(getResources().openRawResource(R.raw.project));
        Uri uri= Uri.fromFile(getFileStreamPath(filepath));
        try {
            Intent intentUrl=new Intent(Intent.ACTION_VIEW);
            intentUrl.setDataAndType(uri,"application/pdf");
            intentUrl.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentUrl);
        }
        catch (ActivityNotFoundException ex){
            Toast.makeText(this,"No PDF Viewer installed",Toast.LENGTH_SHORT).show();
        }
    }
}
