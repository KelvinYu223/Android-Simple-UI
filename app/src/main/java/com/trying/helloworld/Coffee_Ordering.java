package com.trying.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Coffee_Ordering extends AppCompatActivity {
    private Button btnminus, btnadd, btnmakeorder;
    private CheckBox checkbox1, checkbox2, checkbox3;
    private TextView text1;
    private int amount=1, total;
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
        btnadd.setOnClickListener(view ->{
            amount++;
            text1.setText(Integer.toString(amount));
        });

        btnminus.setOnClickListener(view ->{
            amount--;
            text1.setText(Integer.toString(amount));
        });

        btnmakeorder.setOnClickListener(view ->{
            int coffee=5;
            if (checkbox1.isChecked()){
                coffee +=1;
            }
            if (checkbox2.isChecked()){
                coffee +=2;
            }
            if (checkbox3.isChecked()) {
                coffee += 3;
            }
            total=coffee*amount;

            openDialog();
        });
    }
    private void openDialog(){
        AlertDialog dlg=new AlertDialog.Builder(Coffee_Ordering.this)
                .setTitle("Your Order")
                .setMessage(""+Integer.toString(total))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dlg.show();
    }
}