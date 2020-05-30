package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.k_pos.R;

public class OnlineOrderScreen extends AppCompatActivity {

    Button btn_acc, btn_cancel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_order_screen);

        //this is for hide the default action bar from android studio
        getSupportActionBar().hide();

        //this is for the defenition item on xml to java
        btn_acc = findViewById(R.id.btn_acc_order);
        btn_cancel = findViewById(R.id.btn_cancel_order);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
