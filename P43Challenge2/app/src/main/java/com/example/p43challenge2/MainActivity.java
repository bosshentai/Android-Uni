package com.example.p43challenge2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void processTimePickerResult(int hour,int minute){
    String hour_string = Integer.toString(hour);
    String minute_String = Integer.toString(minute);

    String timeMessage = (hour_string + ":" + minute_String);

        Toast.makeText(this, getString(R.string.time) + timeMessage,Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.timepicker));
    }
}