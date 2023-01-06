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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    private ArrayList<Contact> contactList;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        contactRecyclerView = findViewById(R.id.contactRecycleView);

        // set
        Db.contactList.add(new Contact("Hernani Baptista", "1234", "bap@mail.com", "22/10/1993", "Masculino",true));
        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino",false));
        Db.contactList.add(new Contact("Iven Lopes","6780","gsdsd@mail.com","25/12/5235","Outros",true));
        Db.contactList.add(new Contact("Alex Monteiro","789","fglcb@mail.com","5/12/1457","Masculino",true));
        Db.contactList.add(new Contact("Yuri DinAmite","777","yi@mail.com","12/12/34323","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));
//        Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));Db.contactList.add(new Contact("Marvin Neves","666","mas@mail.com","125/12/1257","Feminino"));


//        setData();

//        Log.d("123",Db.contactList.get(1).getId());
//            Log.d("123",String.valueOf(System.currentTimeMillis()));



        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this);
//        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this, contactList);

        contactRecyclerView.setAdapter(adapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));


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

        contactList = new ArrayList<>();

//        contactList.removeAll();
        for (int i = 0; i < Db.contactList.size(); i++){

            contactList.remove(Db.contactList.get(i));

        }

        for (int i = 0; i < Db.contactList.size(); i++){

            contactList.add(Db.contactList.get(i));

        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
//        setData();

        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this);

        contactRecyclerView.setAdapter(adapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
//        setData();

        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this);

        contactRecyclerView.setAdapter(adapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}