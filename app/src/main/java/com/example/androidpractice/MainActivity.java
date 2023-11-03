package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences shared1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button b=findViewById(R.id.submit);
        Button register=findViewById(R.id.register);
        EditText username= (EditText) findViewById(R.id.username);
        EditText password=findViewById(R.id.password);

        shared1=getSharedPreferences("My_shared_preference", MODE_PRIVATE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String user= username.getText().toString();
                String pass=password.getText().toString();
                SharedPreferences.Editor editor = shared1.edit();
                editor.putString("username", user);
                editor.putString("password", pass);
                editor.apply();
                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Username Or Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (user.equalsIgnoreCase(shared1.getString("username",user)) && pass.equalsIgnoreCase(shared1.getString("password", pass))) {
                        Intent i = new Intent(getApplicationContext(), BookingDetails.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"Sign up Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Incorrect Username or Password ", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(r);
            }
        });

    }
}