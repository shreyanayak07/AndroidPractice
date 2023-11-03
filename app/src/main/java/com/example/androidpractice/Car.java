package com.example.androidpractice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Car extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclercar);
        MyCarListData[] myListData = new MyCarListData[] {
                new MyCarListData("$300/KM","BMW", R.drawable.bmw),
                new MyCarListData("$200/KM","Fort", R.drawable.fortuner),
                new MyCarListData("$500/KM","Lambo", R.drawable.lambo)
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclercar);
        MyCarListAdapter adapter = new MyCarListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
