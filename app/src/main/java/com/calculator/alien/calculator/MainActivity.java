package com.calculator.alien.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    String txtstr="";
    int coun = 0;
    int sgnn =0;
    boolean dotSwitch = false;
 //String currrOperator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id)
       //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_calculatoricon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

       getSupportActionBar().setDisplayShowTitleEnabled(true);

        _txtScreen = (TextView)findViewById(R.id.textResult);
        _txtScreen.setText(txtstr);

    }
     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        return true;
    }
public void onClickClearr(View v){
        if(strr.length()>1){
        strr = strr.substring(0,strr.length()-1);
        txtstr=txtstr.substring(0,txtstr.length()-1);
            _txtScreen.setText(txtstr);
        }
        else if(strr.length()==1)
        {
            strr = " ";
            txtstr=" ";
            _txtScreen.setText(strr);
        }
}

public  void OnClickOndot(View v){

    strr+=".";
    txtstr+=".";
    dotSwitch = true;

}
public void OnClckOnfactoriall(View v){
    dotSwitch=true;
    strr +="";
    _txtScreen.setText(strr);
}

    public void onClickonOperator(View v)
    {if(coun == 1){
        dotSwitch=true;
        coun=0;}
        Button b = (Button) v;
        if(!dotSwitch){
        strr= strr+ ".0" + b.getText();
        txtstr += b.getText();
        }
        else
        {
            strr += b.getText();
            dotSwitch=false;
            txtstr += b.getText();


        }
   //  currrOperator = b.getText().toString();
        _txtScreen.setText(txtstr);


    }
    public void onCLickonNumber(View v)
    { int flag=1;
        if (coun == 1) {
            coun=0;
            cleanBufff();
        }
        Button b = (Button) v;
        strr += b.getText();
        txtstr += b.getText();
        _txtScreen.setText(txtstr);
        }

    public void cleanBufff(){
        strr = "";
        txtstr= "";
   //     currrOperator = "";

    }
    public void onClickC(View v)
    {
        strr = "";
        txtstr ="";
        _txtScreen.setText(strr);

    }
    public void onClickonBracketss(View v)


    {
        Button b = (Button) v;
        strr= strr + b.getText();
        _txtScreen.setText(strr);
        if(strr.charAt(strr.length()-1) == ')' )
        {
            dotSwitch=true;
        }

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
             interpreter.eval("result =" + strr);
         _txtScreen.setText(txtstr+ "\n" +"=" +String.valueOf((interpreter.get("result"))));
          //  _txtScreen.setText(strr+ "\n" + String.valueOf(db));
            cleanBufff();
            strr=String.valueOf(interpreter.get("result"));
            txtstr=strr;
            coun=1;

        }catch (bsh.EvalError e){
            Toast.makeText(getApplicationContext(), "Invalid input" , Toast.LENGTH_LONG).show();
        }

  //      cleanBufff();
        //strr = _txtScreen.getText().toString();

//strr = String.valueOf(_result);

    }


}