package com.example.tpc1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent getNameIntent = getIntent();
        String mainMessage = getNameIntent.getStringExtra("es12");

        TextView userNameView = findViewById(R.id.user_name);
        userNameView.setText(mainMessage);

        // Setting bar
        Toolbar settingbarT = (Toolbar) findViewById(R.id.setting_bar);
        setSupportActionBar(settingbarT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_settings,menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_edit:
//                Intent backMainIntent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(backMainIntent);
                return true;
            case R.id.action_delete:
                return true;
            case R.id.action_logout:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
//        return super.onOptionsItemSelected(item);
    }
}