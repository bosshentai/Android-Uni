package com.example.penuria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListaContactos extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
    }

    public void moveNovo(View view) {
        Intent movetoNovoIntent = new Intent(this,NovoContacto.class);
        startActivity(movetoNovoIntent);
    }
}