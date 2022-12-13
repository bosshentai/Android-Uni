package com.example.tpc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveToRegister(View view) {
        Intent moveToRegisterIntent = new Intent(MainActivity.this,register.class);

        startActivity(moveToRegisterIntent);
    }
}