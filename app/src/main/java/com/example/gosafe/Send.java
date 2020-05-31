package com.example.gosafe;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;

import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;


public class Send extends AppCompatActivity {
    db dbhandler;
    ProgressDialog pd;
    EditText Msg;

    public void onclick(View view)
    {
        Intent i = new Intent(this, Add_Numbers.class);
        startActivity(i);
        overridePendingTransition  (R.anim.right_slide_in, R.anim.right_slide_out);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
        overridePendingTransition (R.anim.right_slide_in, R.anim.right_slide_out);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure, you want to exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
//btnsend


    public void message(View view)
    {
        if(dbhandler.number()==2) {
            String phoneNo1 = dbhandler.databaseToPhoneFirst();
            String phoneNo2 = dbhandler.databaseToPhoneSecond();
            phoneNo1 = "8424060194";
            phoneNo2 = "8108190193";

            Double latitude = 0.0, longitude;
            String message = "Need Your Help. I am in danger.Please Contact me ASAP";
            LocationManager mlocManager = null;
            LocationListener mlocListener;
            mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            mlocListener = new MyLocationListener(this);
            Log.d("rec", "received");

            if (ActivityCompat.checkSelfPermission(Send.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Send.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Send.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return;
            }

            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
            Log.d("rec", "received");
            if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                latitude = MyLocationListener.latitude;
                longitude = MyLocationListener.longitude;
                message = message + "\n My Location is - " + "https://www.google.com/maps/dir/@" + latitude + "," + longitude;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Log.d("rec", "received");

                if (latitude == 0.0) {
                    Toast.makeText(getApplicationContext(), "Currently gps has not found your location....", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "GPS is currently off...", Toast.LENGTH_LONG).show();
            }
            //message sending
            String smsNumber = String.format("smsto: %s",
                    "8657206488");


//        String smsNumber = String.format("smsto: %s",
//                );



            String sms = "I am in trouble . Please help me out! My current location is :- \n\n https://www.google.com/maps/@28.7298838,76.7325634,11z";
            // Create the intent.
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            // Set the data for the intent as the phone number.
            smsIntent.setData(Uri.parse(smsNumber));
            // Add the message (sms) with the key ("sms_body").
            smsIntent.putExtra("sms_body", sms);
            // If package resolves (target app installed), send intent.
            if (smsIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(smsIntent);
            } else {
                Log.d("tag", "Can't resolve app for ACTION_SENDTO Intent");
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please add two phone numbers of close ones first.....", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        getSupportActionBar().setTitle("The Push");
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();

//key board
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dbhandler= new db(this,null,null,1);
        Bundle numbers=getIntent().getExtras();
        if(numbers==null)
        {
            return;
        }
        String number1=numbers.getString("Number1");
        String number2=numbers.getString("Number2");

        phone_number n1=new phone_number(number1);
        phone_number n2=new phone_number(number2);
        dbhandler.addnumber1(n1);
        dbhandler.addnumber2(n2);

        ImageView send;
        send= findViewById(R.id.send);

        send.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {



                return true;
            }
        });


    }


}
