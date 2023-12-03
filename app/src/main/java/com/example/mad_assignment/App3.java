package com.example.mad_assignment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class App3 extends AppCompatActivity {

    private EditText unitsConsumedTxt;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app3);

        unitsConsumedTxt = findViewById(R.id.unitsConsumedTxt);
        calculateBtn = findViewById(R.id.calculateBtn);

        unitsConsumedTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Enable or disable the button based on input validation
                calculateBtn.setEnabled(!editable.toString().trim().isEmpty());
            }
        });

        calculateBtn.setOnClickListener(view -> calculateBill());
    }
    private void calculateBill() {
        String unitsConsumedStr = unitsConsumedTxt.getText().toString().trim();

        if (unitsConsumedStr.isEmpty()) {
            unitsConsumedTxt.setError("Please enter units consumed");
            return;
        }

        int unitsConsumed = Integer.parseInt(unitsConsumedStr);
        double costPerUnit = (unitsConsumed <= 200) ? 3.0 : 5.0;
        double totalBill = unitsConsumed * costPerUnit;

        Toast.makeText(this, "Total units consumed are " + unitsConsumed +
                " @ Rs." + costPerUnit + " per unit and total bill is: " + totalBill, Toast.LENGTH_LONG).show();
    }
}
