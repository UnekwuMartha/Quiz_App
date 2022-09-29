//A quiz app educating users about Africa.
//Contains four questions

package com.example.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    EditText question1Input;
    EditText question2Input;
    EditText question3Input;
    EditText question4Input;
    CheckBox nigerCheckbox;
    CheckBox darkSeaCheckbox;
    CheckBox zambeziCheckbox;
    CheckBox beninCheckbox;
    RadioGroup radioGroup;
    RadioButton radioButton;
    //List to hold scores
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button finalScoreButton = (Button) findViewById(R.id.final_score_button);
        finalScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScore();
            }
        });
    }

    //To display overall score
    public void displayFinalScore(String message) {
        TextView finalScoreText = findViewById(R.id.final_score_text);
        if (message.equalsIgnoreCase("Do better Next Time!!! Your Total Score is: " + counter)) {
            finalScoreText.setTextColor(Color.RED);
        } else {
            finalScoreText.setTextColor(Color.GREEN);
        }
        finalScoreText.setText(message);
    }

//To check overall score and display

    public void setScore() {
        //To check answer input 1 against correct answer
        question1Input = findViewById(R.id.question_1_input);
        if (question1Input.getText().toString().equalsIgnoreCase("James Munroe")) {
            counter++;
        }

        //To check answer input 2 by user against correct answer
        question2Input = findViewById(R.id.question_2_input);
        if (question2Input.getText().toString().equalsIgnoreCase("Sudan")) counter++;

        //To check answer input 3 for question 3 against correct answer
        question3Input = findViewById(R.id.question_3_input);
        if (question3Input.getText().toString().equalsIgnoreCase("Orange Free State and Transvaal")) {
            counter++;
        }

        //To check answer input 4 for question 4 against correct answer
        question4Input = findViewById(R.id.question_4_input);
        if (question4Input.getText().toString().equalsIgnoreCase("Ethiopia")) {
            counter++;
        }

        //To check checkbox answer against correct answer
        // Select niger_checkbox
        nigerCheckbox = findViewById(R.id.niger_checkbox);

        // If Select dark_sea_checkbox
        darkSeaCheckbox = findViewById(R.id.dark_sea_checkbox);

        // If Select zambezi_checkbox
        zambeziCheckbox = findViewById(R.id.zambezi_checkbox);

        // If Select benin_checkbox
        beninCheckbox = findViewById(R.id.benin_checkbox);

        // Check correct answer
        try {
            if (nigerCheckbox.isChecked() && zambeziCheckbox.isChecked() && !beninCheckbox.isChecked() && !darkSeaCheckbox.isChecked()) {
                counter++;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please, select a checkbox in question 6", Toast.LENGTH_LONG).show();
        }

        //To check answer input for Radio Button against correct answer
        radioGroup = findViewById(R.id.radio_group);
        int selectedID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedID);

        try {
            if (radioButton.getText().toString().equalsIgnoreCase("Nigeria")) {
                counter++;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please, select a radio button in question 5", Toast.LENGTH_LONG).show();
        }

        //Calculate Total Score

        if (counter == 6) {
            displayFinalScore("Genius!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "Genius!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        } else if (counter == 5) {
            displayFinalScore("You're on roll!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "You're on roll!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        } else if (counter == 4) {
            displayFinalScore("Brilliant!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "Brilliant!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        } else if (counter == 3) {
            displayFinalScore("Great!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "Great!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        } else if (counter == 2) {
            displayFinalScore("Good!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "Good!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        } else {
            displayFinalScore("Do better Next Time!!! Your Total Score is: " + counter);
            Toast.makeText(getApplicationContext(), "Do Better Next Time!!! Your Total Score is: " + counter, Toast.LENGTH_SHORT).show();
        }
        counter = 0;
    }


}