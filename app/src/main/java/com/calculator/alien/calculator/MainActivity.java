package com.calculator.alien.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bsh.Interpreter;

//import android.util.Log;
//import javax.script.*;

public class MainActivity extends AppCompatActivity {

    TextView _txtScreen ;
    String strr = "";
    int coun = 0;
    int sgnn =0;
    boolean dotSwitch = false;
 //String currrOperator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtScreen = (TextView)findViewById(R.id.textResult);
        _txtScreen.setText(strr);

    }
public void onClickClearr(View v){
        if(strr.length()>1){
        strr = strr.substring(0,strr.length()-1);
            _txtScreen.setText(strr);
        }
        else if(strr.length()==1)
        {
            strr = " ";
            _txtScreen.setText(strr);
        }
}

public  void OnClickOndot(View v){

    strr+=".";
    dotSwitch = true;

}

    public void onClickonOperator(View v)
    {if(coun == 1){
        dotSwitch=true;
        coun=0;}
        Button b = (Button) v;
        if(!dotSwitch){
        strr= strr+ ".0" + b.getText();
        }
        else
        {
            strr += b.getText();
            dotSwitch=false;

        }
   //  currrOperator = b.getText().toString();
        _txtScreen.setText(strr);

    }
    public void onCLickonNumber(View v)
    { int flag=1;
        if (coun == 1) {
            coun=0;
            cleanBufff();
        }
        Button b = (Button) v;
        strr += b.getText();
        _txtScreen.setText(strr);
        }

    public void cleanBufff(){
        strr = "";
   //     currrOperator = "";

    }
    public void onClickC(View v)
    {
        strr = "";
        _txtScreen.setText(strr);

    }
    public void onClickonBracketss(View v)     //ToDo : add brackets prooerty in the expression
                                                // TOdo : brackets button won't work without it

    {

    }
    public void onClickEquals(View v) {
  //    String[] operationss = strr.split(Pattern.quote(currrOperator));
    //    if (operationss.length < 2) {
     //       return;
      //  }
   //  ScriptEngineManager mgr = new ScriptEngineManager();
  //       ScriptEngine engine = mgr.getEngineByName("JavaScript");
   //         //System.out.println(engine.eval(strr));
        try{

            Interpreter interpreter = new Interpreter();
            interpreter.eval("Double result = new Double(0)");
             interpreter.eval("result =" + strr+".0");
         _txtScreen.setText(strr+ "\n" +"=" +String.valueOf((interpreter.get("result"))));
          //  _txtScreen.setText(strr+ "\n" + String.valueOf(db));
            cleanBufff();
            strr=String.valueOf(interpreter.get("result"));
            coun=1;

        }catch (bsh.EvalError e){
            Toast.makeText(getApplicationContext(), "Invalid input" , Toast.LENGTH_LONG).show();
        }

  //      cleanBufff();
        //strr = _txtScreen.getText().toString();

//strr = String.valueOf(_result);

    }


}