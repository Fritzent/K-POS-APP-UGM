package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences pref = getSharedPreferences("Prefer", MODE_PRIVATE);
        String FirstTimeOpen = pref.getString("FirstTimeOpen", "");

        if(FirstTimeOpen.equals("Yes")){

            // this when app not opened for the first time
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                    finish();
                }
            },4000);

        }else{
            // this is only doing when user open the app for the first time
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(),OnBoardingScreen.class));
                    finish();
                }
            },4000);

            SharedPreferences.Editor editor = pref.edit();
            editor.putString("FirstTimeOpen","Yes");
            editor.apply();

        }



    }
}
