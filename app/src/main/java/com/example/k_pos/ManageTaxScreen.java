package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class ManageTaxScreen extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_tax_screen);

        getSupportActionBar().hide();

        //this is for the relative layout set to hide default
        relativeLayout = findViewById(R.id.formAddNewTax);
        relativeLayout.setVisibility(View.INVISIBLE);
        ViewGroup.LayoutParams params = relativeLayout.getLayoutParams();
        params.height = 10;
        relativeLayout.setLayoutParams(params);


        //this is for the switch button action
        Switch btn_switch_tax = findViewById(R.id.btn_switch_add_tax);
        btn_switch_tax.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    relativeLayout.setVisibility(View.VISIBLE);
                    ViewGroup.LayoutParams params = relativeLayout.getLayoutParams();
                    params.height = 350;
                    relativeLayout.setLayoutParams(params);
                }else{
                    relativeLayout.setVisibility(View.INVISIBLE);
                    ViewGroup.LayoutParams params = relativeLayout.getLayoutParams();
                    params.height = 10;
                    relativeLayout.setLayoutParams(params);

                }
            }
        });
    }
}
