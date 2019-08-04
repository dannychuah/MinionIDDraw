package com.danny.minioniddraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    int prime_value_max = 10005; // because max number 10000 ,max id is 10000+5

    List<Integer> list;
    TextView vTextView;
    int j = 2;// start prime number
    final int min = 0;//minimun minion num
    final int max = 10000;// maximun minion num

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);
        vTextView = (TextView) findViewById(R.id.textView1);

        list = new ArrayList<Integer>();
        for (int i = j; list.size() <= prime_value_max; i++) {
            if (isPrimeNumber(i)) {
                List<Integer> digits = new ArrayList<Integer>();
                if (i > 10) {
                    int f = i;
                    String number = String.valueOf(f);// convert prime number more than two digit to string
                    String[] digits1 = number.split("(?<=.)");// split the two digit
                    for (int k = 0;k <digits1.length; k++) {// add the the value to prime number string
                        list.add(Integer.valueOf(digits1[k]));
                    }
                } else {// single digit
                    list.add(i);// add the the value to prime number string
                }
            }
        }

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int random = new Random().nextInt((max - min) + 1) + min;
                String asd = "";
                for (int q = 0; q < 5; q++) {
                    asd= asd+""+list.get(random+q);
                }
                vTextView.setText("The number draw by minion  is "+random+" Which meant the ID number is "+asd);
            }
        });
    }

    public boolean isPrimeNumber(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

