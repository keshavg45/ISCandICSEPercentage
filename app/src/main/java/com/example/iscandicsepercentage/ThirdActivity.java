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

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Spinner mySpinner1 = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.subjects1, R.layout.my_spinner);


        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

        Spinner mySpinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> myAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.subjects2, R.layout.my_spinner);


        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);




        final Button button3;
        final EditText english = (EditText) findViewById(R.id.english);
        final EditText accounts = (EditText) findViewById(R.id.maths);
        final EditText commerce = (EditText) findViewById(R.id.hcg);
        final EditText economics = (EditText) findViewById(R.id.science);
        final EditText maths = (EditText) findViewById(R.id.hindi);
        final EditText computer = (EditText) findViewById(R.id.computer);
        final TextView percentage = (TextView) findViewById(R.id.percentage);


        button3 = (Button) findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eng,acc,comm,eco,math,comp;
                double sum=0,per;
                double temp;

                Scanner sc = new Scanner(System.in);

                double a[] = new double[5];

                eng = Double.parseDouble(english.getText().toString());
                acc = Double.parseDouble(accounts.getText().toString());
                comm = Double.parseDouble(commerce.getText().toString());
                eco = Double.parseDouble(economics.getText().toString());
                math = Double.parseDouble(maths.getText().toString());
                comp = Double.parseDouble(computer.getText().toString());

                int i,j;

                a[0]=acc;
                a[1]=comm;
                a[2]=eco;
                a[3]=math;
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
                for(i=0;i<3;i++)
                {
                    sum = sum + a[i];
                }
                per = sum/4;

                percentage.setText(String.valueOf(per)+"%");
                
            }
        });


    }

}
