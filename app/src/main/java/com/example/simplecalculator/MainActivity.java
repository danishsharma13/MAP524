package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // TextView to reference
    private TextView upperTextView;
    private TextView lowerTextView;

    // Buttons to reference
    Button  button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonMulti,
            buttonDiv, buttonC, buttonEqual, buttonAdvanced;

    // Calculator instance
    private Calculator calculator = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextViews set to its reference
        upperTextView = (TextView) findViewById(R.id.textView);
        lowerTextView =(TextView) findViewById(R.id.textView2);

        // Buttons set to its reference
        button0 = (Button) findViewById(R.id.button14);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button5);
        button5 = (Button) findViewById(R.id.button6);
        button6 = (Button) findViewById(R.id.button7);
        button7 = (Button) findViewById(R.id.button9);
        button8 = (Button) findViewById(R.id.button10);
        button9 = (Button) findViewById(R.id.button11);
        buttonAdd = (Button) findViewById(R.id.button4);
        buttonSub = (Button) findViewById(R.id.button8);
        buttonMulti = (Button) findViewById(R.id.button12);
        buttonDiv = (Button) findViewById(R.id.button16);
        buttonC = (Button) findViewById(R.id.button13);
        buttonEqual = (Button) findViewById(R.id.button15);
        buttonAdvanced = (Button) findViewById(R.id.button17);

        // Setting Event listeners
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("0");
                upperTextView.append("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("1");
                upperTextView.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("2");
                upperTextView.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("3");
                upperTextView.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("4");
                upperTextView.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("5");
                upperTextView.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("6");
                upperTextView.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("7");
                upperTextView.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("8");
                upperTextView.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("9");
                upperTextView.append("9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("+");
                upperTextView.append("+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("-");
                upperTextView.append("-");
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("*");
                upperTextView.append("*");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("/");
                upperTextView.append("/");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clear();
                upperTextView.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = calculator.calculate();
                if(output != "failed") {
                    upperTextView.append("=" + output);
                    // if the button advanced is STANDARD that means to store history
                    if(buttonAdvanced.getText().toString().equals("STANDARD")) {
                        lowerTextView.append(upperTextView.getText().toString() + "\n");
                    }
                }
                else {
                    upperTextView.append("= Not an Operator");
                }
            }
        });

        buttonAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonAdvanced.getText().toString().equals("ADVANCE - WITH HISTORY")) {
                    buttonAdvanced.setText("STANDARD");
                }
                else {
                    buttonAdvanced.setText("ADVANCE - WITH HISTORY");
                    lowerTextView.setText("");
                }
            }
        });

    }
}