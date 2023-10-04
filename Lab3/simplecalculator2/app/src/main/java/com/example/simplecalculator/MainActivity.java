package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplecalculator.R;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    private enum Operator {none, add, sub, mul, div, eq}

    private double data01=0, data02 = 0;

    private Operator opp = Operator.none;

    private boolean hasDot = false;

    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView)findViewById(R.id.resultText);

    }

    // Sample implementation of the onClickNumericalButton (...).
    // Feel free to re-implement or modidy.
    public void onClickNumericalButton(View view) {


        //Getting ID of pressed Button
        int pressID = view.getId();
        CharSequence result = resultText.getText();
        if (result.toString().contains("ERROR")){
            resultText.setText("");
        }
        //If we had an equal sign pressed last, standard operation is to clean
        if (opp == Operator.eq) {
            opp = Operator.none;
            resultText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            hasDot = false;
            resultText.setText("");
        }

        //Figuring out which button was pressed and updating the represented text field object
        if (pressID == R.id.button0) {
            resultText.setText(resultText.getText() + "0");
        } else if (pressID == R.id.button1) {
            resultText.setText(resultText.getText() + "1");
        } else if (pressID == R.id.button2) {
            resultText.setText(resultText.getText() + "2");
        } else if (pressID == R.id.button3) {
            resultText.setText(resultText.getText() + "3");
        } else if (pressID == R.id.button4) {
            resultText.setText(resultText.getText() + "4");
        } else if (pressID == R.id.button5) {
            resultText.setText(resultText.getText() + "5");
        } else if (pressID == R.id.button6) {
            resultText.setText(resultText.getText() + "6");
        } else if (pressID == R.id.button7) {
            resultText.setText(resultText.getText() + "7");
        } else if (pressID == R.id.button8) {
            resultText.setText(resultText.getText() + "8");
        } else if (pressID == R.id.button9) {
            resultText.setText(resultText.getText() + "9");
        } else if (pressID == R.id.buttonDot&&hasDot==false&&resultText.getText().toString()!=""
                && Character.isDigit(resultText.getText().toString().charAt(resultText.getText().toString().length()-1))) {
            resultText.setText(resultText.getText() + ".");
            hasDot=true;
        }
        opp = Operator.none;

    }

    public void onClickFunctionButton(View view) {
        CharSequence result = resultText.getText();
        hasDot=false;
        if (result.toString().contains("ERROR")){
            resultText.setText("");

        }
        int pressID = view.getId();
        if(opp == Operator.none) {
            if (pressID == R.id.buttonDiv) {
                resultText.setText(resultText.getText() + "/");
                opp = Operator.div;
            } else if (pressID == R.id.buttonMul) {
                resultText.setText(resultText.getText() + "*");
                opp = Operator.mul;
            }  else if (pressID == R.id.buttonPlus) {
                resultText.setText(resultText.getText() + "+");
                opp = Operator.add;
            }
            else if (pressID == R.id.buttonMinus) {
                resultText.setText(resultText.getText() + "-");
                opp = Operator.sub;
            }
            else if (pressID==R.id.buttonEq){
                resultText.setText(resultText.getText()+"\n"+"\n"+ Double.toString(calculate()));
                opp = Operator.eq;
            }
            else  {
                resultText.setText("ERROR");
            }
        }
    }

    private double calculate() {
        String equation = resultText.getText().toString();
        String numbers = resultText.getText().toString().replaceAll("\\+",",").replaceAll("-",",").replaceAll("\\*",",").replaceAll("/",",");
        Toast.makeText(getApplicationContext(),numbers,Toast.LENGTH_SHORT).show();
        String[] numbersarr = numbers.split(",");
        double[] doublesarr = new double[numbersarr.length];
        for (int j = 0; j < numbersarr.length;j++){
            doublesarr[j] = Double.valueOf(numbersarr[j]);
        }
        String operators1 = "";
        for (int i = 0; i < equation.length();i++){
            if (!Character.isDigit(equation.charAt(i)) && equation.charAt(i) != '.'){
                operators1+= equation.charAt(i);
            }
        }
        char[] operators = operators1.toCharArray();
        Toast.makeText(getApplicationContext(), Arrays.toString(operators),Toast.LENGTH_SHORT).show();
        return doublesarr[1];
    }

}