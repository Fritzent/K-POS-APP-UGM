package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);

        getSupportActionBar().hide();
    }
}
