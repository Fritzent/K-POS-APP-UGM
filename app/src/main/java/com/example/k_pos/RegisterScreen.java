package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class RegisterScreen extends AppCompatActivity {

    TextView txtLogin;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        //this is the definition item xml on java
        txtLogin = findViewById(R.id.txtLogin);
        btn_register = findViewById(R.id.btnRegister);

        //this is for the txt login click action
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                finish();
            }
        });

        //this is for the btn register click on action
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , FormProfileStoreScreen.class));
                finish();
            }
        });

        //this is to set the actionbar title name
        Objects.requireNonNull(getSupportActionBar()).setTitle("Register");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
