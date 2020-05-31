package com.example.gosafe;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class WomenSecurityApp extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_security_app);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(WomenSecurityApp.this, Send.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
