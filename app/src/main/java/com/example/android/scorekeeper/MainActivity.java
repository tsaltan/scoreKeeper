package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

        final LinearLayout linearLayoutTeamAContainer = findViewById(R.id.linear_layout_team_a_container);
        final LinearLayout linearLayoutTeamBContainer = findViewById(R.id.linear_layout_team_b_container);

        final TextView textViewTeamNameA = linearLayoutTeamAContainer.findViewById(R.id.text_view_team_name);
        textViewTeamNameA.setText(R.string.team_a);
        final TextView textViewTeamNameB = linearLayoutTeamBContainer.findViewById(R.id.text_view_team_name);
        textViewTeamNameB.setText(R.string.team_b);

        scoreTextA = linearLayoutTeamAContainer.findViewById(R.id.scoreText);
        scoreTextA.setText(R.string.default_score_and_fault_value);
        scoreTextB = linearLayoutTeamBContainer.findViewById(R.id.scoreText);
        scoreTextB.setText(R.string.default_score_and_fault_value);
        faultTextA = linearLayoutTeamAContainer.findViewById(R.id.faultsText);
        faultTextA.setText(R.string.default_score_and_fault_value);
        faultTextB = linearLayoutTeamBContainer.findViewById(R.id.faultsText);
        faultTextB.setText(R.string.default_score_and_fault_value);

        final Button buttonFaultA = linearLayoutTeamAContainer.findViewById(R.id.button_fault);
        final Button buttonFaultB = linearLayoutTeamBContainer.findViewById(R.id.button_fault);
        final Button buttonScoreA = linearLayoutTeamAContainer.findViewById(R.id.button_score);
        final Button buttonScoreB = linearLayoutTeamBContainer.findViewById(R.id.button_score);

        buttonFaultA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faultA(v);
            }
        });

        buttonFaultB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faultB(v);
            }
        });

        buttonScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA(v);
            }
        });

        buttonScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB(v);
            }
        });
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
