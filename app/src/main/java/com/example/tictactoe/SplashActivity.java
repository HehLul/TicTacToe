package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
//VARIABLE
TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


            //ANIMATION OF TEXT
            splashText = findViewById(R.id.splashText);//text id
            Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);//load move file animation
            splashText.startAnimation(move);//execute animation, can use startAnimation


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome;
                iHome = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(iHome);//Execute main activity intent

                finish(); //POP FROM STACK, CANT GO BACK
            }
        }, 4000);//5 SECOND DELAY

    }
}