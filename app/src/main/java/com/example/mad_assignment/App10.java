package com.example.mad_assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class App10 extends AppCompatActivity {
    EditText fruitEditText, quantityEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app10);

        fruitEditText = findViewById(R.id.fruitEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setEnabled(false);

        fruitEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        calculateButton.setOnClickListener(v -> calculateBill());
    }

    private void validateInputs() {
        String fruit = fruitEditText.getText().toString().trim();
        String quantity = quantityEditText.getText().toString().trim();

        boolean isValid = !fruit.isEmpty() && !quantity.isEmpty();

        calculateButton.setEnabled(isValid);
    }

    @SuppressLint("SetTextI18n")
    private void calculateBill() {
        String fruit = fruitEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());

        int pricePerDozen;
        int discountPrice;

        switch (fruit.toLowerCase()) {
            case "s":
                pricePerDozen = 120;
                discountPrice = 100;
                break;
            case "b":
                pricePerDozen = 100;
                discountPrice = 80;
                break;
            case "o":
                pricePerDozen = 200;
                discountPrice = 150;
                break;
            default:
                resultTextView.setText("Invalid fruit selection");
                return;
        }

        int dozens = quantity / 12;
        int remainder = quantity % 12;

        int totalPrice = dozens * discountPrice + remainder * (pricePerDozen / 12);

        String resultText = "Fruit Name: ";
        switch (fruit.toLowerCase()) {
            case "s":
                resultText += "Sweet Lemon";
                break;
            case "b":
                resultText += "Banana";
                break;
            case "o":
                resultText += "Orange";
                break;
        }

        resultText += "\nNo of Dozens: " + dozens +
                "\nTotal Bill: Rs." + totalPrice;

        resultTextView.setText(resultText);
    }
}