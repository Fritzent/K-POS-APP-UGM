package com.example.k_pos.models;

public class User {
    private int id, saldo, fcm_token, lokasi_id, created_by, updated_by;
    private String level, name, email, email_verified_at, no_telepon, tanggal_lahir, foto, status, created_at, updated_at, token;

    public User(int id, int saldo, int fcm_token, int lokasi_id, int created_by, int updated_by, String level, String name, String email, String email_verified_at, String no_telepon, String tanggal_lahir, String foto, String status, String created_at, String updated_at, String token) {
        this.id = id;
        this.saldo = saldo;
        this.fcm_token = fcm_token;
        this.lokasi_id = lokasi_id;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.level = level;
        this.name = name;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.no_telepon = no_telepon;
        this.tanggal_lahir = tanggal_lahir;
        this.foto = foto;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getFcm_token() {
        return fcm_token;
    }

    public int getLokasi_id() {
        return lokasi_id;
    }

    public int getCreated_by() {
        return created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public String getFoto() {
        return foto;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getToken() {
        return token;
    }
}
