package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MarwadiActivity extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    Button LogOUT ;
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marwadi);
        Email = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);
        Intent intent = getIntent();
        initializeTextToSpeech();
//////////////////////////////////////////////////////////////////////////here hhave to change welcome activity .UserEmail
      /*  EmailHolder = intent.getStringExtra(LoginActivity.UserEmail);

        Email.setText(Email.getText().toString()+ EmailHolder);

        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(MarwadiActivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MarwadiActivity.this, WelcomeActivity.class);
                startActivity(i);

            }
        });*/
    }
    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(MarwadiActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setSpeechRate(1f);
                    myTTS.setLanguage(new Locale("hi"));

                    speak("Mahnne Marwari seekhno hai.");

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
    //??? ??? ??? ??? ??? ??? ??? ??? ??? ???
    public void onClickMethod(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setLanguage(new Locale("hi"));
        myTTS.setSpeechRate(1f);



        speak("???");

    }

    public void onClickMethod2(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setLanguage(new Locale("hi"));
        myTTS.setSpeechRate(1f);



        speak("???");

    }
    public void onClickMethod3(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");
    }

    public void onClickMethod4(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");

    }
    public void onClickMethod5(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");

    }
    public void onClickMethod6(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");

    }
    public void onClickMethod7(View view) {

        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");

    }//??? ??? ??? ??? ??? ??? ??? ??? ??? ???
    public void onClickMethod8(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");
    }
    public void onClickMethod9(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");
    }
    public void onClickMethod10(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("???");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???");
    }
    public void onClickMethod11(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("*");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("???????????????????????????");
    }
    public void onClickMethod12(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("#");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("????????? ????????? ");
    }
    public void Clear(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(new Locale("hi"));
        speak("??????????????????");
    }
    public void Stop(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(new Locale("hi"));
        //super.onPause();
        speak("");
        //myTTS.shutdown();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // myTTS.shutdown();
    }
   /* public void onClickMethod15(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.callOnClick();
        // Jio customer care no "18008899999"
        dialContactPhone("18008899999");
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

    }

    */

    /* public void NotApplicable(View view) {
         EditText editText = findViewById(R.id.editText3);
         editText.setText("");
         myTTS.setLanguage(Locale.US);
         //super.onPause();
         myTTS.setSpeechRate(1f);
         speak("Not Applicable.");
         //myTTS.shutdown();
     }*/
    public void Next(View view) {
        Intent i = new Intent(MarwadiActivity.this, DialerActivity.class);
        startActivity(i);
        speak("");
    }

    public void Back(View view) {
        speak("");
        finish();
    }

    public void Call(View view) {

        EditText editText = findViewById(R.id.editText3);
        editText.callOnClick();
        // Jio customer care no "18008899999"
        dialContactPhone(" ");
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

    }

    public void Recorder(View view) {
        Intent i = new Intent(MarwadiActivity.this, CallRecorderActivity.class);
        startActivity(i);
        speak("");
    }
}
