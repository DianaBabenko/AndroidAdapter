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
    StudentAdapter adapter;
    Student studentItem;

    @Override
    protected void onCreate (Bundle savedInstanceStudent) {
        super.onCreate(savedInstanceStudent);
        setContentView(R.layout.activity_main);

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

    public void onButtonPressedRemove(View view) {
        for(int i = 0; i < students.size(); i++) {
            students.remove(studentItem);
        }
        nameEditText.setText("");
        markEditText.setText("");
        adapter.notifyDataSetChanged();
    }

    public void onButtonPressedAdd(View view) {
        if (markEditText.getText().length() != 0 && nameEditText.getText().length() != 0) {
            students.add(new Student(nameEditText.getText().toString(), Integer.valueOf(markEditText.getText().toString())));
        }
        nameEditText.setText("");
        markEditText.setText("");
        adapter.notifyDataSetChanged();
    }
}