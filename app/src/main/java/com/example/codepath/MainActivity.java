package com.example.codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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

        String answer= (String) answerTextView.getText();
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


        ((ImageView) findViewById(R.id.plus)).setImageResource(R.drawable.plus);

        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCard.class);
                startActivityForResult(intent,100);

            }
        });

        ((ImageView) findViewById(R.id.edit)).setImageResource(R.drawable.edit);

        findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question= ((TextView)findViewById(R.id.Question1)).getText().toString();
                String answer=  ((TextView)findViewById(R.id.Answer1)).getText().toString();
                Intent data = new Intent(MainActivity.this, AddCard.class);
                data.putExtra("question",question);
                data.putExtra("answer", answer);
                startActivityForResult(data, 100);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode==RESULT_OK && data!=null) {
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");
            String wrong1= data.getExtras().getString("wrong1");
            String wrong2= data.getExtras().getString("wrong2");
            ((TextView) findViewById(R.id.Question1)).setText(question);
            ((TextView) findViewById(R.id.Answer1)).setText(answer);
            ((TextView)findViewById(R.id.Option1)).setText(answer);
            ((TextView)findViewById(R.id.Option2)).setText(wrong1);
            ((TextView)findViewById(R.id.Option3)).setText(wrong2);


        }

        Snackbar.make(findViewById(R.id.Question1), "Card successfully created", Snackbar.LENGTH_SHORT)
                .show();
    }


}