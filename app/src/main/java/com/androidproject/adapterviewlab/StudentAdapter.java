package com.androidproject.adapterviewlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student>{
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Student> studentList;


    public StudentAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.studentList = students;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Student student = studentList.get(position);

        viewHolder.nameView.setText(student.getName());
        viewHolder.markView.setText(Integer.toString(student.getMark()));

        return convertView;
    }


    private class ViewHolder {
        final Button addButton, removeButton;
        final TextView nameView, markView;
        ViewHolder(View view){
            addButton = (Button)
                    view.findViewById(R.id.addButton);
            removeButton = (Button)
                    view.findViewById(R.id.removeButton);
            nameView = (TextView) view.findViewById(R.id.nameView);
            markView = (TextView) view.findViewById(R.id.markView);
        }
    }
}




