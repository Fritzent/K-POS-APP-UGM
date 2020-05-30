package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.k_pos.R;

public class EditProfileStoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_store_screen);

        //this is for the custome actionBar name title
        getSupportActionBar().hide();

    }

    //this is for the back press on phone action
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), AdvancedSettingScreen.class));
        finish();
    }
}
