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
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IClientConnection {

    @GET("/contact")
    Call<ArrayList<Contact>> allContact();

    @GET("/contact/{id}")
    Call<Contact> getOneContact(@Path("id") String contactId);

    @POST("/contact")
    Call<ResponseBody> createContact(@Body Contact contact);


    @DELETE("/contact/{id}")
    Call<ResponseBody> deleteContact(@Path("id") String contactId);

    @PUT("/contact/{id}")
    Call<Contact> updateContact(@Path("id") String contactId, @Body Contact contat);
}


