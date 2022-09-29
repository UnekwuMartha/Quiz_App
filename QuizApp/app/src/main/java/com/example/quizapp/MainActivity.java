//A quiz app educating users about Africa.
//Contains four questions

package com.example.quizapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//Declaring global variables
    EditText mEdit1;
    EditText mEdit2;
    EditText mEdit3;
    EditText mEdit4;

//List to hold scores
    List <String> scoreList = new ArrayList<String>();

//To check answer input against correct answer
    public void checkAnswer1(View view){
        mEdit1   = (EditText)findViewById(R.id.text_input_1);
        if(mEdit1.getText().toString().equals("James Munroe")){
            Toast.makeText(getApplicationContext(),  "Correct", Toast.LENGTH_LONG).show();
            scoreList.add("Correct");
        } else {
            Toast.makeText(getApplicationContext(),  "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

//To check answer input by user against correct answer
    public void checkAnswer2(View view){
        mEdit2   = (EditText)findViewById(R.id.text_input_2);
        if(mEdit2.getText().toString().equals("Sudan")){
            Toast.makeText(getApplicationContext(),  "Correct", Toast.LENGTH_LONG).show();
            scoreList.add("Correct");
        } else {
            Toast.makeText(getApplicationContext(),  "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

//To check answer input for question 3 against correct answer
    public void checkAnswer3(View view){
        mEdit3   = (EditText)findViewById(R.id.text_input_3);
        if(mEdit3.getText().toString().equals("Orange Free State and Transvaal")){
            Toast.makeText(getApplicationContext(),  "Correct", Toast.LENGTH_LONG).show();
            scoreList.add("Correct");
        } else {
            Toast.makeText(getApplicationContext(),  "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

//To check answer input for question 4 against correct answer
    public void checkAnswer4(View view){
        mEdit4   = (EditText)findViewById(R.id.text_input_4);
        if(mEdit4.getText().toString().equals("Ethiopia")){
            Toast.makeText(getApplicationContext(),  "Correct", Toast.LENGTH_LONG).show();
            scoreList.add("Correct");
        } else {
            Toast.makeText(getApplicationContext(),  "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

//To check answer input for checkbox against correct answer
    public void onCheckBoxClicked(View view) {
        // If true was clicked
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        boolean trueClicked = checkBox1.isChecked();

        // If false was clicked
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_2);
        boolean falseClicked = checkBox2.isChecked();

        if(trueClicked){
            Toast.makeText(getApplicationContext(),  "Correct", Toast.LENGTH_LONG).show();
            scoreList.add("Correct");
        } else if(falseClicked){
            Toast.makeText(getApplicationContext(),  "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

//To check answer input for Radio Button against correct answer
    public void onRadioButtonClicked(View view) {
        // If radio 1 was clicked
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(),  "Select an answer Please", Toast.LENGTH_LONG).show();
        } else {
            RadioButton radio1 = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            String answer = radio1.getText().toString();
            if(answer.equalsIgnoreCase("Nigeria")){
                Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                scoreList.add("Correct");
            } else {
                Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
            }
        }

    }

//To display overall score
    public void displayMessage5(String message) {
        TextView answer5 = (TextView) findViewById(R.id.answer_5);
        if(message.equals("Do better Next Time!!! Your Total Score is: " + scoreList.size())){
            answer5.setTextColor(Color.RED);
        } else {
            answer5.setTextColor(Color.GREEN);
        }
        answer5.setText(message);
    }

//To check overall score and display
    public int totalScore(List<String> scoreList){
        return scoreList.size();
    }

    public void setScore(View view){
        totalScore(scoreList);
        if (scoreList.size() == 6) {
            displayMessage5("Genius!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(), "Genius!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        }
        else if (scoreList.size() == 5) {
            displayMessage5("You're on roll!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(), "You're on roll!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        }
        else if (scoreList.size() == 4){
            displayMessage5("Brilliant!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(),  "Brilliant!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        } else if(scoreList.size() == 3) {
            displayMessage5("Great!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(),  "Great!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        } else if(scoreList.size() == 2) {
            displayMessage5("Good!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(),  "Good!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        } else {
            displayMessage5("Do better Next Time!!! Your Total Score is: " + scoreList.size());
            Toast.makeText(getApplicationContext(),  "Do Better Next Time!!! Your Total Score is: " + scoreList.size(), Toast.LENGTH_SHORT).show();
        }
    }
}