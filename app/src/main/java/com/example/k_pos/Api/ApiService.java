package com.example.k_pos.Api;

import com.example.k_pos.models.LoginRespon;
import com.example.k_pos.models.ResponBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

//    @POST("api/penjual/login")
//    Call<ResponBody> userLogin(@Body UtilsApi utilsApi);

    @POST("api/penjual/login")
    Call<LoginRespon> userLogin(@Body UtilsApi utilsApi);
}
