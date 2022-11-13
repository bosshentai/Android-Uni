package com.example.p21;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.p2.1.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;


    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(LOG_TAG,"-----");
        Log.d(LOG_TAG,"onCreate");

        // Initialize all the view variavles.
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Resotre the state
        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.

            if(isVisible){
            mReplyHeadTextView.setVisibility(View.VISIBLE);
            mReplyTextView.setText(savedInstanceState.getString("reply_text"));
            mReplyTextView.setVisibility(View.VISIBLE);
            }
        }


//        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button clicked");
        Intent intent = new Intent(this, activity_second.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d(LOG_TAG,"onActivity");
        if(requestCode == TEXT_REQUEST){
//            Log.d(LOG_TAG,"TEXT_REQUEST");
            if(resultCode == RESULT_OK){
//                Log.d(LOG_TAG,"RESULT_OK");
                String reply = data.getStringExtra(activity_second.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
// If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.

        if(mReplyHeadTextView.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text",mReplyTextView.getText().toString());
        }
    }
}

