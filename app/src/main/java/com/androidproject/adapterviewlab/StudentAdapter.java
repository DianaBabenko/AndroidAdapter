package com.androidproject.adapterviewlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
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

        viewHolder.nameInput.setText(student.getName());
        viewHolder.markInput.setText(Integer.toString(student.getMark()));


        /*viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mark = student.getMark() + 1;
                student.setMark(mark);
                viewHolder.markInput.setText(mark);
            }
        });

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mark = student.getMark() - 1;
                if(mark<0) mark=3;
                student.setMark(mark);
                viewHolder.markInput.setText(mark);
            }
            });*/


        return convertView;
    }


    private class ViewHolder {
       // final Button addButton, removeButton;
        final TextView nameInput, markInput;

        ViewHolder(View view) {
            /*addButton = (Button) view.findViewById(R.id.addButton);
            removeButton = (Button) view.findViewById(R.id.removeButton);*/
            nameInput =  view.findViewById(R.id.nameView);
            markInput =  view.findViewById(R.id.markView);
        }
    }
}




