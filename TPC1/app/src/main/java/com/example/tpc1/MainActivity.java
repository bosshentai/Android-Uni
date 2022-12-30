package com.example.tpc1;

import static com.example.tpc1.Db.userList;
import static com.example.tpc1.Db.userSeleted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private String mUsername;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = (EditText) findViewById(R.id.email_login_input);
        passwordEditText = (EditText)  findViewById(R.id.password_login_input);

        Db.userList.add(new User("Hernani Baptista","baptistamhernani@gmail.com","123"));

    }

    public void moveToRegister(View view) {
        Intent moveToRegisterIntent = new Intent(MainActivity.this,register.class);

        startActivity(moveToRegisterIntent);
    }

    public void loginHandler(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
//        Log.d(TAG, Db.userList.toString());
        for (int i = 0; i < Db.userList.size(); i++){
            User user = Db.userList.get(i);

            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                Intent usergetNameIntent = new Intent(MainActivity.this,LoginActivity.class);
                Db.userSeleted = user;
//                usergetNameIntent.putExtra("es12",user.getName());
                usergetNameIntent.putExtra("es12", userSeleted.getName());
                startActivity(usergetNameIntent);
//                Log.d(TAG,"Entrou");
            }else{
                Log.d(TAG,"nao entrou");
            }
//          Log(TAG, user.getName());
        }

    }

    private void toastDisplay (String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}