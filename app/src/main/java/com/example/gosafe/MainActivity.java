package com.example.gosafe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1,e2,e3;
    CheckBox show1;
    CheckBox show2;
    DataHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.pass);
        e3 = findViewById(R.id.cpass);
        b1 = findViewById(R.id.register);
        show1= findViewById(R.id.show1);
        show2 = findViewById(R.id.show2);

        final String emailPattern = "[a-zA-Z0-9._-]+@(.+)$";
        //below pattern says 1 digit,uppercase,lowercase,no whitespace,atleast 8 chars
        // final String passpattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,10}";

        db = new DataHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();


                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields can't be empty", Toast.LENGTH_SHORT).show();

                } else {

                    if (s2.equals(s3)) {
                        //&&(e2.getText().toString().trim().matches(passpattern))) {


                        if ((e1.getText().toString().trim().matches(emailPattern)) && (e1.getText().toString().endsWith("gmail.com")) ) {
                            // Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                            Boolean chkemail = db.chkemail(s1, s2);
                            if (chkemail == true) {
                                Boolean insert = db.insert(s1, s2);
                                if (insert == true) {
                                    Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();

                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Enter only gmail id", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_LONG).show();

                    }


                }
                            startActivity(new Intent(MainActivity.this,newpage.class));

            }
        });


        Button btn = (Button) findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
//                db.exec
                DataHelper o = new DataHelper(getApplicationContext());

                if(!o.chkemail(e1.getText().toString(),e2.getText().toString()))//not checking for confirm pass one entering anything there is fine
                //&&(o.insert(e1.getText().toString(),e2.getText().toString())))
                {
                    Toast.makeText(getApplicationContext(), "Logged in sucessfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, mylogin.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not registered or incorrect password" +
                            "", Toast.LENGTH_LONG).show();
                }
            }
        });
        show1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
        show2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    e3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    e3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });


    }}

