package com.example.tpc2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent getNameView = getIntent();
        String userName = getNameView.getStringExtra("es12");

        TextView userNameView = findViewById(R.id.user_name);
        userNameView.setText(userName);

//        Toolbar settingBar = (Toolbar) findViewById(R.id.setting_bar);
//        setSupportActionBar(settingBar);
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
            case R.id.action_edit:
                Intent editUserInten = new Intent(HomeActivity.this, EditActivity.class);
                startActivity(editUserInten);
                return true;
            case R.id.action_delete:
                Db.userList.remove(Db.userSelected);
                finish();
                return true;
            case R.id.action_logout:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}