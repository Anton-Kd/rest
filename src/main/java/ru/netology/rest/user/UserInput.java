package ru.netology.rest.user;

import jakarta.validation.constraints.NotBlank;

public class UserInput {
    @NotBlank
    private String user, password;
    ;

    public UserInput(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public UserInput() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
