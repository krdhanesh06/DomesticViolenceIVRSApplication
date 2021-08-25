package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class ThankYouActivity extends AppCompatActivity {
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        initializeTextToSpeech();
        //speak(" Thank you!");
    }

    private void initializeTextToSpeech() {







            myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (myTTS.getEngines().size() == 0) {
                        Toast.makeText(ThankYouActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        myTTS.setLanguage(Locale.US);

                        // myTTS.setLanguage(new Locale("hi"));
                        myTTS.setSpeechRate(0.9f);
                        // speak("??????? , ????????  ??? ???? ?????? ?? . ?????? ???? ???? ?????. ????? ??? ???? ???? ?? ??? ? ????? ?????? ??????? ??? ???? ???? ?? ??? ? ?????. ");
                        speak("Thank You.");
                    }
                }
            });
        }

        public void Logout(View view) {

       finish();
        Intent i = new Intent(ThankYouActivity.this, WelcomeActivity.class);
        startActivity(i);
       speak("");
    }

    private void speak(String message) {


        if (Build.VERSION.SDK_INT >= 21) {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void Back(View view) {

        Intent i = new Intent(ThankYouActivity.this, VoiceToTextActivity.class);
        startActivity(i);
    }
}





