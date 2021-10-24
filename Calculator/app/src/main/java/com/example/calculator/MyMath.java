package com.example.calculator;

import android.os.Build;

import androidx.annotation.RequiresApi;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyMath {

    public Boolean zap;
    public  String primer;
//new coment 24.10.21
    private static Map<String, Integer> prioryti = new HashMap<String, Integer>(){{
        prioryti.put("+", 1);
        prioryti.put("-", 1);
        prioryti.put("*", 2);
        prioryti.put("/", 2 );
        prioryti.put("^", 3);
        prioryti.put("√", 3);
        prioryti.put("(", -1);
        prioryti.put(")", -1);
        prioryti.put("!", 3);
    }};


    private static String[] arrayNum = { "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", ".", "A", "B", "C", "D", "E", "F" };
    private static String[] arrayOperathions = { "+", "-", "*", "/", "^", "√", ")", "(", "!" };




    @RequiresApi(api = Build.VERSION_CODES.N)
    private static String getEl(String str, int i)
    {
        String el = "";

        for (; i < str.length(); i++)
        {
            String charS = String.valueOf(str.charAt(i));
            if (Arrays.stream(arrayOperathions).anyMatch(charS::equals))
            {
                if (el.length() > 0) return el;
                else return charS;
            }
            else if (Arrays.stream(arrayNum).anyMatch(charS::equals))
                el += str.charAt(i);
        }
        return el;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String calc(String primer)
    {
        Stack<String> stackNum = new Stack<String>();
        Stack<String> stackOperation = new Stack<String>();
        if (primer.length() > 0)
        {
            try
            {
                for (int i = 0; i < primer.length(); i++)
                {
                    String el = getEl(primer, i);
                    i = i + el.length() - 1;
                    String charS = String.valueOf(el.charAt(0));



                    if (Arrays.stream(arrayNum).anyMatch(charS::equals))
                        stackNum.push(el);
                    else {
                        if (stackOperation.stream().count() > 0)
                        {
                            String lastOp = stackOperation.peek();
                            if (el.equals("(") || lastOp.equals("("))
                            {
                                stackOperation.push(el);
                                continue;
                            }
                            if (el.equals(")"))
                            {
                                while (!lastOp.equals("("))
                                {
                                    TwoLastPoschitazz(stackNum, stackOperation);
                                    if (stackOperation.stream().count() > 0)
                                        lastOp = stackOperation.peek();
                                    else break;
                                }
                                stackOperation.pop();
                                continue;
                            }
                            if (prioryti.get(lastOp) < prioryti.get(el))
                                stackOperation.push(el);
                            else
                            {
                                while (prioryti.get(lastOp) >= prioryti.get(el))
                                {
                                    TwoLastPoschitazz(stackNum, stackOperation);
                                    if (stackOperation.stream().count() > 0)
                                        lastOp = stackOperation.peek();
                                    else break;
                                }
                                stackOperation.push(el);
                            }
                        }
                        else
                            stackOperation.push(el);
                    }
                }

                while (stackOperation.stream().count() > 0)
                    TwoLastPoschitazz(stackNum, stackOperation);
                return stackNum.pop();
            }
            catch (Exception e) { }
        }
        return "Error";
    }
    private static void TwoLastPoschitazz(Stack<String> stackNum, Stack<String> stackOperation)
    {
        double x = Double.parseDouble(stackNum.pop()), y = 0;
        if (stackOperation.peek().equals("!")) {
            // stackNum.push(String.valueOf(mathAction(x, stackOperation.pop())));
        } else
        {
            try { y = Double.parseDouble(stackNum.pop()); } catch (Exception e) { }
            stackNum.push(String.valueOf(mathAction(y, x, stackOperation.pop())));
        }
    }
    private static double mathAction(double x, double y, String op)
    {
        switch (op)
        {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            case "^":
                return Math.pow(x, y);
            case "√":
                return Math.pow(x, 1 / y);
        }
        return 0;
    }
}
