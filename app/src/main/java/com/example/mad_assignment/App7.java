package com.example.mad_assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class App7 extends AppCompatActivity {

    EditText gpaInput;
    Button checkGPA;
    TextView resultText;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app7);

        gpaInput = findViewById(R.id.gpaInput);
        checkGPA = findViewById(R.id.checkGPA);
        resultText = findViewById(R.id.resultText);
        resultImage = findViewById(R.id.resultImage);

        checkGPA.setOnClickListener(v -> checkGPACriteria());
    }

    @SuppressLint("SetTextI18n")
    private void checkGPACriteria() {
        if (gpaInput.getText().toString().isEmpty() || gpaInput.getText().toString().equals(".")) {
            gpaInput.setError("GPA can't be empty");
            return;
        }
        double gpa = Double.parseDouble(gpaInput.getText().toString());

        if (gpa == 3.5) {
            resultText.setText("Admission granted due to equal GPA");
            resultImage.setImageResource(R.drawable.admission_granted);
        } else if (gpa > 3.5) {
            resultText.setText("Well done! You are qualified for scholarship as per university rules");
            resultImage.setImageResource(R.drawable.qualified_for_scholarship);
        } else {
            resultText.setText("Sorry No Admission granted due to low GPA");
            resultImage.setImageResource(R.drawable.no_admission);
        }
    }
}