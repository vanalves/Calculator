package com.example.vanal.calculator;

import android.net.ParseException;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.vanal.calculator.R.id.textView1;

public class MainActivity extends AppCompatActivity {
    //Global variables
    TextView textView;
    double numOne = 0, numTwo = 0, result = 0;
    int operator = 0;
    boolean opClicked = false;
    double msNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

    }

    public void numsClicked(View v) {
        Button button = (Button) v;
        String expression = "";
        if (textView.getText().equals("0"))
            textView.setText("");
        expression = textView.getText().toString() + button.getText().toString();
        textView.setText(expression);
    }
    //Math Operations
    public void opClicked(View v) {
        Button button = (Button) v;
        switch (button.getText().toString()) {

            case "/":
                operator = 1;
                break;
            case "*":
                operator = 2;
                break;
            case "-":
                operator = 3;
                break;
            case "+":
                operator = 4;
                break;
        }
        if (!opClicked) {
            numOne = Double.parseDouble(textView.getText().toString());
            textView.setText("");
            opClicked = true;
        }
    }
        //Math functions
    public void equalClicked(View v) {
        numTwo = Double.parseDouble(textView.getText().toString());
        switch (operator) {
            case 1:
                result = numOne / numTwo;
                break;
            case 2:
                result = numOne * numTwo;
                break;
            case 3:
                result = numOne - numTwo;
                break;
            case 4:
                result = numOne + numTwo;
                break;
            default:
                result = 0;
        }
            // Remove the right Zero's
        int temp = (int) result;

        if (temp == (double) result) {
            textView.setText(temp + "");
        } else {
            textView.setText(result + "");
        }

        opClicked = false;
    }
        //Turn On Turn Off the calculator
    public void onOffClicked(View v) {

        textView.setText("");
    }
    // Keep the last number clicked
    public void msClicked(View v)
    {
        msNum = Double.parseDouble(textView.getText().toString());
        textView.setText("");
        int temp =(int)msNum;
    }

        //Recover the last number save from MS Function
    public void mrClicked(View v)
    {
        cClicked(null);
        textView.setText(String.valueOf(msNum));
        numOne = msNum;

        int temp =(int)msNum;
        if (temp == (double)msNum)
        {
            textView.setText(temp+"");
        }
        else{
            textView.setText(String.valueOf(msNum));
        }
    }
        //Clear function
    public void cClicked(View v) {
        textView.setText("0");
        numOne = 0;
        numTwo = 0;
        result = 0;
    }
        //sqr root function
    public void sqrRootClicked(View v) {
       double root;
        numOne = Double.parseDouble(textView.getText().toString());
        root = Math.sqrt(numOne);

        //Clean the right zero's
        int temp = (int)root;

        if (temp == (double) root) {
            textView.setText(temp + "");
        } else {
            textView.setText(String.valueOf(root));
        }
    }
        //Percentage function
    public void pctgClicked(View v) {
        numOne = Double.parseDouble(textView.getText().toString());
        result = numOne / 100;
        textView.setText(result + "");
    }
        //Delete function
    public void delClicked(View v) {
        String text = textView.getText().toString();
        String newText = "";
        for (int i = 0; i < text.length() - 1; i++) {
            newText += text.charAt(i);
        }
        textView.setText(newText);
    }
        //Decimal function
    public void decClicked(View v) {

        textView.setText(textView.getText() + ".");
    }



}
