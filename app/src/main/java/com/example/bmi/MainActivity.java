package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText heightv,weightv;
TextView result;
Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightv=(EditText)findViewById(R.id.height);
        weightv=(EditText)findViewById(R.id.weight);
        show=(Button)findViewById(R.id.calc);
        result=(TextView) findViewById(R.id.output);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightstr = heightv.getText().toString();
                String weightstr = weightv.getText().toString();
                if (heightstr != "" && weightstr != "" && !heightstr.equals(null) && !weightstr.equals(null)) {
                    Float ht = Float.parseFloat(heightstr);
                    Float wt = Float.parseFloat(weightstr);
                    Float bmi = wt / (ht * ht);
                    String cat = "";
                    if (bmi < 18.5) {
                        cat = "UNDERWEIGHT";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        cat = "NORMAL";
                    } else if (bmi >= 25.0 && bmi <= 29.9) {
                        cat = "OVERWEIGHT";
                    } else {
                        cat = "OBESE";
                    }

                    result.setText("YOUR BMI IS:" + bmi + "\n" + cat);
                } else {
                    Toast.makeText(MainActivity.this, "No input", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }
}