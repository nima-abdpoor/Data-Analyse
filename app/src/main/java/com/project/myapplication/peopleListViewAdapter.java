package com.project.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class peopleListViewAdapter extends ListViewAdapter<peopleinfo>{

    public peopleListViewAdapter(Context context, ArrayList<peopleinfo> list) {
        super(context, list);
    }

    public static class ColorViewHolder extends ListViewAdapter.ViewHolder {
        ViewGroup root;
        TextView txt_ID;
        TextView txt_name;
    }
    @Override
    public ListViewAdapter.ViewHolder assign(View convertView) {
        ColorViewHolder viewHolder = new ColorViewHolder();
        viewHolder.root = (ViewGroup) convertView;
        //viewHolder.txt_ID =  convertView.findViewById(R.id.ID);
        //viewHolder.txt_name =  convertView.findViewById(R.id.name);
        return viewHolder;
    }
    @Override
    public void fill(ListViewAdapter.ViewHolder upcastedViewHolder, peopleinfo item) {
        ColorViewHolder viewHolder = (ColorViewHolder) upcastedViewHolder;
        viewHolder.txt_ID.setText(item.ID);
        viewHolder.txt_name.setText(item.firstname);
    }
}
