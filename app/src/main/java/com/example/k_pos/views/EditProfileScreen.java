package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.k_pos.Api.ApiClient;
import com.example.k_pos.R;
import com.example.k_pos.models.UpdateUserProfileRespon;
import com.example.k_pos.models.User;
import com.example.k_pos.storage.SharedPrefManage;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class EditProfileScreen extends AppCompatActivity {

    EditText editInputName,editInputEmail,editInputPhoneNumber,editDateTime;
    DatePickerDialog.OnDateSetListener setDateListener;
    Button btnUpdateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);

        //this is for use the SharedPrefern Storage
        User user = SharedPrefManage.getInstance(this).getUser();

        getSupportActionBar().hide();

        //this is for the implementation the xml into java
        editInputName = findViewById(R.id.inputName);
        editInputEmail = findViewById(R.id.inputEmailRegis);
        editInputPhoneNumber = findViewById(R.id.inputPhoneNumberRegis);
        editDateTime = findViewById(R.id.inputDateBirthDayUser);
        btnUpdateDate = findViewById(R.id.btn_edit_profile_save);

        //this is to set the data
        editInputName.setHint(user.getName());
        editInputEmail.setHint(user.getEmail());
        editInputPhoneNumber.setHint(user.getNo_telepon());
        editDateTime.setHint(user.getTanggal_lahir());

        editDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this is to set the datepicker
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditProfileScreen.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setDateListener,year,month,day);

                        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        datePickerDialog.show();
            }
        });
        //this is to set the date picker into the edit text
        setDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                String date = year+"-"+month+"-"+day;
                editDateTime.setText(date);
            }
        };

        btnUpdateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });
    }

    //this is for the back pressed on phone action
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), SettingScreen.class));
        finish();
    }

    //this si to update the user date
    public void updateDate(){

        //this is for use the SharedPrefern Storage
        User user = SharedPrefManage.getInstance(this).getUser();

        String name = editInputName.getText().toString().trim();
        String email = editInputEmail.getText().toString().trim();
        String phoneNumber = editInputPhoneNumber.getText().toString().trim();
        String DateBirth = editDateTime.getText().toString().trim();

        if(name.isEmpty()){
            editInputName.setText(user.getName());
            editInputName.setError("Name set into default");
            return;
        }
        if(email.isEmpty()){
            editInputEmail.setText(user.getEmail());
            editInputEmail.setError("Email set into default");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editInputEmail.setError("Enter a valid email");
            editInputEmail.requestFocus();
            return;
        }
        if (phoneNumber.isEmpty()){
            editInputPhoneNumber.setText(user.getNo_telepon());
            editInputPhoneNumber.setError("Phone number set into default");
            return;
        }
        if(!Patterns.PHONE.matcher(phoneNumber).matches()){
            editInputPhoneNumber.setError("Enter a valid phone number");
            editInputPhoneNumber.requestFocus();
            return;
        }
        if (DateBirth.isEmpty()){
            editDateTime.setText(user.getTanggal_lahir());
            editDateTime.setError("Date birhtday set into default");
            return;
        }

        //this to call the api service for the update user date
        Call<UpdateUserProfileRespon> call = ApiClient.getApiService().userUpdateDate(
                user.getId(),
                email,
                phoneNumber,
                DateBirth,
                name
        );

        //this is for the cek the api if it success or failure
        call.enqueue(new Callback<UpdateUserProfileRespon>() {
            @Override
            public void onResponse(Call<UpdateUserProfileRespon> call, Response<UpdateUserProfileRespon> response) {
                //here for the check it the respon success
            }

            @Override
            public void onFailure(Call<UpdateUserProfileRespon> call, Throwable t) {

            }
        });

    }
}
