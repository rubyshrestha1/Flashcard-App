package com.example.codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ((ImageView) findViewById(R.id.cross)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

            });
        ((Button) findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question= ((EditText)findViewById(R.id.userQuestion)).getText().toString();
                String answer=  ((EditText)findViewById(R.id.userAnswer)).getText().toString();
                String wrong1=  ((EditText)findViewById(R.id.wrongAnswer1)).getText().toString();
                String wrong2=  ((EditText)findViewById(R.id.wrongAnswer2)).getText().toString();
                if ( question.equals("")  || answer.equals(""))
                    Toast.makeText(getApplicationContext(), "Must enter both question and answer", Toast.LENGTH_SHORT).show();
                else {
                    Intent data = new Intent();
                    data.putExtra("question", question);
                    data.putExtra("answer", answer);
                    data.putExtra("wrong1", wrong1);
                    data.putExtra("wrong2", wrong2);
                    setResult(RESULT_OK, data);
                    finish();
                }

            }
        });
        String question = getIntent().getStringExtra("question");
        String answer= getIntent().getStringExtra("answer");
        ((EditText) findViewById(R.id.userQuestion)).setText(question);
        ((EditText) findViewById(R.id.userAnswer)).setText(answer);











    }
}