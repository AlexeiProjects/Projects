package com.example.TerminKalender.Model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {

    @NotNull(message = "Username darf nicht leer sein")
    @Size(min = 3, max= 15, message ="Username muss mindesten 3 Zeichen und darf maximal 15 Zeichen groß sein")
    private String username;
    @NotNull(message = "Password darf nicht leer sein")
    @Size(min = 3, max= 10, message ="Password muss mindesten 3 Zeichen und darf maximal 10 Zeichen groß sein")
    private String password;

    @Override
    public String toString() {
        return "RegisterModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public RegisterModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
