package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FormProfileStoreScreen extends AppCompatActivity {

    Button btnForward;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_profile_store_screen);

        getSupportActionBar().setTitle("Profile Store");

        btnForward = findViewById(R.id.btnForward);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ShowDialog("Register Success!","Check your email register for the complete information");
            }
        });
    }
    private void ShowDialog(String txt1, String txt2){
        TextView txtAlert,txtAlertInfo;
        ImageView imgAlert;

        dialog = new Dialog(FormProfileStoreScreen.this);
        dialog.setContentView(R.layout.custome_dialog_register_complete);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.getAttributes().windowAnimations = R.style.DialogAnimation;

        txtAlert = dialog.findViewById(R.id.textAlert);
        txtAlertInfo = dialog.findViewById(R.id.textAlertInformation);
        imgAlert = dialog.findViewById(R.id.successLogo);

        txtAlert.setText(txt1);
        txtAlertInfo.setText(txt2);

        imgAlert.setImageResource(R.drawable.iconsuccess);

        dialog.setCancelable(true);
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.show();

        final Timer limitTimeShow = new Timer();
        limitTimeShow.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
                limitTimeShow.cancel();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        },4000); // after 4 second the show dialog close auto
    }
}
