package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class WelcomeActivity extends AppCompatActivity {
    //public static String UserEmail;
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeTextToSpeech();
    }

    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {

                    Toast.makeText(WelcomeActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setSpeechRate(0.9f);
                   // myTTS.setLanguage(new Locale("hi"));
                    myTTS.setLanguage(Locale.US);
                    //speak("Welcome to our Project.");
                    speak("Welcome to Harnessing the Power of Information and Communications Technology to Address Domestic Violence.");
                    // Harnessing the Power of Information and Communications Technology to

                }
            }
        });

    }


    private void speak(String message) {
        if (Build.VERSION.SDK_INT >= 21) {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {

            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    public void Login(View view) {
        Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(i);
        speak("");

    }

    public void Signup(View view) {
        Intent i = new Intent(WelcomeActivity.this, RegistrationActivity.class);
        startActivity(i);
        speak("");
    }


}
