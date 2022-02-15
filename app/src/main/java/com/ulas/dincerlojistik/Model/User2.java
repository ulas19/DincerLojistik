package com.ulas.dincerlojistik.Model;

public class User2 {
    int pass;
    String email;

    public User2(int pass, String email) {
        this.pass = pass;
        this.email = email;
    }

    public User2() {
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
