package com.trying.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class NetworkAdapter extends ArrayAdapter<String> {
    private ArrayList<String> data;
    private Context context;

    public NetworkAdapter(@NonNull Context context, ArrayList<String> data) {
        super(context, R.layout.activity_student_name);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String studentname=data.get(position);
        View view;
        if (convertView==null){
            StudentAdapter.Holder holder=new StudentAdapter.Holder();
            view= LayoutInflater.from(context).inflate(R.layout.activity_student_name,null);
            holder.student=view.findViewById(R.id.student);
            holder.student.setText(studentname);
            view.setTag(holder);
        }
        else{
            StudentAdapter.Holder holder=(StudentAdapter.Holder) convertView.getTag();
            view=convertView;
            holder.student.setText(studentname);
        }
        return view;
    }

}
