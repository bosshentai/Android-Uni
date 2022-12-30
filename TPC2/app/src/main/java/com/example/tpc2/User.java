package com.example.tpc2;

public class User {

    private final String name;
    private final String email;
    private final String birth;
    private final String password;


    public User(String name, String email,String birth, String password) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
