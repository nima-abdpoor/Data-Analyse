package com.project.myapplication;
import java.util.LinkedHashMap;
import static com.project.myapplication.read_from_file_second.rowsizepeople;
public class samplepeopledata {
    private static String firstname;
    public static LinkedHashMap<String,String> get(){
        LinkedHashMap<String,String> data=new LinkedHashMap<String, String>();
        data.put("name",firstname);
        for(int i = 0; i< rowsizepeople; ++i){
            data.put(String.valueOf(i),read_from_file_second.getFirstname());
        }
        return data;
    }
}
