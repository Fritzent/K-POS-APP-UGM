package com.example.k_pos.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.k_pos.models.Penjual;
import com.example.k_pos.models.User;

public class SharedPrefManage {

    private static final String SHARED_PREF_NAME = "my_shared_pref";

    private static SharedPrefManage mShared;
    private Context context;

    private SharedPrefManage(Context context){
        this.context = context;
    }

    public static synchronized SharedPrefManage getInstance(Context context){
        if(mShared == null){
            mShared = new SharedPrefManage(context);
        }
        return mShared;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putInt("saldo", user.getSaldo());
        editor.putInt("fcm_token", user.getFcm_token());
        editor.putInt("lokasi_id", user.getLokasi_id());
        editor.putInt("created_by", user.getCreated_by());
        editor.putInt("updated_by", user.getUpdated_by());
        editor.putString("level", user.getLevel());
        editor.putString("name", user.getName());
        editor.putString("email", user.getEmail());
        editor.putString("email_verified_at", user.getEmail_verified_at());
        editor.putString("no_telepon", user.getNo_telepon());
        editor.putString("tanggal_lahir", user.getTanggal_lahir());
        editor.putString("foto", user.getFoto());
        editor.putString("status", user.getStatus());
        editor.putString("created_at", user.getCreated_at());
        editor.putString("updated_at", user.getUpdated_at());
        editor.putString("token", user.getToken());

        editor.apply();
    }

    public void savePenjual(Penjual penjual){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("user_id", penjual.getUser_id());
        editor.putInt("rekening_id", penjual.getRekening_id());
        editor.putInt("deleted_at", penjual.getDeleted_at());
        editor.putString("penjualId", penjual.getPenjualId());
        editor.putString("toko", penjual.getToko());
        editor.putString("foto_toko", penjual.getFoto_toko());
        editor.putString("created_at", penjual.getCreated_at());
        editor.putString("updated_at", penjual.getUpdated_at());
    }

    //this is to check the user is login
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getInt("saldo", -1),
                sharedPreferences.getInt("fcm_token", -1),
                sharedPreferences.getInt("lokasi_id", -1),
                sharedPreferences.getInt("created_by", -1),
                sharedPreferences.getInt("updated_by", -1),
                sharedPreferences.getString("level", null),
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("email_verified_at", null),
                sharedPreferences.getString("no_telepon", null),
                sharedPreferences.getString("tanggal_lahir", null),
                sharedPreferences.getString("foto", null),
                sharedPreferences.getString("status", null),
                sharedPreferences.getString("created_at", null),
                sharedPreferences.getString("updated_at", null),
                sharedPreferences.getString("token", null)
        );
    }
    public Penjual getPenjual(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Penjual(
                sharedPreferences.getInt("user_id", -1),
                sharedPreferences.getInt("rekening_id", -1),
                sharedPreferences.getInt("deleted_at", -1),
                sharedPreferences.getString("penjualId", null),
                sharedPreferences.getString("toko", null),
                sharedPreferences.getString("foto_toko", null),
                sharedPreferences.getString("created_at", null),
                sharedPreferences.getString("updated_at", null)

        );
    }

    public void clear(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
