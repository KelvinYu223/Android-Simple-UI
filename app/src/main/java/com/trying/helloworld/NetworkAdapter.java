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

class NetworkAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> data;
    private Context context;

    public NetworkAdapter(@NonNull Context context, ArrayList<Contact> data) {
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
        Contact contact = data.get(position);
        View view;
        if (convertView==null){
            NetworkAdapter.holder holder=new NetworkAdapter.holder();
            view= LayoutInflater.from(context).inflate(R.layout.activity_student_name,null);
            holder.id=view.findViewById(R.id.id);
            holder.id.setText(contact.getId());
            holder.name=view.findViewById(R.id.name);
            holder.name.setText(contact.getName());
            holder.course=view.findViewById(R.id.course);
            holder.course.setText(contact.getCourse());
            view.setTag(holder);
        }
        else{
            NetworkAdapter.holder holder=(NetworkAdapter.holder) convertView.getTag();
            view=convertView;
            holder.id.setText(contact.getId());
            holder.name.setText(contact.getName());
            holder.course.setText(contact.getCourse());
        }
        return view;
    }
    private static class holder{
        TextView id, name, course;
    }

}
