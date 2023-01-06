package com.example.androidclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView favoriteRecyclerView;
    private ArrayList<Contact> favoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        favoriteRecyclerView = findViewById(R.id.favorityRecycleView);

        setDataFav();


        FavorityRecyclerViewAdapter adapter = new FavorityRecyclerViewAdapter(this,favoriteList);

        favoriteRecyclerView.setAdapter(adapter);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    private void setDataFav(){
        favoriteList = new ArrayList<>();

        for (int i = 0; i <Db.contactList.size();i++){
            if(Db.contactList.get(i).getFav() == true){
                favoriteList.add(Db.contactList.get(i));
            }
        }
    }
}