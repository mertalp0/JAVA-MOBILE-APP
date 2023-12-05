package com.example.javavize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConvertor = findViewById(R.id.buttonConvertor);
        Button buttonRandom = findViewById(R.id.buttonRandom);
        Button buttonSms = findViewById(R.id.buttonSms);

        buttonConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ConvertorView.class);
                startActivity(intent);
            }
        });
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RandomView.class);
                startActivity(intent);
            }
        });

        buttonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SmsView.class);
                startActivity(intent);
            }
        });





    }
}