package com.example.javavize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_view);


        Button backButton = findViewById(R.id.buttonBackSms);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmsView.this , MainActivity.class);
                startActivity(intent);
            }
        });





        Button sendButton = findViewById(R.id.sendButton);
        EditText messageTextField = findViewById(R.id.messageTextField);
        EditText phoneNumber = findViewById(R.id.phoneNumberTextField);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(ContextCompat.checkSelfPermission(SmsView.this , android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            String phoneNumberStr = phoneNumber.getText().toString();
            String messageStr = messageTextField.getText().toString();

            sendMessage(phoneNumberStr, messageStr);

            }
            else{
                ActivityCompat.requestPermissions(SmsView.this , new String[]{ android.Manifest.permission.SEND_SMS} , 100);
            }

            }
        });
    }
    private void sendMessage(String phoneNumber , String message){

        if(!phoneNumber.isEmpty() && !message.isEmpty() ){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber , null , message , null , null );
            Toast.makeText(this , "Başarılı" , Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this , "Geçersiz" , Toast.LENGTH_SHORT).show();
        }



    }


}