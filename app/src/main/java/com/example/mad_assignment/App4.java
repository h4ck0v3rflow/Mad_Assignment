package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class App4 extends AppCompatActivity {

    private EditText TxtBasicSalary;
    private TextView txtResultNetSalary;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app4);

        TxtBasicSalary = findViewById(R.id.TxtBasicSalary);
        txtResultNetSalary = findViewById(R.id.txtResultNetSalary);
        btnCalculate = findViewById(R.id.btnCalculate);

        TxtBasicSalary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnCalculate.setEnabled(!s.toString().trim().isEmpty());
                TxtBasicSalary.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btnCalculate.setOnClickListener(v -> {
            String basicSalaryStr = TxtBasicSalary.getText().toString().trim();

            if (basicSalaryStr.isEmpty()) {
                TxtBasicSalary.setError("Please enter basic salary");
                return;
            }

            double basicSalary = Double.parseDouble(TxtBasicSalary.getText().toString());
            double netSalary = calculateNetSalary(basicSalary);

            double houseRentAllowance, dailyAllowance;

            if (basicSalary < 15000) {
                houseRentAllowance = 0.1 * basicSalary;
                dailyAllowance = 1000;
            } else {
                houseRentAllowance = 0.2 * basicSalary;
                dailyAllowance = 2000;
            }

            String resultText = "Basic Salary = " + basicSalary +
                    "\nHouse Rent is = " + houseRentAllowance +
                    "\nDaily Allowance = " + dailyAllowance +
                    "\nNet Salary = " + netSalary;

            txtResultNetSalary.setText(resultText);
        });
    }

    private double calculateNetSalary(double basicSalary) {
        double houseRentAllowance, dailyAllowance;

        if (basicSalary < 15000) {
            houseRentAllowance = 0.1 * basicSalary;
            dailyAllowance = 1000;
        } else {
            houseRentAllowance = 0.2 * basicSalary;
            dailyAllowance = 2000;
        }

        return basicSalary + houseRentAllowance + dailyAllowance;
    }
}
