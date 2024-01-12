package com.example.sunbaseTest.customerManagement.Model;

public class UserLoginCredentials {

    private String login_id,pass;

    public String getUsername(){
        return login_id;
    }

    public String getPassword(){
        return pass;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
