package com.example.fingerspeedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Variables for interface objects
    private TextView timerTextView;
    private TextView oneThousandTextView;
    private Button tapButton;
    private CountDownTimer countDownTimer;

//Variables for Timer object
    private long initialCountdownInMillis = 60000;
    private int timerInterval = 1000;
    private int remainingTime = 60;
    private int oneThousand = 1000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.txtTimer);
        oneThousandTextView = findViewById(R.id.txtOneThousand);
        tapButton = findViewById(R.id.btnTap);

        oneThousandTextView.setText(oneThousand + "");

//Listener for button click decrement
        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            oneThousand--;
            oneThousandTextView.setText(oneThousand + "");

            if (remainingTime > 0 && oneThousand <= 0) {

                Toast.makeText(MainActivity.this, "Congratulations", Toast.LENGTH_SHORT).show();

            }
        }

//Auto countdown timer
        countDownTimer = new CountDownTimer(initialCountdownInMillis, timerInterval) {
            @Override
            public void onTick(long millisUntilFinished) {

                remainingTime = (int) millisUntilFinished / timerInterval;
                timerTextView.setText(remainingTime + "");

            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Countdown finished", Toast.LENGTH_SHORT).show();

            }
        }

//Countdown timer start method
        countDownTimer.start();

    });
}