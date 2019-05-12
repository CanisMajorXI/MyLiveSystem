package edu.sdust.mylive.model;

public class UserLoginInfo {
    public UserLoginInfo(String email, String password, Boolean valid) {
        this.email = email;
        this.password = password;
        this.valid = valid;
    }

    private String email;

    private String password;

    private Boolean valid;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }


}