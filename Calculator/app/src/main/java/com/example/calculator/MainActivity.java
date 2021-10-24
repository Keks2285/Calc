package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button plus;
    Button minus;
    Button umnoz;
    Button del;
    Button step2;
    Button Cor;
    TextView TV;
    TextView dei;
    TextView otv;
int a = 1;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate)
    {
        super.onSaveInstanceState(outstate);
        outstate.putString("value",TV.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        TV.setText(savedInstanceState.getString("value"));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        umnoz = findViewById(R.id.umn);
        del = findViewById(R.id.del);
        TV =findViewById(R.id.tV);
        dei = findViewById(R.id.dei);
        otv = findViewById(R.id.otv);
    }


    public void onClick(View view) {
        Button b = (Button) view;
        switch (b.getId()) {
            case R.id.b1:
                if (a==1)
                TV.setText(TV.getText()+"1");
                else if (a==2) otv.setText(otv.getText()+"1");
                break;
            case R.id.b2:{   if (a==1)
                TV.setText(TV.getText()+"2");
            else if (a==2) otv.setText(otv.getText()+"2");}
                break;
            case R.id.b3:{   if (a==1)
                TV.setText(TV.getText()+"3");
            else if (a==2) otv.setText(otv.getText()+"3");}
                break;
            case R.id.b4: {  if (a==1)
                TV.setText(TV.getText()+"4");
            else if (a==2) otv.setText(otv.getText()+"4");}
                break;
            case R.id.b5:{   if (a==1)
                TV.setText(TV.getText()+"5");
            else if (a==2) otv.setText(otv.getText()+"5");;}
                break;
            case R.id.b6:{   if (a==1)
                TV.setText(TV.getText()+"6");
            else if (a==2) otv.setText(otv.getText()+"6");}
                break;
            case R.id.b7:{   if (a==1)
                TV.setText(TV.getText()+"7");
            else if (a==2) otv.setText(otv.getText()+"7");}
                break;
            case R.id.b8:{   if (a==1)
                TV.setText(TV.getText()+"8");
            else if (a==2) otv.setText(otv.getText()+"8");}
                break;
            case R.id.b9:{   if (a==1)
                TV.setText(TV.getText()+"9");
            else if (a==2) otv.setText(otv.getText()+"9");}
                break;
            case R.id.plus:
            {
                dei.setText("+");
                a=2;
                break;
            }
            case R.id.minus:
            {
                dei.setText("-");
                a=2;
                break;
            }
            case R.id.umn:
            {
                dei.setText("*");
                a=2;
                break;
            }
            case R.id.del:
            {
                dei.setText("/");
                a=2;
                break;
            }

        }
    }
    public void Ravno(View view)
    {
      a=1;
      double o1 = Double.parseDouble(TV.getText().toString());
        double o2 = Double.parseDouble(otv.getText().toString());
        switch (dei.getText().toString())
        {
            case"+":
            {
                double s = o1+o2;
                otv.setText(Double.toString(s));
                break;
            }
            case "-":
        {
            double s = o1-o2;
            otv.setText(Double.toString(s));
            break;
        }
            case "*":
        {
            double s = o1*o2;
            otv.setText(Double.toString(s));
            break;
        }
            case "/":
            {
                double s = o1/o2;
                otv.setText(Double.toString(s));
                break;
            }

        }
        dei.setText("");
        TV.setText("");
        //TV.setText(Long.toString(Long.parseLong(TV.getText().toString(),10)));
        //TV.setText(Long.toString(Long.valueOf(TV.getText().toString()).longValue()));
    }
public void ClearAll(View view)
{
    TV.setText("");

}

    }


//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void btnClick(View view) {
//        Button b = (Button) view;
//
//
//        if (Arrays.stream(arrayOperathions).anyMatch(b.getText().toString()::equals))
//        {
//            zap = true;
//        }
//
//        if (b.getText().toString().equals("-"))
//        {
//            primer += "0";
//        }
//        primer += b.getText().toString();
//        txtResult.setText(primer);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void btnClickReshenie(View view) {
//        primer = Reshenie(primer);
//        if(primer.substring(primer.length()-2).equals(".0")){
//            primer = primer.substring(0, primer.length()-2);
//        }
//        txtResult.setText(primer);
//    }
//
//    private void btnClickClearTextView(View view) {
//        primer = "";
//        txtResult.setText(primer);
//    }
//
//    private void btnClickDeleteLastChar(View view) {
//        if(primer.length() > 0) {
//            primer = primer.substring(0, primer.length() - 1);
//            txtResult.setText(primer);
//        }
//    }
//