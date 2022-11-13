package com.example.p12b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
//    final Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView)  findViewById(R.id.show_count);

        final Button button = (Button) findViewById(R.id.count);

//        Log.i(button.toString());
//        Log.i("1",Integer.toString(mCount));
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);

        toast.show();
    }

    public void countUp(View view){
        mCount++;

//        Log.i(mCount);

//        Log.i("1",Integer.toString(mCount));
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}