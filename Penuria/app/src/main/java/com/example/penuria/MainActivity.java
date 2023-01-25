package com.example.penuria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        new Handler().postDelayed(new Runnable(){
//
//            @Override
//            public void run() {
//                Intent i = new Intent(MainActivity.this, ListaContactos.class);
//                startActivity(i);
//            }
//        },1000);
    }

    public void moveLista(View view) {

        Intent movetoListaIntent = new Intent(this,ListaContactos.class);
        startActivity(movetoListaIntent);
    }
}