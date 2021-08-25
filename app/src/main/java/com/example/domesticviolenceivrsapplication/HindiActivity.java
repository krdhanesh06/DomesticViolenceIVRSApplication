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

public class HindiActivity extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    Button LogOUT ;
    TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);
        Email = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);
        Intent intent = getIntent();
        initializeTextToSpeech();

    }
    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(HindiActivity.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    //myTTS.setLanguage(Locale.US);
                    myTTS.setSpeechRate(1f);
                    myTTS.setLanguage(new Locale("hi"));

                    speak("नमस्कार ! आपने हिंदी को अपनी भाषा के रूप में चुना है। यदि आप घरेलू हिंसा से पीड़ित हैं तो १ दबाएं।"); //१ २ ३ ४ ५ ६ ७ ८ ९ ०
                    // speak("Hello! I'm IVRS.    I'm ready.    Please tell me, how i can help you? Choose your language." +
                    // "   Press 1 for Hindi and 2 for English .");
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
        myTTS.setLanguage(new Locale("hi")); //१ २ ३ ४ ५ ६ ७ ८ ९ ०
        myTTS.setSpeechRate(1f);
        speak("आप किस घरेलू हिंसा से पीड़ित हैं ? अपना विकल्प चुनें, शारीरिक शोषण के लिए २ दबाएँ, मौखिक और भावनात्मक हिंसा के लिए ३ दबाएँ, आर्थिक हिंसा के लिए ४ दबाएँ, यौन शोषण के लिए ५ दबाएँ अन्यथा ६ दवाएं ");


    }

    public void onClickMethod2(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("२");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("आपने शारीरिक शोषण घरेलू हिंसा को चुना है जैसे पिटाई, थप्पड़ मारना, पीटना, मारना, लात मारना आदि। जानकारी देने के लिए धन्यवाद, आपकी जानकारी के अनुसार, हम इस पर काम कर रहे हैं और जल्द ही आपकी सहायता की जाएगी। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो।");

    }
    public void onClickMethod3(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("३");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("आपने मौखिक और भावनात्मक हिंसा को चुना है जैसे अपमान, चरित्र और आचरण का आरोप, उत्पीड़न, लड़का नहीं होना, दहेज के नाम पर अत्याचार आदि। जानकारी देने के लिए धन्यवाद, आपकी जानकारी के अनुसार, हम इस पर काम कर रहे हैं और आप जल्द ही सहायता की जाएगी। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो !");
    }

    public void onClickMethod4(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("४");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("आपने आर्थिक हिंसा को घरेलू हिंसा के रूप में चुना है जैसे कि आपको पैसे या संसाधन देने के लिए आपको या आपके बच्चे की देखभाल करने के लिए, उन्हें घर से बाहर निकालने के लिए नहीं, आदि। जानकारी देने के लिए धन्यवाद, आपकी जानकारी के अनुसार, हम इस पर काम कर रहे हैं। जल्द ही आपकी सहायता की जाएगी। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो !");

    }
    public void onClickMethod5(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("५");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("आपने लिंग हिंसा को घरेलू हिंसा जैसे बलात्कार या जबरन यौन संबंध और बच्चों के साथ यौन शोषण के लिए चुना है। जानकारी देने के लिए धन्यवाद, आपकी जानकारी के अनुसार, हम इस पर काम कर रहे हैं और जल्द ही आपकी सहायता की जाएगी। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो !");
//१ २ ३ ४ ५ ६ ७ ८ ९ ०
    }
    public void onClickMethod6(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("६");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("क्या आप हमारे तकनीशियन से बात करना चाहेंगे? नहीं  के लिए 0 दबाएं, हां के लिए ८।");

    }
    public void onClickMethod7(View view) {

        EditText editText = findViewById(R.id.editText3);
        editText.setText("७");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("क्षमा करें, आपने गलत विकल्प चुना है। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो!");
    }
    public void onClickMethod8(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("८");
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917563015402"));
        startActivity(intent);
        myTTS.setLanguage(new Locale("hi"));
        speak("");
    }
    public void onClickMethod9(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("९");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("क्षमा करें, आपने गलत विकल्प चुना है। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो!");
    }
    public void onClickMethod10(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("०");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो!");
    }
    public void onClickMethod11(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("*");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("क्षमा करें, आपने गलत विकल्प चुना है। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो!");
    }
    public void onClickMethod12(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("#");
        myTTS.setSpeechRate(1f);
        myTTS.setLanguage(new Locale("hi"));
        speak("क्षमा करें, आपने गलत विकल्प चुना है। आईवीआरएस में कॉल करने के लिए धन्यवाद। आपका दिन शुभ हो!");
    }
    public void Clear(View view) {
        EditText editText = findViewById(R.id.editText3);
        editText.setText("");
        myTTS.setLanguage(new Locale("hi"));
        speak("क्लियर");
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
        myTTS.setSpeechRate(0.9f);
        speak("Not Applicable.");
        //myTTS.shutdown();
    }*/
    public void Next(View view) {
        Intent i = new Intent(HindiActivity.this, DialerActivity.class);
        startActivity(i);
        speak("");
    }

    public void Back(View view) {
        Intent i = new Intent(HindiActivity.this, LanguagesActivity.class);
        startActivity(i);
        speak("");
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
        Intent i = new Intent(HindiActivity.this, CallRecorderActivity.class);
        startActivity(i);
        speak("");
    }
}
