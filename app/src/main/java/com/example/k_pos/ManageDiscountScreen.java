package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManageDiscountScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_discount_screen);

        getSupportActionBar().hide();
    }
}
