package com.example.appToTest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName;
    EditText password;
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.button);
        userName=(EditText)findViewById(R.id.editTextTextEmailAddress);
        password=(EditText)findViewById(R.id.editTextTextPassword);
        text = findViewById(R.id.textView);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(validate(userName.getText().toString(),password.getText().toString()));
            }
        });
    }


    public String validate(String userName, String password)
    {
        if(userName.equals("admin") && password.equals("admin"))
            return "Login was successful";
        else
            return "Invalid login!";
    }
}