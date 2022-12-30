package com.example.tpc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = (EditText) findViewById(R.id.email_login_input);
        passwordEditText = (EditText) findViewById(R.id.password_login_input);


//        Db.userList.add(new User("Hernani Baptista", "bap@gmail.com", "22/10/1993", "123"));

    }

    public void moveToRegister(View view) {
        Intent moveToRegisterIntent = new Intent(MainActivity.this, Register.class);

        startActivity(moveToRegisterIntent);
    }

    public void loginHandler(View view) {

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();


//        email = "bap@gmail.com";
//        password = "123";

        for (int i = 0; i < Db.userList.size(); i++) {
            User user = Db.userList.get(i);

            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                Intent loggingIntent = new Intent(MainActivity.this, HomeActivity.class);
                Db.userSelected = user;

                loggingIntent.putExtra("es12",Db.userSelected.getName());
                startActivity(loggingIntent);

            } else {

                toastDisplay("Fail to log");
            }
        }

        if (Db.userList.size() == 0) {
            toastDisplay("Fail to log");
        }

    }

    private void toastDisplay(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}