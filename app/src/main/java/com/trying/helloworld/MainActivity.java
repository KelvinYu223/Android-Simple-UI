package com.trying.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText email,password;
private Button loginbtn,btnweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }
    private void findViews(){
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginbtn=findViewById(R.id.loginbtn);
        btnweb=findViewById(R.id.btnweb);
    }
    private void setListener(){
        loginbtn.setOnClickListener(view ->{
            String a=email.getText().toString();
            Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
        });
        btnweb.setOnClickListener((view ->{
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.huawei.com"));
            startActivity(intent);
        }));

    }
}