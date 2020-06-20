package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k_pos.R;
import com.example.k_pos.Api.ApiClient;
import com.example.k_pos.models.LoginRespon;
import com.example.k_pos.Api.LoginUtilsApi;
import com.example.k_pos.storage.SharedPrefManage;

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

                if(TextUtils.isEmpty((inputEmail.getText().toString().trim())) && TextUtils.isEmpty(inputPassword.getText().toString().trim())){
                    Toast.makeText(LoginScreen.this, "Email and Password is Empty", Toast.LENGTH_SHORT).show();
                    inputEmail.requestFocus();
                }

                else if(TextUtils.isEmpty(inputEmail.getText().toString().trim())){
                    inputEmail.setError("Email is Empty");
//                    Toast.makeText(LoginScreen.this, "Email is Empty", Toast.LENGTH_SHORT).show();
                    inputEmail.requestFocus();
                }
                else if(TextUtils.isEmpty(inputPassword.getText().toString().trim())){
                    inputPassword.setError("Password is Empty");
//                    Toast.makeText(LoginScreen.this, "Password is Empty", Toast.LENGTH_SHORT).show();
                    inputPassword.requestFocus();
                } else{
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

    //this is to check if the user already login
    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManage.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    //this is for the login method action
    public void loginProceed(){
        LoginUtilsApi loginRequest = new LoginUtilsApi();
        loginRequest.setEmail(inputEmail.getText().toString());
        loginRequest.setPassword(inputPassword.getText().toString());


        Call<LoginRespon> loginRespon = ApiClient.getApiService().userLogin(loginRequest);
        loginRespon.enqueue(new Callback<LoginRespon>() {
            @Override
            public void onResponse(Call<LoginRespon> call, Response<LoginRespon> response) {
                if(response.isSuccessful()){
                    LoginRespon loginRespondata = response.body();

                    if(!loginRespondata.isError()){

                        SharedPrefManage.getInstance(LoginScreen.this)
                                .saveUser(loginRespondata.getUser());
                        SharedPrefManage.getInstance(LoginScreen.this)
                                .savePenjual(loginRespondata.getUser().getPenjual());


                        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginScreen.this, loginRespondata.getStatus(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRespon> call, Throwable t) {
                Toast.makeText(LoginScreen.this, "Error"+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
