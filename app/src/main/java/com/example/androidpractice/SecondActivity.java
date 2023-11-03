package com.example.androidpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
private SharedPreferences shared;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.Register_Here);
        Spinner spin=findViewById(R.id.spinner);
        EditText pass1=findViewById(R.id.pass1);
        EditText pass2=findViewById(R.id.pass2);
        EditText first=findViewById(R.id.First_Name);
        EditText last=findViewById(R.id.Last_Name);
        EditText email=findViewById(R.id.Email);
        EditText phone=findViewById(R.id.Phone);
        EditText user=findViewById(R.id.useName1);

        shared=getSharedPreferences("My_shared_preference", MODE_PRIVATE);

            String[] countries = {"India", "USA", "UK"};

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spin.setAdapter(adapter);

            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_Name=first.getText().toString();
                String last_Name=last.getText().toString();
                String email_address=email.getText().toString();
                String phone_number=phone.getText().toString();
                String user_name=user.getText().toString();
                String password_1=pass1.getText().toString();


                if (first_Name.isEmpty() || last_Name.isEmpty() || email_address.isEmpty() || phone_number.isEmpty() || user_name.isEmpty()
                        || password_1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("firstName", first_Name);
                    editor.putString("lastName", last_Name);
                    editor.putString("username", user_name);
                    editor.putString("phone",phone_number);
                    editor.putString("email", email_address);
                    editor.putString("password", password_1);
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                    finish(); // Finish the activity and go back to the previous screen

                }

                    if (pass1.getText().toString().equals(pass2.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Password Matched", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password did not Match", Toast.LENGTH_SHORT).show();
                    }
                }
        });
}}
