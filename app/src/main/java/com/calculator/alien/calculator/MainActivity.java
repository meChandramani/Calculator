package com.calculator.alien.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView _txtScreen ;
    String strr = "";
    String currrOperator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtScreen = (TextView)findViewById(R.id.textResult);
        _txtScreen.setText(strr);

    }

    public void onClickonOperator(View v)
    {
        Button b = (Button) v;
        strr+= b.getText();
        currrOperator = b.getText().toString();
        _txtScreen.setText(strr);

    }
    public void onCLickonNumber(View v)
    {
        Button b = (Button) v;
        strr += b.getText();
        _txtScreen.setText(strr);
    }
    public void cleanBufff(){
        strr = "";
        currrOperator = "";

    }
    public void onClickC(View v)
    {
        strr = "";
        currrOperator = "";
        _txtScreen.setText(strr);

    }
    public void onClickEquals(View v) {
        String[] operationss = strr.split(Pattern.quote(currrOperator));
        if (operationss.length < 2) {
            return;
        }
        Float _result = computationp(operationss[0], operationss[1], currrOperator);

        _txtScreen.setText(String.valueOf(_result));
        cleanBufff();
        strr = _txtScreen.getText().toString();

    }
    public Float computationp(String x, String y , String z) {
        Float f = new Float("0");
        switch (z) {
            case "+" : return Float.valueOf(x) + Float.valueOf(y);
            case "-" : return Float.valueOf(x) - Float.valueOf(y);
            case "*" : return Float.valueOf(x) * Float.valueOf(y);
            case "/" : return Float.valueOf(x) / Float.valueOf(y);
            default: return f;
        }

    }

}