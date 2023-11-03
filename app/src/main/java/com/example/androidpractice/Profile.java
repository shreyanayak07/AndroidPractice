package com.example.androidpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    SharedPreferences shared2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Button h=findViewById(R.id.home1);
        EditText fname=(EditText)findViewById(R.id.First_Name_profile);
        EditText lname=(EditText)findViewById(R.id.Last_Name_profile);
        EditText email=(EditText)findViewById(R.id.Email_profile);
        EditText ph=(EditText)findViewById(R.id.Phone_profile);
        EditText us=(EditText)findViewById(R.id.useName1_profile);
        EditText edits[]={fname,lname,email,ph,us};
        Button e=findViewById(R.id.edit);



        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(getApplicationContext(),BookingDetails.class);
                startActivity(inte);
            }
        });
e.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       for(EditText ei:edits) {
           ei.setCursorVisible(true);
           ei.setClickable(true);
           ei.setEnabled(true);
           ei.requestFocus();
       }
    }
});
}}
