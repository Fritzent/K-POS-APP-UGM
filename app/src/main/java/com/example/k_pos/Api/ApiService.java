package com.example.k_pos.Api;

import com.example.k_pos.models.LoginRespon;
import com.example.k_pos.models.UpdateUserProfileRespon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @POST("api/penjual/login")
    Call<LoginRespon> userLogin(@Body LoginUtilsApi utilsApi);

    @PUT("/api/pembeli/edit/{id}")
    Call<UpdateUserProfileRespon>userUpdateDate(
            @Path("id") int id,
            @Field("email") String email,
            @Field("phone_number") String phone_number,
            @Field("date_of_birth") String date_of_birth,
            @Field("name") String name
    );
}
