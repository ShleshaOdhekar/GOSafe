package com.example.gosafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reset extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.reset);
        final EditText e1=findViewById(R.id.emailm);
        final EditText p1=findViewById(R.id.passm);
        EditText c1=findViewById(R.id.cpassm);

        final String s1= e1.getText().toString().trim();
        final  String s2=p1.getText().toString().trim();
        String s3=c1.getText().toString();



        Button btn = (Button) findViewById(R.id.resets);

        btn.setOnClickListener(new View.OnClickListener() {

            //            SQLiteDatabase db=this.getWriteableDatabase();
            @Override
            public void onClick(View v) {
                DataHelper d=new DataHelper(getApplicationContext());
                  Boolean  result=d.updatepass(s1,s2);
                //Boolean storedNewData=d.updatepass(s1,s2);
//                if(s2.equals(storedNewData))
                if(result==true){
                  Toast.makeText(getApplicationContext(), "reset successful", Toast.LENGTH_LONG).show();}
               else {
                    Toast.makeText(getApplicationContext(), "reset unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }}

