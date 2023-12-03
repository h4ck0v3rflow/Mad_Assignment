package com.example.mad_assignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class App2 extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app2);

        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            String input = editText.getText().toString().trim();

            if (input.isEmpty() || input.equals(".")) {
                editText.setError("Field cannot be empty");
                return;
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(App2.this, "Please select an option", Toast.LENGTH_SHORT).show();
                return;
            }

            double inputValue = Double.parseDouble(input);
            String output = "";

            if (selectedId == R.id.radioButton1) {
                output = "Celsius Temperature is " + inputValue + " C is equal to " + (inputValue + 273.15) + " K";
            } else if (selectedId == R.id.radioButton2) {
                output = "Fahrenheit Temperature is " + inputValue + " F is equal to " + ((inputValue - 32) * 5 / 9 + 273.15) + " K";
            } else if (selectedId == R.id.radioButton3) {
                output = "Kelvin Temperature is " + inputValue + " K is equal to " + (inputValue - 273.15) + " C";
            } else if (selectedId == R.id.radioButton4) {
                output = "Kelvin Temperature is " + inputValue + " K is equal to " + ((inputValue * 9 / 5) + 32) + " F";
            } else if (selectedId == R.id.radioButton5) {
                output = "Celsius Temperature is " + inputValue + " C is equal to " + ((inputValue * 9 / 5) + 32) + " F";
            }

            textView.setText(output);
        });
    }
}
