package com.example.mad_assignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class App1 extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textViewDistance, textViewDistanceFt, textViewDistanceInch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app1);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textViewDistance = findViewById(R.id.textViewDistance);
        textViewDistanceFt = findViewById(R.id.textViewDistanceFt);
        textViewDistanceInch = findViewById(R.id.textViewDistanceInch);

        button.setOnClickListener(v -> {
            String distanceKm = editText.getText().toString();
            if (distanceKm.isEmpty()) {
                editText.setError("Please enter a valid distance in KM");
                return;
            }
            double distance = Double.parseDouble(distanceKm);
            double distanceInMeters = distance * 1000;
            double distanceInFeet = distanceInMeters * 3.28084;
            double distanceInInches = distanceInFeet * 12;

            textViewDistance.setText("Distance in meters = " + String.format("%.2f", distanceInMeters) + " m");
            textViewDistanceFt.setText("Distance in feet = " + String.format("%.2f", distanceInFeet) + " ft");
            textViewDistanceInch.setText("Distance in inches = " + String.format("%.2f", distanceInInches) + " inch");
        });
    }
}