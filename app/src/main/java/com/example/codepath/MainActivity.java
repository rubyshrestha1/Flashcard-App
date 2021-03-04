package com.example.codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView questionTextView = findViewById(R.id.Question1);
        TextView answerTextView = findViewById(R.id.Answer1);
        TextView option1TextView = findViewById(R.id.Option1);
        TextView option2TextView = findViewById(R.id.Option2);
        TextView option3TextView = findViewById(R.id.Option3);


        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionTextView.setVisibility(View.INVISIBLE);
                answerTextView.setVisibility(View.VISIBLE);
            }

        });
        answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setVisibility(View.INVISIBLE);
                questionTextView.setVisibility(View.VISIBLE);

            }
        });

        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.Option1).setBackgroundColor(getResources().getColor(R.color.optionBackground));
                findViewById(R.id.Option2).setBackgroundColor(getResources().getColor(R.color.optionBackground));
                findViewById(R.id.Option3).setBackgroundColor(getResources().getColor(R.color.optionBackground));
            }
        });

        String answer= "Third Monday of January";
        option1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option1TextView.getText().equals(answer)){
                    option1TextView.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else{
                    option1TextView.setBackgroundColor(getResources().getColor(R.color.red));
                }

            }
        });

        option2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option2TextView.getText().equals(answer)){
                    option2TextView.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else{
                    option2TextView.setBackgroundColor(getResources().getColor(R.color.red));
                }

            }
        });

        option3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option3TextView.getText().equals(answer)){
                    option3TextView.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else{
                    option3TextView.setBackgroundColor(getResources().getColor(R.color.red));
                }

            }
        });
    }


}