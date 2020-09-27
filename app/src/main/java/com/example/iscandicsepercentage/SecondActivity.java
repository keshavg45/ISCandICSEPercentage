package com.example.iscandicsepercentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Spinner mySpinner3 = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> myAdapter3 = ArrayAdapter.createFromResource(this,
                R.array.subjects3, R.layout.my_spinner);


        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        Spinner mySpinner4 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> myAdapter4 = ArrayAdapter.createFromResource(this,
                R.array.subjects4, R.layout.my_spinner);


        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);




        final Button button4;
        final EditText english = (EditText) findViewById(R.id.english);
        final EditText maths = (EditText) findViewById(R.id.maths);
        final EditText hcg = (EditText) findViewById(R.id.hcg);
        final EditText science = (EditText) findViewById(R.id.science);
        final EditText hindi = (EditText) findViewById(R.id.hindi);
        final EditText computer = (EditText) findViewById(R.id.computer);
        final TextView percentage = (TextView) findViewById(R.id.percentage);


        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eng,math,hcg1,sci,hin,comp;
                double sum=0,per;
                double temp;

                Scanner sc = new Scanner(System.in);

                double a[] = new double[5];

                eng = Double.parseDouble(english.getText().toString());
                math = Double.parseDouble(maths.getText().toString());
                hcg1 = Double.parseDouble(hcg.getText().toString());
                sci = Double.parseDouble(science.getText().toString());
                hin = Double.parseDouble(hindi.getText().toString());
                comp = Double.parseDouble(computer.getText().toString());

                int i,j;

                a[0]=math;
                a[1]=hcg1;
                a[2]=sci;
                a[3]=hin;
                a[4]=comp;

                for (i = 0; i < 5; i++)
                {
                    for (j = i + 1; j < 5; j++)
                    {
                        if (a[i] < a[j])
                        {
                            temp = a[i];
                            a[i] = a[j];
                            a[j] = temp;
                        }
                    }
                }

                sum = sum + eng;
                for(i=0;i<4;i++)
                {
                    sum = sum + a[i];
                }
                per = sum/5;

                percentage.setText(String.valueOf(per)+"%");
            }
        });


    }


}

