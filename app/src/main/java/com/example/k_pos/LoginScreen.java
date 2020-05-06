package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class LoginScreen extends AppCompatActivity {

    Button btn_login ;
    TextView txtRegister,txtForgetPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //Defenition the Xml Item on Java
        btn_login = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        txtForgetPassword = findViewById(R.id.txtForgetPass);

        //this is setup the actionBar TitleName
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login");

        //this is for the button login click action
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        //this is for the text register click action
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterScreen.class));
                finish();
            }
        });

        //this is for the text forget password click action
    }
}
