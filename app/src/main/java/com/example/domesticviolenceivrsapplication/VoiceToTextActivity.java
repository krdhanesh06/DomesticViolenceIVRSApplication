package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class VoiceToTextActivity extends AppCompatActivity {
    EditText editText;
    SpeechRecognizer mSpeechRecognizer;
    Intent mSpeechRecognizerIntent;
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_to_text);
        initializeTextToSpeech();
            checkpermission();

            editText = findViewById(R.id.editText100);
            mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

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

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    if (matches != null){


                        editText.setText(matches.get(0));
                    }

                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });

            findViewById(R.id.button100).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent motionEvent) {

                    switch (motionEvent.getAction()){

                        case MotionEvent.ACTION_UP:
                            mSpeechRecognizer.stopListening();
                            editText.setHint("You will see inputs here...");
                            break;
                        case MotionEvent.ACTION_DOWN:
                            editText.setText("");
                            editText.setHint("Listening...");
                            mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                            break;
                    }

                    return false;
                }
            });

        }

    private void initializeTextToSpeech() {


        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(VoiceToTextActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);

                    // myTTS.setLanguage(new Locale("hi"));
                    myTTS.setSpeechRate(0.9f);
                    // speak("??????? , ????????  ??? ???? ?????? ?? . ?????? ???? ???? ?????. ????? ??? ???? ???? ?? ??? ? ????? ?????? ??????? ??? ???? ???? ?? ??? ? ?????. ");
                    speak("You can convert your Voice into Text format here.");
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

    private void checkpermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){


                if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_GRANTED)){


                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                    finish();
                }
            }
        }


    public void Next(View view) {
        Intent i = new Intent(VoiceToTextActivity.this, ThankYouActivity.class);
        startActivity(i);
        speak("");
    }
    public void Back(View view) {
        Intent i = new Intent(VoiceToTextActivity.this, CallTimerActivity.class);
        startActivity(i);
        speak("");
    }
}
