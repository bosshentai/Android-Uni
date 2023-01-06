package com.example.androidclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView favoriteRecyclerView;
    private ArrayList<Contact> favoriteList;

    private static final String LOG_TAG = FavoritosActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        favoriteRecyclerView = findViewById(R.id.favorityRecycleView);

        setDataFav();


        FavorityRecyclerViewAdapter adapter = new FavorityRecyclerViewAdapter(this, favoriteList);

        favoriteRecyclerView.setAdapter(adapter);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private void setDataFav() {
        favoriteList = new ArrayList<>();

        for (int i = 0; i < Db.contactList.size(); i++) {
            if (Db.contactList.get(i).getFav() == true) {
                favoriteList.add(Db.contactList.get(i));
                Log.d(LOG_TAG, Db.contactList.get(i).getId());
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        setDataFav();


        FavorityRecyclerViewAdapter adapter = new FavorityRecyclerViewAdapter(this, favoriteList);

        favoriteRecyclerView.setAdapter(adapter);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}