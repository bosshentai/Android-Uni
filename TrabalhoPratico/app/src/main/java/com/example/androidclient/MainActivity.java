package com.example.androidclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidclient.utils.IClientConnection;

import java.util.ArrayList;

import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    private ArrayList<Contact> contactListMainAtivity;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactRecyclerView = findViewById(R.id.contactRecycleView);

        setData();


//        // Retrofit builder
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:5020/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        IClientConnection contact = retrofit.create(IClientConnection.class);
//        Call<ArrayList<Contact>> call = contact.allContact();
//
//
//        call.enqueue(new Callback<ArrayList<Contact>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {
//
//                if(!response.isSuccessful()){
//                    Log.e("RESPONSE","onResponse: "+ response.code());
//
//                }
//                else{
//                    Log.d("response","onResponse: "+ response.body());
//                    contactListMainAtivity = (ArrayList<Contact>) response.body();
//
//                    ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(MainActivity.this, contactListMainAtivity);
////        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this, contactList);
//
//                    contactRecyclerView.setAdapter(adapter);
//                    contactRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
//
//                }
//
////                ArrayList<Contact> repos =  response.body();
////                Log.d("Body",repos.toString());
////                contactList
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
////                Toast.makeText(MainActivity.this,"Error to connetion",Toast.LENGTH_SHORT).show();
//                Log.e("Error","OnFailure: "+ t.getMessage());
//            }
//        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_settings, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent favorityIntent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(favorityIntent);
                return true;
            case R.id.action_definition:
                showSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    private void showSettings() {
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        if (settingsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(settingsIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void newContactHandler(View view) {
        Intent moveToAddContact = new Intent(MainActivity.this, NewContactActivity.class);

        startActivity(moveToAddContact);
    }


    private void setData() {
        // Retrofit builder
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5020/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        IClientConnection contact = retrofit.create(IClientConnection.class);
        Call<ArrayList<Contact>> call = contact.allContact();


        call.enqueue(new Callback<ArrayList<Contact>>() {
            @Override
            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {

                if(!response.isSuccessful()){
                    Log.e("RESPONSE","onResponse: "+ response.code());

                }
                else{
                    Log.d("response","onResponse: "+ response.body());
                    contactListMainAtivity = (ArrayList<Contact>) response.body();

                    ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(MainActivity.this, contactListMainAtivity);
//        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this, contactList);

                    contactRecyclerView.setAdapter(adapter);
                    contactRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                }

//                ArrayList<Contact> repos =  response.body();
//                Log.d("Body",repos.toString());
//                contactList
            }

            @Override
            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"Error to connetion",Toast.LENGTH_SHORT).show();
                Log.e("Error","OnFailure: "+ t.getMessage());
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
        setData();

//        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this,contactListMainAtivity);
//
//        contactRecyclerView.setAdapter(adapter);
//        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
        setData();

//        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this,contactListMainAtivity);
//
//        contactRecyclerView.setAdapter(adapter);
//        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}