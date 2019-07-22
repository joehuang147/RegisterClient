package com.joe.register.client;

public class RegisterResponse {
    //status
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private String status;

    public RegisterResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
