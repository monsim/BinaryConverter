package com.example.monsi.binaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decimalInputClick(View view){
        EditText decimalInput = (EditText)findViewById(R.id.decimalInput);
        Double decimalNumber = Double.parseDouble(decimalInput.getText().toString());
        Button decimalButton = (Button) findViewById(R.id.decimalButton);
        Log.i("Decimal :", decimalNumber.toString());
    }
}


