package com.example.shajjad.projectone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shajjad.projectone.database.DatabaseHelper;
import com.example.shajjad.projectone.model.Student;

public class ProfileView extends AppCompatActivity {
    TextView textViewNameProfile,textViewPassword,textViewId, textViewEmail, textViewPhone, textViewGender, textViewCgpa;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        textViewNameProfile= (TextView) findViewById(R.id.textViewNameProfile);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        textViewId = (TextView) findViewById(R.id.textViewId);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewPhone = (TextView) findViewById(R.id.textViewPhone);
        textViewGender = (TextView) findViewById(R.id.textViewGender);
        textViewCgpa = (TextView) findViewById(R.id.textViewCgpa);

        email = getIntent().getStringExtra("email");

        DatabaseHelper databaseHelper = new DatabaseHelper(ProfileView.this);
        Student std = databaseHelper.getSingleStudentByEmail(email);
        textViewNameProfile.setText(std.getName());
        textViewPassword.setText(std.getPassword());
        textViewId.setText(std.getId());
        textViewEmail.setText(std.getEmail());
        textViewPhone.setText(std.getPhone());
        textViewGender.setText(std.getGender());
        textViewCgpa.setText(String.valueOf(std.getCgpa()));

    }

    public void viewOthersClickAction(View view) {
        Intent intent = new Intent(ProfileView.this,AllProfileView.class);
        intent.putExtra("Email",email);
        startActivity(intent);
    }
}
