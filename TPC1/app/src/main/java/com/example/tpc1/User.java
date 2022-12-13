package com.example.tpc1;

public class User {

    private String name;
    private String Email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        Email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }
}
