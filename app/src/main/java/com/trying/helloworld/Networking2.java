package com.trying.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

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

public class Networking2 extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private ArrayList <Contact> contactArrayList = new ArrayList<>();
    private ListView listview2;
    private ProgressBar progressbar;
    ImageView photo, photo2, photo3, photo4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
        findViews();
        setListeners();
        getDataFromInternet();
        Picasso.get().load("http://tny.im/mz6").into(photo);
        Picasso.get().load("http://tny.im/ko-").into(photo2);
        Picasso.get().load("http://tny.im/mz7").into(photo3);
        Picasso.get().load("http://tny.im/mz8").into(photo4);
    }
    private void findViews() {
        listview2 = findViewById(R.id.listview2);
        progressbar = findViewById(R.id.progressbar);
        photo = findViewById(R.id.photo);
        photo2 = findViewById(R.id.photo2);
        photo3 = findViewById(R.id.photo3);
        photo4 = findViewById(R.id.photo4);
    }
    private void setListeners(){

    }
    private void initListview(){
        NetworkAdapter adapter = new NetworkAdapter(this, contactArrayList);
        listview2.setAdapter(adapter);
    }
    private void getDataFromInternet(){
        progressbar.setVisibility(View.VISIBLE);
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/v3/b/5f2773c81823333f8f1afec3")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() ->{
                    Toast.makeText(Networking2.this,"Fail to fetch data", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String res = response.body().string();
                try {
                    JSONObject resObject = new JSONObject(res);
                    JSONArray contactArray = resObject.getJSONObject("record").getJSONArray("response");
                    for(int i=0; i<contactArray.length(); i++){
                        JSONObject contactObject = contactArray.getJSONObject(i);
                        String id = contactObject.getString("id");
                        String name = contactObject.getString("name");
                        String course = contactObject.getString("course");
                        String photo = contactObject.getString("photo");
                        String photo2 = contactObject.getString("photo");
                        String photo3 = contactObject.getString("photo");
                        String photo4 = contactObject.getString("photo");
                        Contact contact = new Contact(id, name, course, photo, photo2, photo3, photo4);
                        contactArrayList.add(contact);
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

