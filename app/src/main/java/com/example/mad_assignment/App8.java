package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class App8 extends AppCompatActivity {
    Toolbar toolbar;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app8);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onLogin(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (attempts < 3) {
            String correctUsername = "user";
            String correctPassword = "pass";
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                attempts = 0;
            } else if (username.equals(correctUsername)) {
                Toast.makeText(this, "Incorrect PASSWORD, Try again.", Toast.LENGTH_SHORT).show();
                attempts++;
            } else {
                Toast.makeText(this, "Incorrect Login Details, Try again", Toast.LENGTH_SHORT).show();
                attempts++;
            }
        } else {
            finish();
        }
    }
}