package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledCallActivity extends AppCompatActivity {

    private TextView txtDay, txtHour, txtMinute, txtSecond;
    private TextView tvEventStart;
    private Handler handler;
    private Runnable runnable;
    int counter = 3;
    int MY_PERMISSIONS_REQUEST_CALL_PHONE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduled_call);


        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHour = (TextView) findViewById(R.id.txtHour);
        txtMinute = (TextView) findViewById(R.id.txtMinute);
        txtSecond = (TextView) findViewById(R.id.txtSecond);
        tvEventStart = (TextView) findViewById(R.id.tveventStart);
        countDownStart();
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
                    Date fd = sdf.parse("2020-02-15, 11:30:00");//fd = Future Date
                    Date cd = new Date(); //cd = Current Date
                    String number = "+919875487829";
                    Uri call = Uri.parse("tel:" + number);
                    Intent surf = new Intent(Intent.ACTION_CALL, call);

                    if (!cd.after(fd)) {
                        long diff = fd.getTime() - cd.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;


                        txtDay.setText("" + String.format("%02d", days));
                        txtHour.setText("" + String.format("%02d", hours));
                        txtMinute.setText("" + String.format("%02d", minutes));
                        txtSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        tvEventStart.setVisibility(View.VISIBLE);
                        tvEventStart.setText("The event started!");
                        counter--;
                        if (counter == 0) {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    Activity#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for Activity#requestPermissions for more details.
                                    return;
                                }
                            }
                            startActivity(surf);
                            }

                            textViewGone();
                            //counter--;
                            // if (counter == 0){

                            //tvEventStart.callOnClick();


                            //Intent surf = new Intent(Intent.ACTION_CALL, call);
                            //startActivity(surf);

                            // tvEventStart.setText(Integer.toString(counter));
                            // counter--;
                            //  if (counter == 0){
                            //Intent callIntent = new Intent(Intent.ACTION_CALL);
                            //callIntent.setData(Uri.parse("tel:"));
                            //startActivity(callIntent);
                            //callIntent.getAction().endsWith(String.valueOf(callIntent));
                            //tvEventStart.setEnabled(false);
                        }

                        // Toast.makeText(getApplicationContext(),"Successfull.", Toast.LENGTH_SHORT).show();

                        //Intent callIntent = new Intent(Intent.ACTION_CALL);
                        // callIntent.setData(Uri.parse("tel:0377778888"));
                        //startActivity(callIntent);
                        //}

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            handler.postDelayed(runnable, 1 * 1000);
        }

        public void textViewGone() {
            findViewById(R.id.LinearLayout1).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout2).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout3).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout4).setVisibility(View.GONE);

        }


        public void Back(View view) {
            Intent i = new Intent(ScheduledCallActivity.this, DialerActivity.class);
            startActivity(i);
        }

        public void Next(View view) {
            Intent i = new Intent(ScheduledCallActivity.this, CallTimerActivity.class);
            startActivity(i);
        }

    public void Recorder(View view) {
        Intent i = new Intent(ScheduledCallActivity.this, CallRecorderActivity.class);
        startActivity(i);
    }
}
