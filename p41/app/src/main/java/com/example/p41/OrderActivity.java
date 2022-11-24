package com.example.p41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {


    private String orderMessage;
    private TextView orderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
//        String message = "Order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            orderMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.order_textView);
//        textView.setText(message);

        orderView = findViewById(R.id.order_textView);

        orderView.setText(orderMessage);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean cheched = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.sameday:
                if(cheched)
                    displayToast(getString(R.string.sameday_text));
                break;
            case R.id.nextday:
                if(cheched)
                    displayToast(getString(R.string.nextday_text));
                break;
            case R.id.pickup:
                if(cheched)
                    displayToast(getString(R.string.pickup_text));
                break;
            default:
                break;
        }

    }
}