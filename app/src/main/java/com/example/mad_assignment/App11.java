package com.example.mad_assignment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class App11 extends AppCompatActivity {
    EditText ageEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app11);

        ageEditText = findViewById(R.id.ageEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setEnabled(false);

        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateInput();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        calculateButton.setOnClickListener(v -> calculateAndDisplayResult());
    }

    private void validateInput() {
        String ageString = ageEditText.getText().toString().trim();
        boolean isValid = !ageString.isEmpty();

        calculateButton.setEnabled(isValid);
    }

    private void calculateAndDisplayResult() {
        int age = Integer.parseInt(ageEditText.getText().toString().trim());

        String message;
        if (age > 60) {
            message = "You are really old";
        } else if (age > 35) {
            message = "You are young";
        } else if (age == 18) {
            message = "You are pretty young!";
        } else {
            message = "Grow up my dear";
        }

        int months = age * 12;
        int days = age * 365;

        String resultText = "User Age: " + age +
                "\nNo of Months: " + months +
                "\nNo of Days: " + days +
                "\nMessage: " + message;

        resultTextView.setText(resultText);
    }
}