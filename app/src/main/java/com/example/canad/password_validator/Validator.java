package com.example.canad.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Validator extends AppCompatActivity {

    public int validate(String input) {
        char[] ele = new char[16];
        for (int i = 0; i < input.length(); i++)
            ele[i] = input.charAt(i);
        int result = 0;

        //check if the input password is longer than 8 characters and shorter than 16 character
        if (input.length() >= 8&&input.length()<=16)
            result++;

        //check if the input password is not "password"(case insensitive)
        if (!input.equalsIgnoreCase("password"))
            result++;

        //check if the input password has at least one upper case letter
        for(int i=0;i<16;i++){
            if(Character.isUpperCase(ele[i])) {
                result++;
                break;
            }
        }

        //check if the input password has at least one digit
        for(int i=0;i<16;i++){
            if(Character.isDigit(ele[i])) {
                result++;
                break;
            }
        }

        //check if the input password doesn't have a digit as the first character
        if(!Character.isDigit(ele[0]))
            result++;

        return result;
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
    }
}
