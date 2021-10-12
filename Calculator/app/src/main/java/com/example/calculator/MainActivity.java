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
    int a=1;
    int leng1=0;
    int leng2=0;
    char deistv=' ';
    String B1;
    String B2;
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
    }


    public void onClick(View view) {
        Button b = (Button) view;
        switch (b.getId()) {
            case R.id.b1:
                TV.setText(TV.getText()+"1");
                break;
            case R.id.b2:{ TV.setText(TV.getText()+"2");leng1++;}
                break;
            case R.id.b3:{ TV.setText(TV.getText()+"3");leng1++;}
                break;
            case R.id.b4: {TV.setText(TV.getText()+"4");leng1++;}
                break;
            case R.id.b5:{ TV.setText(TV.getText()+"5");leng1++;}
                break;
            case R.id.b6:{ TV.setText(TV.getText()+"6");leng1++;}
                break;
            case R.id.b7:{ TV.setText(TV.getText()+"7");leng1++;}
                break;
            case R.id.b8:{ TV.setText(TV.getText()+"8");leng1++;}
                break;
            case R.id.b9:{ TV.setText(TV.getText()+"9");leng1++;}
                break;
            case R.id.plus: {
                leng1 =0;
                B1=TV.getText().toString();
                TV.setText(TV.getText() + "+");
                deistv='+';
                a+=1;

            }break;
            case R.id.minus: {
                if (TV.getText() != null || TV.getText().charAt(TV.getText().length() - 1) != '-') {
                    a++;
                }
                if ( !TV.getText().toString().endsWith("--")) {
                    B1=TV.getText().toString();
                    TV.setText(TV.getText() + "-");
                    leng1 =0;
                    deistv='-';
                }break;
            }
            case R.id.umn: {
                B1=TV.getText().toString();
                TV.setText(TV.getText() + "*");
                a+=1;
                leng1 =0;
                deistv='*';
                break;
            }
            case R.id.del:
            {
                B1=TV.getText().toString();
                TV.setText(TV.getText()+"/");
                a++;
                leng1 =0;
                deistv='/';
                break;}
        }
    }
    public void Ravno(View view)
    {
        B2=B1;
        if (B1!=B2){
        B2=TV.getText().toString().replace(B1,"").substring(1);}
        double a1 = Double.parseDouble(B1);
        double a2 = Double.parseDouble(B2);
        double otv=0;
        B1=B2="";
switch (deistv)
{
    case '+': otv=a1+a2; break;
    case '-': otv=a1-a2; break;
    case '*': otv=a1*a2; break;
    case '/': otv=a1/a2; break;
}
        TV.setText(Double.toString(otv));

        //TV.setText(Long.toString(Long.parseLong(TV.getText().toString(),10)));
        //TV.setText(Long.toString(Long.valueOf(TV.getText().toString()).longValue()));
    }
public void ClearAll(View view)
{
    TV.setText("");
    B1="";
    B2="";
}

    }


