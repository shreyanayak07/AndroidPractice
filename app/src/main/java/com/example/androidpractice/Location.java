package com.example.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Location extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        Spinner s = (Spinner) findViewById(R.id.cityList);
        Button cancel=findViewById(R.id.rideCancel);
        EditText ride=findViewById(R.id.Ridecar);
        EditText price=findViewById(R.id.RateEdit);
        price.setText("Rs10 per KM");
        Intent intent = getIntent();
        String str=  intent.getStringExtra("Car_name");
        ride.setText(str);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Select_City,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(getApplicationContext(), Car.class);
                startActivity(c);
                Toast.makeText(getApplicationContext(),"Loaction setup Canceled",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String city= (String) parent.getItemAtPosition(position);
        Toast.makeText(Location.this, "City selected"+city, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
