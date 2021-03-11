package com.example.codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

                Intent data= new Intent();
                data.putExtra("question",question);
                data.putExtra("answer",  answer);
                setResult(RESULT_OK, data);
                finish();

            }
        });



    }
}