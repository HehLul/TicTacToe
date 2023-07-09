package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome;
                iHome = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(iHome);//Execute main activity intent

                finish(); //POP FROM STACK, CANT GO BACK
            }
        }, 3000);//3 SECOND DELAY

    }
}