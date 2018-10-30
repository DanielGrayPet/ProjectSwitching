package com.example.petru.projectact;

import android.icu.text.StringPrepParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private Double num1, num2;
    private Button pl, ml, dv,mi;
    private TextView textv;
    private EditText numv1, numv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        pl = findViewById(R.id.plus);
        ml = findViewById(R.id.multiply);
        dv = findViewById(R.id.divide);
        mi = findViewById(R.id.minus);
        textv = findViewById(R.id.Res);
        numv1 = findViewById(R.id.num1);
        numv2 = findViewById(R.id.num2);


        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(numv1.getText().toString());
                num2 = Double.parseDouble(numv2.getText().toString());
                double n1 = num1 + num2;
                String res = Double.toString(n1);
                textv.setText(res);
            }
        });
        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(numv1.getText().toString());
                num2 = Double.parseDouble(numv2.getText().toString());
                double n1 = num1 * num2;
                String res = Double.toString(n1);
                textv.setText(res);
            }
        });
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(numv1.getText().toString());
                num2 = Double.parseDouble(numv2.getText().toString());
                double n1 = num1 - num2;
                String res = Double.toString(n1);
                textv.setText(res);
            }
        });
        dv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(numv1.getText().toString());
                num2 = Double.parseDouble(numv2.getText().toString());
                double n1 = num1 / num2;
                String res = Double.toString(n1);
                textv.setText(res);
            }
        });
    }
}
