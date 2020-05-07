package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ManageReceiptScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_receipt_screen);

        //this is to hide the default action bar
        getSupportActionBar().hide();
    }

    //this is for the back pressed on phone action
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), SettingScreen.class));
        finish();
    }
}
