package com.example.canad.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Validator extends AppCompatActivity {

    public int validate(String input) {
        char[] ele = new char[16];
        for (int i = 0; i < input.length(); i++)
            ele[i] = input.charAt(i);
        int result = 0;

        //check if the input password is longer than 8 characters
        if (input.length() >= 8)
            result++;

        //check if the input password is not "password"(case insensitive)
        if (!input.equalsIgnoreCase("password"))
            result++;

        return result;
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
    }
}
