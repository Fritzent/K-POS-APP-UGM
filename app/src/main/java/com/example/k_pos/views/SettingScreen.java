package com.example.k_pos.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.k_pos.R;
import com.example.k_pos.models.User;
import com.example.k_pos.storage.SharedPrefManage;

public class SettingScreen extends AppCompatActivity {

    LinearLayout managereceiptMenu, advancedsettingMenu, managediscountMenu, managetaxMenu, exitMenu;
    TextView txtEditProfile,txtUsername,txtUserPhone,txtExitUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        //this is for the inizalitation the sharedPreference
        User user = SharedPrefManage.getInstance(this).getUser();

        //this is for defenation the xml item on java
        managereceiptMenu = findViewById(R.id.receiptSide);
        managediscountMenu = findViewById(R.id.discountSide);
        managetaxMenu = findViewById(R.id.taxSide);
        advancedsettingMenu = findViewById(R.id.nextSide);
        exitMenu = findViewById(R.id.exitSide);
        txtExitUser = findViewById(R.id.txtExitAccount);
        txtEditProfile = findViewById(R.id.txtEditProfile);
        txtUsername = findViewById(R.id.UserName);
        txtUserPhone = findViewById(R.id.UserPhoneNumber);

        //this is to set the text of textview into database date
        txtUsername.setText(user.getName());
        txtUserPhone.setText(user.getNo_telepon());
        txtExitUser.setText(" Exit "+ user.getName());

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

                new AlertDialog.Builder(SettingScreen.this)
                        .setTitle("Logout from KPOS")
                        .setMessage("Are you sure want to logut the account now?")
                        .setNegativeButton(android.R.string.no, null)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logout();
                            }
                        }).create().show();
//                SettingScreen.this.finish();
//                System.exit(0);
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

    private void logout(){
        SharedPrefManage.getInstance(SettingScreen.this).clear();
        Intent intent = new Intent(SettingScreen.this, LoginScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
