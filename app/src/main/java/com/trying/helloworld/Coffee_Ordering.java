package com.trying.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Coffee_Ordering extends AppCompatActivity {
    private Button btnminus, btnadd, btnmakeorder;
    private CheckBox checkbox1, checkbox2, checkbox3;
    private TextView text1;
    int text=1;
    int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_ordering);
        findViews();
        setListener();
    }
    private void findViews(){
        btnminus=findViewById(R.id.btnminus);
        btnadd=findViewById(R.id.btnadd);
        btnmakeorder=findViewById(R.id.btnmakeorder);
        checkbox1=findViewById(R.id.checkbox1);
        checkbox2=findViewById(R.id.checkbox2);
        checkbox3=findViewById(R.id.checkbox3);
        text1=findViewById(R.id.text1);
    }
    private void setListener(){
        int coffee=5;
        if (text>0){
            btnadd.setOnClickListener(view ->{
                text++;
        });
        }
        if (text>0){
            btnminus.setOnClickListener(view ->{
                text--;
            });
        }
        if (checkbox1.isChecked()){
            coffee +=1;
        }
        if (checkbox2.isChecked()){
            coffee +=2;
        }
        if (checkbox3.isChecked()){
            coffee +=3;
        }
        amount=coffee*text;
        Toast.makeText(this,amount,Toast.LENGTH_SHORT).show();
    }
}