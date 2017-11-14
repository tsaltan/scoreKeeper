package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Team teamA = new Team();
    Team teamB = new Team();
    TextView scoreTextA;
    TextView scoreTextB;
    TextView faultTextA;
    TextView faultTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextA = findViewById(R.id.scoreTextA);
        scoreTextB = findViewById(R.id.scoreTextB);
        faultTextA = findViewById(R.id.faultsTextA);
        faultTextB = findViewById(R.id.faultsTextB);
    }

    public void maketoast(String message) {
        Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();

    }

    class Team {

        int score = 0;
        int fault = 0;


        public void resetValues() {
            score = 0;
            fault = 0;
        }

        public void updateScore() {
            score++;
        }

        public void updateFault() {
            fault++;
        }

    }

    public void scoreA(View view) {
        teamA.updateScore();
        setText("scoreA");
    }

    public void faultA(View view) {
        teamA.updateFault();
        setText("faultA");
    }

    public void scoreB(View view) {
        teamB.updateScore();
        setText("scoreB");


    }

    public void faultB(View view) {
        teamB.updateFault();
        setText("faultB");

    }

    public void resetAll(View view) {


        if (teamA.score > teamB.score) {
            maketoast("Team A Wins!");
        } else if (teamA.score == teamB.score) {
            maketoast("its a tie!");
        } else {
            maketoast("Team B Wins!");
        }

        teamA.resetValues();
        teamB.resetValues();
        setText("scoreA");
        setText("faultA");
        setText("scoreB");
        setText("faultB");

    }

    public void setText(String action) {
        switch (action) {
            case "scoreA":
                scoreTextA.setText(String.valueOf(teamA.score));
                break;
            case "faultA":
                faultTextA.setText(String.valueOf(teamA.fault));
                break;
            case "scoreB":
                scoreTextB.setText(String.valueOf(teamB.score));
                break;
            case "faultB":
                faultTextB.setText(String.valueOf(teamB.fault));
                break;
        }


    }

}
