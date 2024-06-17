package com.example.bildergalerie.models;

public class LoginResponseDTO {

    private long userId;
    private String username;
    private String jwt;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(long userId, String username, String jwt){
        this.userId = userId;
        this.username = username;
        this.jwt = jwt;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}