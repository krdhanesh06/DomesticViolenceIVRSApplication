package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import java.util.Locale;

public class EnglishActivity extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    Button LogOUT ;
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        Email = (TextView)findViewById(R.id.textView7);
        LogOUT = (Button)findViewById(R.id.button1);

        Intent intent = getIntent();
        initializeTextToSpeech();
      /*  EmailHolder = intent.getStringExtra(LoginActivity.UserEmail);

        Email.setText(Email.getText().toString()+ EmailHolder);
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(EnglishActivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EnglishActivity.this, WelcomeActivity.class);
                startActivity(i);

            }
        });*/
    }

    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(EnglishActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);

                    // myTTS.setLanguage(new Locale("hi"));
                    myTTS.setSpeechRate(0.9f);
                    // speak("");
                    speak("Hello! I'm IVRS.  You have choosen English as your language. If you suffering from domestic violence then press 1.");
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

    public void onClickMethod(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("1");
        //myTTS.setLanguage(new Locale("hi"));
        myTTS.setLanguage(Locale.US);
        myTTS.setSpeechRate(0.9f);
        //speak("");
        speak("Which domestic violence you are suffering from? Choose your option, Press 2 for physical abuse, Press 3 for oral and emotional violence, Press 4 for economic violence, Press 5 for sexual abuse");

    }

    public void onClickMethod2(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("2");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myTTS.setSpeechRate(0.9f);
                myTTS.setLanguage(Locale.US);
                speak("You have chosen physical abuse domestic violence such as beating, slapping, knocking, knocking, kicking etc. Thanks for giving information, according to your information, we are working on it and you will be assisted soon. Thanks for calling in IVRS. Have a good day. ");

                //Do something after 100ms
            }
        }, 1000);

        finish();
    }
    public void onClickMethod3(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("3");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("You have selected oral and emotional violence domestic violence like humiliation, accusations of character and conduct, harassment not being a boy, torture in the name of dowry etc. Thanks for giving information, according to your information, we are working on it and you will be assisted soon. Thanks for calling in IVRS. Have a good day !");
    }


    public void onClickMethod4(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("4");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("You have chosen economic violence domestic violence such as not giving you money or resources to take care of you or your child, to take them out of the house, etc. Thanks for giving information, according to your information, we are working on it and you will be assisted soon. Thanks for calling in IVRS. Have a good day !");
    }
    public void onClickMethod5(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("5");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("You have selected gender abuse domestic violence such as rape or forced sexual relations, and sexual abuse with children. Thanks for giving information, according to your information, we are working on it and you will be assisted soon. Thanks for calling in IVRS. Have a good day !");

    }
    public void onClickMethod6(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("6");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod7(View view) {

        EditText editText = findViewById(R.id.editText3);
        editText.setText("7");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod8(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("8");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod9(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("9");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod10(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("0");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod11(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("*");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod12(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("#");
        myTTS.setSpeechRate(0.9f);
        myTTS.setLanguage(Locale.US);
        //myTTS.setLanguage(new Locale("hi"));
        speak("Sorry, you have chosen the wrong option. Thanks for calling in IVRS. Have a good day!");
    }
    public void onClickMethod14(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(Locale.US);
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



    public void NotApplicable(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(Locale.US);
        //super.onPause();
        myTTS.setSpeechRate(0.9f);
        speak("Not Applicable.");
        //myTTS.shutdown();
    } */
    public void Next(View view) {
        speak("");
        Intent i = new Intent(EnglishActivity.this, DialerActivity.class);
        startActivity(i);

    }

    public void Back(View view) {
        speak("");
        Intent i = new Intent(EnglishActivity.this, LanguagesActivity.class);
        startActivity(i);

    }


    public void Call(View view) {

            EditText editText = findViewById(R.id.editText3);
            editText.callOnClick();
            // Jio customer care no "18008899999"
            dialContactPhone("+917563015402");
        }
        private void dialContactPhone(final String phoneNumber) {
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

        }


    public void Recorder(View view) {
        Intent i = new Intent(EnglishActivity.this, CallRecorderActivity.class);
        startActivity(i);
        speak("");
    }

    public void Clear(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(Locale.US);
        myTTS.setSpeechRate(0.9f);
        speak("Cleared");

    }
}

