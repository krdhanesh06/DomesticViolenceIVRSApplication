package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LanguagesActivity extends AppCompatActivity {
    TextToSpeech myTTS;
    String username;
    TextView textView12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        initializeTextToSpeech();
      textView12= (TextView)findViewById(R.id.textView12);
      username= getIntent().getStringExtra("username");

        textView12.setText(username);
    }

    private void initializeTextToSpeech() {

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(LanguagesActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);

                    // myTTS.setLanguage(new Locale("hi"));
                    myTTS.setSpeechRate(0.9f);
                    // speak("");
                    speak("Please select your language");
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


    public void Back(View view) {
        Intent i = new Intent(LanguagesActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void English(View view) {
        Intent i = new Intent(LanguagesActivity.this, EnglishActivity.class);
        startActivity(i);
    }
    public void Hindi(View view) {
        Intent i = new Intent(LanguagesActivity.this, HindiActivity.class);
        startActivity(i);
    }
    public void Marwadi(View view) {
        Intent i = new Intent(LanguagesActivity.this, MarwadiActivity.class);
        startActivity(i);
    }

    public void Logout(View view) {
        finish();

        Toast.makeText(LanguagesActivity.this,"Log Out Successfully", Toast.LENGTH_LONG).show();

        Intent i = new Intent(LanguagesActivity.this, WelcomeActivity.class);
        startActivity(i);
    }
}
