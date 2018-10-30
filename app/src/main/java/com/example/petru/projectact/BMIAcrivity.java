package com.example.petru.projectact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIAcrivity extends AppCompatActivity {
    private double bmi, height, weight;
    private EditText textHeight, textWeight;
    private TextView textRes;
    private Button bEnter;
    private ImageView imRes, SmileRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiacrivity);
        bEnter = findViewById(R.id.Btn);
        textRes = findViewById(R.id.TVRes);
        textWeight = findViewById(R.id.FirstIn);
        textHeight = findViewById(R.id.SecIn);
        imRes = findViewById(R.id.NotOk);
        imRes.setImageAlpha(0x0);
        SmileRes = findViewById(R.id.Ok);
        SmileRes.setImageAlpha(0x0);
        bEnter.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Double.parseDouble(textHeight.getText().toString());
                weight = Double.parseDouble(textWeight.getText().toString());
                Calc(height, weight);
            }
        }));

    }
    private void Calc ( double h, double w){
        this.bmi = w / (h * h);
        if(bmi <17.5){
            textRes.setText("Your Body index is too Low");
            SmileRes.setImageAlpha(0x0);
            imRes.setImageAlpha(0xff);
        }
        if(bmi >17.5 && bmi <= 19.5){
            textRes.setText("Your Body index is Low");
            imRes.setImageAlpha(0xff);
        }
        if(bmi >19.5 && bmi<=22.9){
            textRes.setText("Your Body index is Normal");
            SmileRes.setImageAlpha(0xff);
        }
        if(bmi > 23&&bmi <=27.4 ) {
            textRes.setText("You have excess weight");
            imRes.setImageAlpha(0xff);
        }
        if(bmi > 27.5&&bmi <=29.9 ) {
            textRes.setText("You have obesity degree 1");
            imRes.setImageAlpha(0xff);
        }
        if(bmi > 30&&bmi <=34.9 ) {
            textRes.setText("You have obesity degree 2");
            imRes.setImageAlpha(0xff);
        }
        if(bmi > 35&&bmi <=39.9 ) {
            textRes.setText("You have obesity degree 3");
            imRes.setImageAlpha(0xff);
        }
        if(bmi > 40 ) {
            textRes.setText("You have obesity degree 4");
            imRes.setImageAlpha(0xff);
        }
    }
}