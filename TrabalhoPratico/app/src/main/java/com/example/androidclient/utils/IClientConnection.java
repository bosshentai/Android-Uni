package com.example.androidclient.utils;


import com.example.androidclient.Contact;

import java.util.ArrayList;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IClientConnection {

    @GET("/contact")
    Call<ArrayList<Contact>> allContact();

    @POST("/contact")
    Call<ResponseBody> createContact(@Body Contact contact);


    @DELETE("/contact/{id}")
    Call<ResponseBody> deleteContact(@Path("id") String contactId);
}


