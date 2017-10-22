package com.example.shajjad.projectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shajjad.projectone.adapter.CustomAdapter;
import com.example.shajjad.projectone.database.DatabaseHelper;
import com.example.shajjad.projectone.model.Student;

import java.util.ArrayList;

import static android.R.attr.name;
import static com.example.shajjad.projectone.R.drawable.email;

public class AllProfileView extends AppCompatActivity {
    ListView listViewAllStudent;
    ArrayList<Student>  arrayListStudent;
   // ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_profile_view);
        listViewAllStudent = (ListView) findViewById(R.id.listViewAllStudent);
        arrayListStudent=new ArrayList<Student>();
       DatabaseHelper databaseHelper = new DatabaseHelper(AllProfileView.this);
       arrayListStudent=databaseHelper.getAllStudent();
        String email = getIntent().getStringExtra("Email");
        for(int i=0;i<arrayListStudent.size();i++){
            if(arrayListStudent.get(i).getEmail().equals(email)){
                arrayListStudent.remove(arrayListStudent.get(i));
                break;
            }
        }
        CustomAdapter adapter = new CustomAdapter(this,arrayListStudent);
        //adapter=new ArrayAdapter<Student>(AllProfileView.this,android.R.layout.simple_list_item_1,arrayListStudent);
        listViewAllStudent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
