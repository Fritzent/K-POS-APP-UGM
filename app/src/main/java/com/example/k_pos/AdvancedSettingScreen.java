package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AdvancedSettingScreen extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_setting_screen);

        //this is for the custome actionBar Name Title
        getSupportActionBar().hide();

        //this is for defenition the item on xml to java
        linearLayout = findViewById(R.id.editstoreprofileSide);

        //this is for the action click on the edit profile store
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditProfileStoreScreen.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), SettingScreen.class));
        finish();
    }
}
