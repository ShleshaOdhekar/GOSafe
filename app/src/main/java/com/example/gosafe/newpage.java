package com.example.gosafe;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class newpage extends AppCompatActivity implements View.OnClickListener{
//    DataHelper db;
//    EditText e1,e2,e3,e4,e5,e6,e7,e8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_newpage);
        Button b3 = (Button) findViewById(R.id.submit);

        b3.setOnClickListener(this);


    }
    //if clicked on logout will go to the first page
    public void onClick(View view) {
        Button b3 = (Button) findViewById(R.id.submit);
        switch (view.getId()) {

            case R.id.submit:
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(newpage.this, mylogin.class));
                    }
                });

                break;

        }}
    public void safe(View v)  //func to click on forgot pass and go on next page
    {
        Intent inn=new Intent();
        inn.setClass(this,mylogin.class);
        startActivity(inn);
    }
//        e1 = findViewById(R.id.name);
//        e2 = findViewById(R.id.age);
//        e3 = findViewById(R.id.add);
//        e4 = findViewById(R.id.phone);
//        e5 = findViewById(R.id.fm1n);
//        e6 = findViewById(R.id.fm1p);
//        e7 = findViewById(R.id.fm2n);
//        e8 = findViewById(R.id.fm2p);




    //db = new DataHelper(this);
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {


//                        String s1 = e1.getText().toString();
//                        String s2= e2.getText().toString();
//                        int  i1=Integer.parseInt(s2);
//                        String s3 = e3.getText().toString();
//                        String s4 = e4.getText().toString();
//                        int  i2=Integer.parseInt(s4);
//                        String s5 = e5.getText().toString();
//                        String s6 = e6.getText().toString();
//                        int  i3=Integer.parseInt(s6);
//                        String s7 = e7.getText().toString();
//                        String s8 = e8.getText().toString();
//                        int  i4=Integer.parseInt(s8);
//
//
//                        if (s1.equals("") || s2.equals("") || s3.equals("")||s4.equals("") || s5.equals("") || s6.equals("")|| s7.equals("") || s8.equals("")) {
//                            Toast.makeText(getApplicationContext(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                            Boolean new_insert = db.new_insert(s1,i1,s3,i2,s5,i3,s7,i4);
//                            if (new_insert == true) {
//                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
//
////                            }
//
//                startActivity(new Intent(newpage.this, mylogin.class));
//
//            }
//        });
//        public void set(View v)  //func to click on forgot pass and go on next page
//        {
//            Intent inn=new Intent();
//            inn.setClass(this,settings.class);
//            startActivity(inn);
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        Button b3 = (Button) findViewById(R.id.submit);
//
//    }
}

