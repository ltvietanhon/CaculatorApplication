package com.ltviet.nhonkhanh.caculatorapplication;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editNum1, editNum2;
    TextView textresult;
    Button btnAddition, btnSubtraction, btnMultiplication, btnDivision;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNum1 = findViewById(R.id.hintNumberOne);
        editNum2 = findViewById(R.id.hintNumberTwo);
        textresult = findViewById(R.id.textviewResult);
        btnAddition = findViewById(R.id.buttonAddition);
        btnSubtraction = findViewById(R.id.buttonSubtraction);
        btnMultiplication = findViewById(R.id.buttonMultiplication);
        btnDivision = findViewById(R.id.buttonDivision);
        String num1 = editNum1.getText().toString();
        String num2 = editNum2.getText().toString();
        //Events
        btnAddition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //LENGTH_SHORT vs LENGTH_LONG show text fast or slow
                String num1 = editNum1.getText().toString();
                String num2 = editNum2.getText().toString();
                if ( !num1.equals("") || !num2.equals("")) {
                    int resultAdd = Integer.parseInt(num1) + Integer.parseInt(num2);
                    textresult.setText(String.valueOf(resultAdd));
                }
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = editNum1.getText().toString();
                String num2 = editNum2.getText().toString();
                if ( !num1.equals("") || !num2.equals("")) {
                    int resultSub = Integer.parseInt(num1) - Integer.parseInt(num2);
                    textresult.setText(String.valueOf(resultSub));
                }

            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = editNum1.getText().toString();
                String num2 = editNum2.getText().toString();
                if ( num1.equals("") || num2.equals("")) {

                    int resultMulti = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textresult.setText(String.valueOf(resultMulti));
                }
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1 = editNum1.getText().toString();
                    String num2 = editNum2.getText().toString();
                    if (!num1.equals("") || !num2.equals("")) {
                        Toast.makeText(MainActivity.this, "Type again a number", Toast.LENGTH_SHORT).show();
                    } else {

                        double resultDiv = Double.parseDouble(num1) / Integer.parseInt(num2);
                        textresult.setText(String.valueOf(resultDiv));
                    }
                }
                catch(ArithmeticException e)
                    {
                        Toast.makeText(MainActivity.this, "Division by zero", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}