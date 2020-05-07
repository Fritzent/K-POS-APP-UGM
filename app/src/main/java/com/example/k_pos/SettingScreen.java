package com.example.k_pos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingScreen extends AppCompatActivity {

    LinearLayout managereceiptMenu, advancedsettingMenu, managediscountMenu, managetaxMenu, exitMenu;
    TextView txtEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        //this is for defenation the xml item on java
        managereceiptMenu = findViewById(R.id.receiptSide);
        managediscountMenu = findViewById(R.id.discountSide);
        managetaxMenu = findViewById(R.id.taxSide);
        advancedsettingMenu = findViewById(R.id.nextSide);
        exitMenu = findViewById(R.id.exitSide);
        txtEditProfile = findViewById(R.id.txtEditProfile);

        //this is for the text edit profile click action
        txtEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditProfileScreen.class));
                finish();
            }
        });

        //this is for the managediscount menu click action
        managediscountMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ManageDiscountScreen.class));
                finish();
            }
        });

        //this is for the manageTax menu click action
        managetaxMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ManageTaxScreen.class));
                finish();
            }
        });

        //this is for the managereceipt menu click action
        managereceiptMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ManageReceiptScreen.class));
                finish();
            }
        });

        //this is for the advancedsetting menu click action
        advancedsettingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdvancedSettingScreen.class));
                finish();
            }
        });

        exitMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingScreen.this.finish();
                System.exit(0);

            }
        });

        //this to hide the default actionBar
        getSupportActionBar().hide();
    }

    //this is for the back pressed phone click action
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
