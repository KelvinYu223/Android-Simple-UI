package com.trying.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Networking extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private ArrayList <String> userList = new ArrayList<>();
    private ListView listview2;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
        findViews();
        setListeners();
        getDataFromInternet();
    }
    private void findViews(){
        listview2 = findViewById(R.id.listview2);
        progressbar = findViewById(R.id.progressbar);
    }
    private void setListeners(){

    }
    private void initListview(){
        NetworkAdapter adapter = new NetworkAdapter(this, userList);
        listview2.setAdapter(adapter);
    }
    private void getDataFromInternet(){
        progressbar.setVisibility(View.VISIBLE);
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/v3/b/60d14dca8ea8ec25bd12b9b4")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() ->{
                Toast.makeText(Networking.this,"Fail to fetch data", Toast.LENGTH_SHORT).show();
            });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String res = response.body().string();
                try {
                    JSONObject resObject = new JSONObject(res);
                    JSONArray usersArray = resObject.getJSONObject("record").getJSONArray("users");
                    for(int i=0; i<usersArray.length(); i++){
                        userList.add(usersArray.getString(i));
                    }
                    runOnUiThread(() ->{
                        initListview();
                        progressbar.setVisibility(View.GONE);
                    });
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
