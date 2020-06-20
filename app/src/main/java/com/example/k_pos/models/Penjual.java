package com.example.k_pos.models;

import com.google.gson.annotations.SerializedName;

public class Penjual {
    private int user_id, rekening_id, deleted_at;
    @SerializedName("id")
    private  String penjualId;
    private String toko, foto_toko, created_at, updated_at;


    public Penjual(int user_id, int rekening_id, int deleted_at, String penjualId, String toko, String foto_toko, String created_at, String updated_at) {
        this.user_id = user_id;
        this.rekening_id = rekening_id;
        this.deleted_at = deleted_at;
        this.penjualId = penjualId;
        this.toko = toko;
        this.foto_toko = foto_toko;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRekening_id() {
        return rekening_id;
    }

    public int getDeleted_at() {
        return deleted_at;
    }

    public String getPenjualId() {
        return penjualId;
    }

    public String getToko() {
        return toko;
    }

    public String getFoto_toko() {
        return foto_toko;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
