package com.example.h1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

//        final Button btCount = (Button) findViewById(R.id.bt_count);
//        final Button btZero = (Button)  findViewById(R.id.bt_zero);
    }

    public void countUp(View view) {
        mCount++;

        if(mShowCount !=null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void resetCount(View view) {
        mCount = 0;

        if (mShowCount !=null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void showMessage(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_LONG);

        toast.show();
    }
}