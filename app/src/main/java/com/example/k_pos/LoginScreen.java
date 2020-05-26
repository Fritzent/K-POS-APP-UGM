package com.example.k_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k_pos.helper.ApiClient;
import com.example.k_pos.helper.ResponBody;
import com.example.k_pos.helper.UtilsApi;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {

    Button btn_login ;
    EditText inputEmail, inputPassword;
    TextView txtRegister,txtForgetPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //Defenition the Xml Item on Java
        btn_login = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        txtForgetPassword = findViewById(R.id.txtForgetPass);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);

        //this is setup the actionBar TitleName
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login");

        //this is for the button login click action
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(inputEmail.getText().toString()) || TextUtils.isEmpty(inputPassword.getText().toString())){
                    Toast.makeText(LoginScreen.this, "Email and Password Required", Toast.LENGTH_LONG).show();

                }else{
                    loginProceed();
                }


            }
        });

        //this is for the text register click action
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterScreen.class));
                finish();
            }
        });

        //this is for the text forget password click action
    }

    public void loginProceed(){
        UtilsApi loginRequest = new UtilsApi();
        loginRequest.setEmail(inputEmail.getText().toString());
        loginRequest.setPassword(inputPassword.getText().toString());


        Call<ResponBody> responBody = ApiClient.getApiService().userLogin(loginRequest);
        responBody.enqueue(new Callback<ResponBody>() {
            @Override
            public void onResponse(Call<ResponBody> call, Response<ResponBody> response) {
                
                if(response.isSuccessful()){
                    Toast.makeText(LoginScreen.this, "Login Success", Toast.LENGTH_SHORT).show();
                    ResponBody loginRespon = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ResponBody loginRespon = response.body();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("data", loginRespon.getSaldo()));
                            finish();
                        }
                    }, 700);

                }else{
                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponBody> call, Throwable t) {
                Toast.makeText(LoginScreen.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
