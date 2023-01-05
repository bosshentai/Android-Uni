package com.example.androidclient;

public class Contact {

    private final String fullName;
    private final String email;
    private final String birth;
    private final String sex;
    private final boolean fav;


    public Contact(String fullName, String email, String birth, String sex) {
        this.fullName = fullName;
        this.email = email;
        this.birth = birth;
        this.sex = sex;
        this.fav = false;


    }
}
