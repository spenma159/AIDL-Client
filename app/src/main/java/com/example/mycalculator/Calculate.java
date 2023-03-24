package com.example.mycalculator;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.util.ArrayList;

public class Calculate {
    ArrayList<Double> arrNumbers = new ArrayList<Double>();
    ArrayList<Character> arrOperators = new ArrayList<Character>();
    double result,num;
    char character;

    double start(String s){
        for(int i = 0; i < s.length(); i++){
            //Taking each character from the expression
            character = s.charAt(i);
            //Check if it is number
            if(Character.isDigit(character)){
                num = 0;
                while(Character.isDigit(character)){
                    num = num * 10 + Character.getNumericValue(character);
                    i++;
                    if(i < s.length()) character = s.charAt(i);
                    else break;
                }
                i--;
                arrNumbers.add(0,num);
            } else if (character == '(') {
                arrOperators.add(0, character);
            } else if (character == ')') {
                while(arrOperators.get(0) != '('){
                    result = cal(arrNumbers,arrOperators);
                    arrNumbers.add(0,result);
                }
                arrOperators.remove(0);
            } else if (isOperator(character)) {
                while(arrOperators.size() != 0 && precedence(character) <= precedence(arrOperators.get(0))){
                    double output= cal(arrNumbers,arrOperators);
                    arrNumbers.add(0, output);
                }
                arrOperators.add(0,character);
            }
        }
        while(arrOperators.size() != 0){
            double output= cal(arrNumbers,arrOperators);
            arrNumbers.add(0, output);
        }
        return arrNumbers.remove(0);
    }

    double cal(ArrayList num, ArrayList operator){
        double kiri,kanan;
        char ope;
        kanan = (double) num.remove(0);
        kiri = (double) num.remove(0);
        ope = (char) operator.remove(0);
        switch (ope){
            case '+':
                return kiri + kanan;
            case '-':
                return kiri - kanan;
            case 'x':
                return kiri * kanan;
            case '/':
                return kiri / kanan;
        }
        return 0;
    }
    boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '/' || c == 'x');
    }

    static int precedence(char c){
        switch(c){
            case '+' :
            case '-': return 1;
            case 'x':
            case '/': return 2;
        }
        return -1;
    }
}
