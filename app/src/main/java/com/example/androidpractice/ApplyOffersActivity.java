package com.example.androidpractice;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ApplyOffersActivity extends AppCompatActivity {

    private List<Offer> availableOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_offers);

        availableOffers = new ArrayList<>();
        availableOffers.add(new Offer("OFFER10", 10.0));
        availableOffers.add(new Offer("OFFER20", 20.0));

        EditText offerCodeEditText = findViewById(R.id.offerCodeEditText);
        Button applyOfferButton = findViewById(R.id.applyOfferButton);

        applyOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredCode = offerCodeEditText.getText().toString().trim();

                if (!enteredCode.isEmpty()) {
                    applyOffer(enteredCode);
                } else {
                    Toast.makeText(ApplyOffersActivity.this, "Please enter an offer code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void applyOffer(String enteredCode) {
        for (Offer offer : availableOffers) {
            if (offer.getCode().equals(enteredCode)) {
                Toast.makeText(this, "Offer applied: " + offer.getDiscount() + "% discount", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("offerCode", offer.getCode());
                intent.putExtra("offerDiscount", offer.getDiscount());
                setResult(Activity.RESULT_OK, intent);
                finish();
                return;
            }
        }

        // If the entered offer code is not valid
        Toast.makeText(this, "Invalid offer code", Toast.LENGTH_SHORT).show();
    }
}
