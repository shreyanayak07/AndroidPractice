package com.example.androidpractice;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidpractice.Location;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    public static void setOnClickListener(View.OnClickListener lookTheHistory) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ArrayList<Location> rideHistory = new ArrayList<>();
        rideHistory.add(new Location("Sedan", "Location A", "Destination X"));
        rideHistory.add(new Location("SUV", "Location B", "Destination Y"));
        rideHistory.add(new Location("Hatchback", "Location C", "Destination Z"));


        ListView historyListView = findViewById(R.id.historyListView);
        ArrayAdapter<Location> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rideHistory);
        historyListView.setAdapter(adapter);
    }
}