package com.example.shajjad.projectone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shajjad.projectone.R;
import com.example.shajjad.projectone.model.Student;

import java.util.ArrayList;

/**
 * Created by SHAJJAD on 21-Oct-17.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> students;
    public CustomAdapter(Context context,ArrayList<Student> students) {
        this.context=context;
        this.students=students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View custom_view = inflater.inflate(R.layout.custom_adapter_layout,null);

        TextView textViewName = custom_view.findViewById(R.id.textViewName);
        TextView textViewEmail =custom_view.findViewById(R.id.textViewEmail);
        TextView textViewCgpa = custom_view.findViewById(R.id.textViewCgpa);

        textViewName.setText(students.get(i).getName());
        textViewEmail.setText(students.get(i).getEmail());
        textViewCgpa.setText("CGPA :" +students.get(i).getCgpa());



        return custom_view;
    }
}
