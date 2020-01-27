package com.project.myapplication;

import java.util.ArrayList;

public class GFG {
    //Function for remove duplicates from an Arraylist
    public static <String>ArrayList<String> removeduplication(ArrayList<String> list){
        ArrayList<String> newlist=new ArrayList<>();
        for (String element :list){
            if(!newlist.contains(element)){
                newlist.add(element);
            }
        }
        return newlist;
    }
}
