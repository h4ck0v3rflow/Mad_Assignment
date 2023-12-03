package com.example.mad_assignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class App5 extends AppCompatActivity {

    private EditText hoursWorkedTxt;
    private TextView totalSalaryTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app5);

        hoursWorkedTxt = findViewById(R.id.hoursWorkedTxt);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        totalSalaryTxt = findViewById(R.id.totalSalaryTxt);

        btnCalculate.setOnClickListener(v -> calculateTotalSalary());
    }

    private void calculateTotalSalary() {
        if (hoursWorkedTxt.getText().toString().isEmpty()) {
            hoursWorkedTxt.setError("Field cannot be empty");
            return;
        }

        int hoursWorked = Integer.parseInt(hoursWorkedTxt.getText().toString());
        int dailyWage = 50;
        int extraHoursWageRate = 10;
        int[] extraHoursThresholds = {8, 12, 16, 20};
        int totalSalary;

        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("Total Hours of employee = ").append(hoursWorked).append("\n");
        resultBuilder.append("Daily Eight-hour wage is = ").append(dailyWage * 8).append("\n");

        for (int i = 0; i < extraHoursThresholds.length; i++) {
            if (hoursWorked <= extraHoursThresholds[i]) {
                int extraHours = hoursWorked - 8 * i;
                resultBuilder.append("Extra ").append(extraHours).append(" hours’ wage is = ").append(extraHours * extraHoursWageRate).append("\n");
                break;
            }
        }

        totalSalary = calculateTotalSalary(hoursWorked);
        resultBuilder.append("Total Salary is = ").append(totalSalary);

        totalSalaryTxt.setText(resultBuilder.toString());
    }

    private int calculateTotalSalary(int hoursWorked) {
        int totalSalary = 0;

        for (int i = 0; i < 5; i++) {
            if (hoursWorked <= 8 * (i + 1)) {
                totalSalary = 50 * 8 * i + 10 * (hoursWorked - 8 * i);
                break;
            }
        }

        return totalSalary;
    }
}