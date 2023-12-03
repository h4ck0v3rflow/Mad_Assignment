package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class App6 extends AppCompatActivity {
    EditText timeInput;
    Button checkTime;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app6);

        timeInput = findViewById(R.id.timeInput);
        checkTime = findViewById(R.id.checkTime);
        resultTextView = findViewById(R.id.resultTextView);

        checkTime.setOnClickListener(v -> {
            if (validateTime()) {
                checkTime();
            } else {
                Toast.makeText(App6.this, "Invalid time! Try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateTime() {
        String timeString = timeInput.getText().toString().trim();
        if (timeString.isEmpty()) {
            timeInput.setError("Field can't be empty!");
            return false;
        }

        int time = Integer.parseInt(timeString);
        if (time < 0 || time > 24) {
            timeInput.setError("Invalid time! Enter time between 0 to 24.");
            return false;
        }

        timeInput.setError(null);
        return true;
    }

    @SuppressLint("SetTextI18n")
    private void checkTime() {
        int time = Integer.parseInt(timeInput.getText().toString());

        if (time < 10) {
            resultTextView.setText("Good morning.");
        } else if (time < 13) {
            resultTextView.setText("Good day.");
        } else if (time < 16) {
            resultTextView.setText("Good after noon.");
        } else if (time < 20) {
            resultTextView.setText("Good evening.");
        } else if (time <= 24) {
            resultTextView.setText("Good night.");
        } else checkTime.setEnabled(false);
    }
}