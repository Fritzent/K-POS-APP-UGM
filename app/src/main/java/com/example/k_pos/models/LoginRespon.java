package com.example.k_pos.models;

public class LoginRespon {

    private boolean error;
    private String status;
    private User user;

    public LoginRespon(boolean error, String status, User user) {
        this.error = error;
        this.status = status;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }
}
