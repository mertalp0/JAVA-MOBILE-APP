package com.example.javavize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertorView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_view);


        Button buttonBack = findViewById(R.id.buttonback);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConvertorView.this , MainActivity.class);
                startActivity(intent);
            }
        });

        EditText decimalTextField = findViewById(R.id.textFieldDecimal);
        Spinner decimalSpinner = findViewById(R.id.spinnerDecimal);
        TextView decimalResult = findViewById(R.id.resultDecimal);

        String[] decimalList = {"Secim yapınız" , "ikilik" , "sekizlik" , "onaltılık"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_spinner_item , decimalList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        decimalSpinner.setAdapter(adapter);

        decimalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = "" ;
                try {
                    String value = decimalTextField.getText().toString();
                    int decimalValue = Integer.parseInt(value);
                    String selectedValue = (String) parent.getItemAtPosition(position);
                    switch (selectedValue){
                        case "Secim yapınız" :
                            result = "0" ;
                            break;
                        case "ikilik" :
                           result = Integer.toBinaryString(decimalValue);
                            break;
                        case "sekizlik" :
                            result = Integer.toOctalString(decimalValue);
                            break;
                        case "onaltılık" :
                            result = Integer.toHexString(decimalValue);
                            break;
                    }
                }catch (NumberFormatException error){
                    result = "";
                }
                decimalResult.setText("sonuc: " + result);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //byte view
        EditText byteTextField = findViewById(R.id.textFieldByte);
        Spinner byteSpinner = findViewById(R.id.spinnerByte);
        TextView byteResult = findViewById(R.id.resultByte);

        String[] byteList = {"Secim yapınız" , "kilo byte" , "byte" , "kibi byte"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this , android.R.layout.simple_spinner_item , byteList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        byteSpinner.setAdapter(adapter2);

        byteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Double result = 0.0 ;
                try {
                    String value = byteTextField.getText().toString();
                    Double decimalValue = Double.parseDouble(value);
                    String selectedValue = (String) parent.getItemAtPosition(position);
                    switch (selectedValue){
                        case "Secim yapınız" :
                            result = 0.0 ;
                            break;
                        case "kilo byte" :
                            result = decimalValue * 1024 ;
                            break;
                        case "byte" :
                            result = decimalValue * 1024 * 1024;
                            break;
                        case "kibi byte" :
                            result =  decimalValue * 1024 * 1024 * 1024;
                            break;
                    }
                }catch (NumberFormatException error){
                    result = 0.0;
                }
                byteResult.setText("sonuc: " + result);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //celcius view

        EditText celciusTextField = findViewById(R.id.textFieldCelcius);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView resultCelcius = findViewById(R.id.resultCelcius);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton btnClick = findViewById(checkedId) ;
                String value = celciusTextField.getText().toString();
                String result = "" ;
                try {
                    double valueDouble = Double.parseDouble(value);


                    if(btnClick.getId() == R.id.radioButtonFahrenayt){
                        Double fahrenayt = (valueDouble * 9 / 5 ) + 32 ;
                        result = fahrenayt.toString() ;
                    }

                    else if (btnClick.getId() == R.id.radioButtonKelvin){
                        Double kelvin = valueDouble + 273.15 ;
                        result = kelvin.toString();

                    }


                }catch (NumberFormatException error){
                    result = "" ;

                }
                resultCelcius.setText(result);



            }
        });































    }
}