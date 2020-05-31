package com.example.gosafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_2);
        Button b3 = (Button) findViewById(R.id.button2);




    }
    //if clicked on logout will go to the first page
    public void onclick2(View view)
    {
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
        overridePendingTransition  (R.anim.right_slide_in, R.anim.right_slide_out);
    }
}


