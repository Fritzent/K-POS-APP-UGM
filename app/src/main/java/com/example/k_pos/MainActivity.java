package com.example.k_pos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    LinearLayout settingMenu, openstoreMenu, historyMenu, reportMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is to hide the default actionBar
        getSupportActionBar().hide();

        //this is for the defenition item on xml to java
        settingMenu = findViewById(R.id.SettingMenu);
        openstoreMenu = findViewById(R.id.OpenStoreMenu);
        historyMenu = findViewById(R.id.HistoryMenu);
        reportMenu = findViewById(R.id.ReportMenu);

        //this is for the open store menu click action
        openstoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OpenStoreScreen.class));
                finish();
            }
        });

        //this is for the history menu click action
        historyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HistoryScreen.class));
                finish();
            }
        });

        //this is for the report menu click action
        reportMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReportScreen.class));
                finish();
            }
        });

        //this is for the setting menu click action
        settingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingScreen.class));
                finish();
            }
        });
    }

    //this is for the back pressed on phone click action
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Close the  app?")
                .setMessage("Are you sure want to close the app now?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
