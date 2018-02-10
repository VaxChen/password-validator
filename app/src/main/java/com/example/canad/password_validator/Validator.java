package com.example.canad.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android. widget.Button;
import android. widget. EditText;
import android.widget.TextView;

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

    EditText editText;
    TextView textView;
    Button button;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
        // get the Intent that started this activity and extract the String

            editText=(EditText) findViewById(R.id.editText);
            textView=(TextView) findViewById(R.id.textView);
            button=(Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    String password=editText.getText().toString();
                    int result = validate(password);
                    if(result==5)
                        textView.setText("Strong");
                    else if(result>2)
                        textView.setText("Not Strong");
                    else
                        textView.setText("Weak");
                }
            });

    }


}
