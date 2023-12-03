package com.example.mad_assignment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class App9 extends AppCompatActivity {
    EditText heightInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app9);

        heightInput = findViewById(R.id.heightInput);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            if (heightInput.getText().toString().equals("")) {
                Toast.makeText(App9.this, "Please enter your height", Toast.LENGTH_SHORT).show();
            } else {
                double height = Double.parseDouble(heightInput.getText().toString());
                showResult(height);
            }
        });

        heightInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                submitButton.setEnabled(!s.toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void showResult(double height) {
        String category;
        if (height < 155) {
            category = "is Dwarf";
        } else if (height >= 155 && height <= 170) {
            category = "has an Average Height";
        } else if (height >= 171 && height <= 200) {
            category = "is Taller";
        } else {
            category = "has an Abnormal Height";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Categories of the Person");
        builder.setMessage("Height of a person = " + height + "\n\nThe person " + category);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
