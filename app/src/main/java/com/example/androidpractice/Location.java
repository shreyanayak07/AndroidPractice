package com.example.androidpractice;

import android.content.DialogInterface;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Location extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
//    String sedan;
//    String locationA;
//    String destinationX;
//    public Location(String sedan, String locationA, String destinationX) {
//        this.sedan=sedan;
//        this.locationA=locationA;
//        this.destinationX=destinationX;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        Spinner s = (Spinner) findViewById(R.id.cityList);
        Button cancel=findViewById(R.id.rideCancel);
        Button confirm=findViewById(R.id.rideConfirm);
        EditText ride=findViewById(R.id.Ridecar);
        EditText price=findViewById(R.id.RateEdit);

        Intent intent = getIntent();

        String str=  intent.getStringExtra("Car_name");
        ride.setText(str);

        String pr=intent.getStringExtra("Price");
        price.setText(pr);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPressed();
            }
        });

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
    public void confirmPressed(){
        AlertDialog.Builder alert=new AlertDialog.Builder(Location.this);
        alert.create();
        alert.setTitle("Ride Booked");
        alert.setIcon(R.drawable.car);
        alert.setMessage("Your Ride has been booked");
        alert.setPositiveButton("OK",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Intent back=new Intent(getApplicationContext(),BookingDetails.class);
                startActivity(back);
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
