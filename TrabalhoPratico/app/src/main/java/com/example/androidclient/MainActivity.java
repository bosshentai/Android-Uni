package com.example.androidclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



    private void showSettings(){
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        if(settingsIntent.resolveActivity(getPackageManager())!= null){
            startActivity(settingsIntent);
        }else{
            Log.d("ImplicitIntents","Can't handle this!");
        }
    }

    public void newContactHandler(View view) {
        Intent moveToAddContact = new Intent(MainActivity.this, NewContactActivity.class);

        startActivity(moveToAddContact);
    }
}