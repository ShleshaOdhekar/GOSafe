package com.example.gosafe;


import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.net.Uri;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import static android.Manifest.permission.RECORD_AUDIO;

public class Speech extends AppCompatActivity {

    private SpeechRecognizer speechRecognizer;
    private Intent intentRecognizer;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        ActivityCompat.requestPermissions(this, new String[]{RECORD_AUDIO}, PackageManager.PERMISSION_GRANTED);

        textView = findViewById(R.id.textView);
        intentRecognizer = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

                speechRecognizer.stopListening();

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String no= "112";
                callIntent.setData(Uri.parse("tel:"+ no));
                startActivity(callIntent);
            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String string = "";
                if(matches!=null){
                    string = matches.get(0);
                    textView.setText(string);
                }

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });



        Button btcall;
        btcall = findViewById(R.id.button2);
        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String no= "112";
                callIntent.setData(Uri.parse("tel:"+ no));
                startActivity(callIntent);
            }
        });

    }
    public void StartButton(View view){

        speechRecognizer.startListening(intentRecognizer);
    }
    public void onclick2(View view)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String no= "112";
        callIntent.setData(Uri.parse("tel:"+ no));
        startActivity(callIntent);
    }



}



