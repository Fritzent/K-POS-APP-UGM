package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManageReceiptScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_receipt_screen);

        getSupportActionBar().hide();
    }
}
