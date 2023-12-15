package com.example.androidpractice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        ArrayList<String> offersList = new ArrayList<>();
        offersList.add("Get 20% off on your next ride!");
        offersList.add("Refer a friend and earn rewards!");
        offersList.add("Special discount for frequent riders!");


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView offersListView = findViewById(R.id.offersListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, offersList);
        offersListView.setAdapter(adapter);
    }
}