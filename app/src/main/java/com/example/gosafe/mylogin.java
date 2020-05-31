package com.example.gosafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class mylogin extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b3 = (Button) findViewById(R.id.logout);
        b3.setOnClickListener(this);

    }
    //if clicked on logout will go to the first page
    public void onClick(View view) {
        Button b3 = (Button) findViewById(R.id.logout);
        Button b4 = (Button) findViewById(R.id.submit);
        Button b5 = (Button) findViewById(R.id.custom_button);


        switch (view.getId()) {

            case R.id.logout:
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(mylogin.this, MainActivity.class));
                    }
                });



            case R.id.submit:

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(mylogin.this, Send.class));
                    }
                });

            case R.id.custom_button:

                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(mylogin.this, Speech.class));
                    }
                });
                break;




        }}
    public void fp(View v)  //func to click on forgot pass and go on next page
    {
        Intent inn=new Intent();
        inn.setClass(this,reset.class);
        startActivity(inn);
    }}

