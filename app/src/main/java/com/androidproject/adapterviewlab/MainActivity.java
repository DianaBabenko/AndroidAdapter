package com.androidproject.adapterviewlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList();

    ListView studentList;
    @Override
    protected void onCreate (Bundle savedInstanceStudent) {
        super.onCreate(savedInstanceStudent);
        setContentView(R.layout.activity_main);

        if (students.size() == 0 ) {
            students.add(new Student("AAAAA", 1));
            students.add(new Student("BBBBB", 2));
            students.add(new Student("CCCCC", 3));
            students.add(new Student("DDDDD", 4));
            students.add(new Student("EEEEE", 5));
        }
        studentList = (ListView)findViewById(R.id.studentList);
        StudentAdapter adapter = new StudentAdapter(this, R.layout.list_item, students);
        studentList.setAdapter(adapter);
    }

}