package com.trying.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Student_Name extends AppCompatActivity {
    private ArrayList<String> studentname=new ArrayList<>();
    private ArrayList<String> number=new ArrayList<>();
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        findViews();
        setListeners();
        initStudentname();
        //initNumber();
    }
    private void initStudentname(){
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
        studentname.add("John");
    }

    private void findViews(){
        listview=findViewById(R.id.listview);
    }
    private void setListeners(){
        StudentAdapter adapter=new StudentAdapter(this,studentname);
        listview.setAdapter(adapter);
    }

}