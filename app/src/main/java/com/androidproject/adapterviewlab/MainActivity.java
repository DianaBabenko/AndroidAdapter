package com.androidproject.adapterviewlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText markEditText;
    ArrayList<Student> students = new ArrayList();
    //ArrayAdapter<String> adapter;
    StudentAdapter adapter;
    Student studentItem;
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

        final ListView studentList = (ListView)findViewById(R.id.studentList);
        adapter = new StudentAdapter(this, R.layout.list_item, students);
        studentList.setAdapter(adapter);

        nameEditText = findViewById(R.id.nameOfStudent);
        markEditText = findViewById(R.id.markOfStudent);

        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                studentItem = adapter.getItem(position);
                nameEditText.setText(studentItem.getName());
                markEditText.setText(Integer.toString(studentItem.getMark()));
            }
        });
        for(int i = 0; i < students.size(); i++) {
            students.remove(studentItem);
        }
    }

    /*public void onButtonPressedRemove(View view) {
        for (Student item : students) {
            if (item.getName().equals(nameEditText.getText())) {
                students.remove(studentList.(item));
            } else {
                nameEditText.setText("");
            }
        }
        ListView studentList = (ListView)findViewById(R.id.studentList);
        adapter = new StudentAdapter(this, R.layout.list_item, students);
        studentList.setAdapter(adapter);
    }*/

    public void onButtonPressedRemove(View view) {
        for(int i = 0; i < students.size(); i++) {
            students.remove(studentItem);
        }
            ListView studentList = (ListView)findViewById(R.id.studentList);
            adapter = new StudentAdapter(this, R.layout.list_item, students);
            studentList.setAdapter(adapter);
        nameEditText.setText("");
        markEditText.setText("");
    }

    public void onButtonPressedAdd(View view) {
        students.add(new Student(nameEditText.getText().toString(), Integer.valueOf(markEditText.getText().toString())));
        ListView studentList = (ListView)findViewById(R.id.studentList);
        adapter = new StudentAdapter(this, R.layout.list_item, students);
        studentList.setAdapter(adapter);
    }
}