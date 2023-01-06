package com.example.androidclient;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.UUID;

public class Contact {


    private String id;
    private String fullName;
    private String email;
    private String birth;
    private String phoneNumber;
    private String sex;
    private boolean fav;


    public Contact(String fullName, String phoneNumber, String email, String birth, String sex) {
//        this.id = Timestamp().from(Instant.from());
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.sex = sex;
        this.fav = false;




    }


    public Contact(String fullName, String phoneNumber, String email, String birth, String sex, boolean fav) {
//        this.id = String.valueOf(LocalTime.now());
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.sex = sex;
        this.fav = fav;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth() {
        return birth;
    }

    public String getSex() {
        return sex;
    }

    public boolean getFav() {
        return fav;
    }


    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public void updateContact(String fullName, String phoneNumber, String email, String birth, String sex) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birth = birth;
        this.sex = sex;
    }

}
