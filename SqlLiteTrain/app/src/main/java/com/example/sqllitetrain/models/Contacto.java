package com.example.sqllitetrain.models;

public class Contacto {
    private int id;
    private String fullname;
    private String email;
    private String birth;
    private String phoneNumber;

    private String sex;

    private boolean fav;


    public Contacto(String fullname, String email, String birth, String phoneNumber, String sex) {
        this.fullname = fullname;
        this.email = email;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
//        this.sex= email;
        this.fav = false;
    }


    public void setFav(Boolean fav) {
        this.fav = fav;
    }
}
