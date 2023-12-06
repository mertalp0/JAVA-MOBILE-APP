package com.example.javavize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class RandomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_view);

        Button backButton = findViewById(R.id.buttonBackRandom);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RandomView.this , MainActivity.class);
                startActivity(intent);
            }
        });
        Button createButton = findViewById(R.id.buttonCreate);
        EditText countTextField = findViewById(R.id.countTextField);
        EditText minTextField = findViewById(R.id.minTextField);
        EditText maxTextField = findViewById(R.id.maxTextField);

        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout scrollLinearLayout = new LinearLayout(this);
        scrollLinearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(scrollLinearLayout);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String countString = countTextField.getText().toString();
                int countInt = Integer.parseInt(countString);
                String maxValueString = maxTextField.getText().toString();
                int maxValueInt = Integer.parseInt(maxValueString);

                String minValueString = minTextField.getText().toString();
                int minValueInt = Integer.parseInt(minValueString);

                Random rnd =new Random();


            for(int i = 0  ; i < countInt ; i++){


                LinearLayout columnFirst = new LinearLayout(RandomView.this);
                LinearLayout rowFirst = new LinearLayout(RandomView.this);
                LinearLayout rowSecond = new LinearLayout(RandomView.this);

                columnFirst.setOrientation(LinearLayout.VERTICAL);
                rowFirst.setOrientation(LinearLayout.HORIZONTAL);
                rowSecond.setOrientation(LinearLayout.HORIZONTAL);

                TextView randomNumberTextView = new TextView(RandomView.this);
                TextView minValueTextView = new TextView(RandomView.this);
                TextView maxValueTextView = new TextView(RandomView.this);

                ProgressBar progressBar = new ProgressBar(RandomView.this , null , android.R.attr.progressBarStyleHorizontal );

                int firstRandomNumber = rnd.nextInt(maxValueInt-minValueInt +1 ) + minValueInt;
                int secondRandomNumber = rnd.nextInt(maxValueInt-minValueInt +1 ) + minValueInt;


                int maxValue ;
                int minValue;
                if(firstRandomNumber>secondRandomNumber){
                    maxValue =firstRandomNumber;
                    minValue = secondRandomNumber;
                }
                else if (firstRandomNumber<secondRandomNumber){
                    maxValue=secondRandomNumber;
                    minValue=firstRandomNumber;
                }else {
                    minValue=secondRandomNumber;
                    maxValue=secondRandomNumber;
                }

                int randomNumber = rnd.nextInt(maxValue-minValue +1 ) + minValue;
                double percent =(double)((randomNumber-minValue)*100) /(maxValue-minValue);
                int maxProgress = 100 ;
                int progressValue = (int)((percent/100)*maxProgress);

                randomNumberTextView.setText(Integer.toString(randomNumber) + " = % " + Double.toString(percent));
                minValueTextView.setText("Min : " + Integer.toString(minValue));
                maxValueTextView.setText("Max : " + Integer.toString(maxValue));

                progressBar.setProgress(progressValue);

                rowFirst.addView(randomNumberTextView);
                rowSecond.addView(minValueTextView);
                rowSecond.addView(progressBar);
                rowSecond.addView(maxValueTextView);
                columnFirst.addView(rowFirst);
                columnFirst.addView(rowSecond);
                scrollLinearLayout.addView(columnFirst);


            }
            mainLayout.addView(scrollView);

            }
        });





















    }
}