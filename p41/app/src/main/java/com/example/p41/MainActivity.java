package com.example.p41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    private String mSettingMessage;

    public static final String EXTRA_MESSAGE = "com.example.android.p41.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }
    

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_contact){
//
//            return true;
//        }
        switch(item.getItemId()){
            case R.id.action_contact:
                mSettingMessage = getString(R.string.action_contact_message);
                displayToast(mSettingMessage);
                return true;
            case R.id.action_favorites:
                mSettingMessage = getString(R.string.action_favorites_message);
                displayToast(mSettingMessage);
                return true;
            case R.id.action_order:
//                mSettingMessage = getString(R.string.action_order_message);
//                displayToast(mSettingMessage);
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                mSettingMessage = getString(R.string.action_status_message);
                displayToast(mSettingMessage);
                return true;
            default:
//                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonetOrder(View view) {
//        displayToast(getString(R.string.donut_order_message));
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
//        displayToast(getString(R.string.ice_cream_order_message));
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrder(View view) {
//        displayToast(getString(R.string.froyo_order_message));
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}