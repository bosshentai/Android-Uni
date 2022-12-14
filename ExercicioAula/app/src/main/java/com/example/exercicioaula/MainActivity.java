package com.example.exercicioaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);


        mButton.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           PopupMenu popup = new PopupMenu(MainActivity.this, mButton);
                                           popup.getMenuInflater().inflate(R.menu.menu_aula, popup.getMenu());
                                           popup.setOnMenuItemClickListener(
                                                   new PopupMenu.OnMenuItemClickListener() {
                                                       @Override
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.settings:
//                                                                   Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                                                   showSettings();
                                                                   return true;
                                                               case R.id.favorite:
//                                                                   Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                                                   showFavorityActivity();
                                                                   return true;
                                                               default:
                                                                   return true;
                                                           }

//                                                           return true;
                                                       }
                                                   });
                                           popup.show();
                                       }

                                   }

        );

    }


        private void showFavorityActivity() {
         Intent favorityIntent = new Intent(MainActivity.this,FavorityActivity.class);

         startActivity(favorityIntent);
        }

        private void showSettings(){
        Intent settingIntent = new Intent(Settings.ACTION_SETTINGS);
        if(settingIntent.resolveActivity(getPackageManager())!= null){
            startActivity(settingIntent);
        }else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
        }

}