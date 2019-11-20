package com.androidproject.adapterviewlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student>{
    private LayoutInflater inflater;
    private int layout;
    private List<Student> students;


    public StudentAdapter(Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.students = students;
        this.layout = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView nameView = (TextView)view.findViewById(R.id.nameView);
        TextView markView = (TextView)view.findViewById(R.id.markView);

        Student student = students.get(position);

        nameView.setText(student.getName());
        markView.setText(student.getMark());
        return view;
    }



}
