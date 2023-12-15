package com.example.androidpractice;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_details);
        ImageButton profile=findViewById(R.id.profile);
        ImageButton history=findViewById(R.id.History);
        ImageButton offer=findViewById(R.id.offer);
        ImageButton car=findViewById(R.id.car);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Profile.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Profile", Toast.LENGTH_SHORT).show();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Look the History", Toast.LENGTH_SHORT).show();
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),OffersActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Look the History", Toast.LENGTH_SHORT).show();
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Car.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Book a Ride", Toast.LENGTH_SHORT).show();
            }
        });
    }}

