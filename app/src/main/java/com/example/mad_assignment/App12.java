package com.example.mad_assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class App12 extends AppCompatActivity {
    Toolbar toolbar;
    TextView timerTextView,signalTextView;
    ImageView vehicleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app12);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        timerTextView = findViewById(R.id.timerTextView);
        vehicleImageView = findViewById(R.id.vehicleImageView);
        signalTextView = findViewById(R.id.signalTextView);

        startTimer();
    }

    private void startTimer() {
        new CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;

                timerTextView.setText("Timer: " + seconds + "s");

                if (seconds == 35) {
                    setTrafficSignal("vehicle is ready to drive.");
                    setVehicleImage(R.drawable.orange_light);
                } else if (seconds == 45) {
                    setTrafficSignal("vehicle drive smoothly.");
                    setVehicleImage(R.drawable.green_light);
                }
            }

            public void onFinish() {
                setTrafficSignal("vehicle stopped");
                setVehicleImage(R.drawable.red_light);
            }
        }.start();
    }

    @SuppressLint("SetTextI18n")
    private void setTrafficSignal(String signal) {
        signalTextView.setText("Signal: " + signal);
    }

    private void setVehicleImage(int resourceId) {
        vehicleImageView.setImageResource(resourceId);
    }
}
