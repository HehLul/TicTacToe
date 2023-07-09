package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Initialize button views
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;//ALL BUTTONS in grid
    Button btnNext;
    int state = 0;
    int moves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        //Initialize btn ID
        //set up click listener
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        //NEXT activity button initialized
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

    }


    //When mouse click button
    @Override
    public void onClick(View v) {
        //if NEXT clicked, change activity
        if(v.getId() == R.id.btnNext){
            Intent iNext;
            iNext = new Intent(MainActivity.this, Second_Activity.class);//set iNext to next activity
            startActivity(iNext);//Execute activity
        }

        //Update text of button that has been pressed
        else if (v.getId() == R.id.btn1) {
            setText(btn1);
        } else if (v.getId() == R.id.btn2) {
            setText(btn2);
        } else if (v.getId() == R.id.btn3) {
            setText(btn3);
        } else if (v.getId() == R.id.btn4) {
            setText(btn4);
        } else if (v.getId() == R.id.btn5) {
            setText(btn5);
        } else if (v.getId() == R.id.btn6) {
            setText(btn6);
        } else if (v.getId() == R.id.btn7) {
            setText(btn7);
        } else if (v.getId() == R.id.btn8) {
            setText(btn8);
        } else if (v.getId() == R.id.btn9) {
            setText(btn9);
        }

        //store the state of button in string to easily compare them
        String btn1Val = btn1.getText().toString();
        String btn2Val = btn2.getText().toString();
        String btn3Val = btn3.getText().toString();
        String btn4Val = btn4.getText().toString();
        String btn5Val = btn5.getText().toString();
        String btn6Val = btn6.getText().toString();
        String btn7Val = btn7.getText().toString();
        String btn8Val = btn8.getText().toString();
        String btn9Val = btn9.getText().toString();


        //Conditions:
        //1, 2, 3 OR 4, 5, 6 OR 7, 8, 9
        //1,4,7 OR 2,5,8 OR 3,6,9
        //1,5,9 or 3,5,7

        //horizontal win conditions
        if (btn1Val.equals(btn2Val) && btn2Val.equals(btn3Val) && !btn1Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn1Val, Toast.LENGTH_LONG).show();
            resetGame(); //resets all button values to EMPTY, move count=0, reset state
        } else if (btn4Val.equals(btn5Val) && btn5Val.equals(btn6Val) && !btn4Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn4Val, Toast.LENGTH_LONG).show();
            resetGame();
        } else if (btn7Val.equals(btn8Val) && btn8Val.equals(btn9Val) && !btn7Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn7Val, Toast.LENGTH_LONG).show();
            resetGame();
        }
        //vertical win conditions
        else if (btn1Val.equals(btn4Val) && btn4Val.equals(btn7Val) && !btn1Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn1Val, Toast.LENGTH_LONG).show();
            resetGame();
        } else if (btn2Val.equals(btn5Val) && btn5Val.equals(btn8Val) && !btn2Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn2Val, Toast.LENGTH_LONG).show();
            resetGame();
        } else if (btn3Val.equals(btn6Val) && btn6Val.equals(btn9Val) && !btn3Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn3Val, Toast.LENGTH_LONG).show();
            resetGame();
        }
        //cross win conditions
        else if (btn1Val.equals(btn5Val) && btn5Val.equals(btn9Val) && !btn1Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn1Val, Toast.LENGTH_LONG).show();
            resetGame();
        } else if (btn3Val.equals(btn5Val) && btn5Val.equals(btn7Val) && !btn3Val.equals("")) {
            Toast.makeText(this, "Winner is " + btn3Val, Toast.LENGTH_LONG).show();
            resetGame();
        }

        //if ALL 9 moves done and NO WINNER == DRAW
        if(moves==9){
            Toast.makeText(this, "DRAW!", Toast.LENGTH_LONG).show();
            resetGame();//reset buttons and moves count
        }


        //method to toggle state, either X or O
    }



    private void setText(Button btn) {

        if (btn.getText().toString().equals("")) {//if button NOT toggled yet
            if (state == 0) {
                btn.setText("0");
                moves++;
                state = 1;
            } else {
                btn.setText("X");
                moves++;
                state = 0;
            }
        }
    }

    private void resetGame() {
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              //reset button values
              btn1.setText("");
              btn2.setText("");
              btn3.setText("");
              btn4.setText("");
              btn5.setText("");
              btn6.setText("");
              btn7.setText("");
              btn8.setText("");
              btn9.setText("");

              moves = 0;//reset num of moves and state
              state = 0;
          }
      }, 1000);//1 SECOND DELAY


    }





}



