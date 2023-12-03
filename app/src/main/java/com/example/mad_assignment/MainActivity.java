package com.example.mad_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button app1, app2, app3, app4, app5, app6, app7, app8, app9, app10, app11, app12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        app1 = findViewById(R.id.btn1);
        app2 = findViewById(R.id.btn2);
        app3 = findViewById(R.id.btn3);
        app4 = findViewById(R.id.btn4);
        app5 = findViewById(R.id.btn5);
        app6 = findViewById(R.id.btn6);
        app7 = findViewById(R.id.btn7);
        app8 = findViewById(R.id.btn8);
        app9 = findViewById(R.id.btn9);
        app10 = findViewById(R.id.btn10);
        app11 = findViewById(R.id.btn11);
        app12 = findViewById(R.id.btn12);

        app1.setOnClickListener(v -> {
            Intent intent = new Intent(this, App1.class);
            startActivity(intent);
        });

        app2.setOnClickListener(v -> {
            Intent intent = new Intent(this, App2.class);
            startActivity(intent);
        });

        app3.setOnClickListener(v -> {
            Intent intent = new Intent(this, App3.class);
            startActivity(intent);
        });

        app4.setOnClickListener(v -> {
            Intent intent = new Intent(this, App4.class);
            startActivity(intent);
        });

        app5.setOnClickListener(v -> {
            Intent intent = new Intent(this, App5.class);
            startActivity(intent);
        });

        app6.setOnClickListener(v -> {
            Intent intent = new Intent(this, App6.class);
            startActivity(intent);
        });

        app7.setOnClickListener(v -> {
            Intent intent = new Intent(this, App7.class);
            startActivity(intent);
        });

        app8.setOnClickListener(v -> {
            Intent intent = new Intent(this, App8.class);
            startActivity(intent);
        });

        app9.setOnClickListener(v -> {
            Intent intent = new Intent(this, App9.class);
            startActivity(intent);
        });

        app10.setOnClickListener(v -> {
            Intent intent = new Intent(this, App10.class);
            startActivity(intent);
        });

        app11.setOnClickListener(v -> {
            Intent intent = new Intent(this, App11.class);
            startActivity(intent);
        });

        app12.setOnClickListener(v -> {
            Intent intent = new Intent(this, App12.class);
            startActivity(intent);
        });
    }
}