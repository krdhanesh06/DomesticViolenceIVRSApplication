package com.example.domesticviolenceivrsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DialerActivity extends AppCompatActivity {
    EditText etDailpad;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        etDailpad = (EditText) findViewById(R.id.etDailpad);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }

    public void Call(View view) {

        String phoneNo = etDailpad.getText().toString();
        try {
            switch (view.getId()) {

                // switch (v.getId()) {
                case R.id.btnAsterisk:
                    tvInfo.setText("");
                    phoneNo += "*";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.btnHashtag:
                    tvInfo.setText("");
                    phoneNo += "#";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button0:
                    tvInfo.setText("");
                    phoneNo += "0";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button1:
                    tvInfo.setText("");
                    phoneNo += "1";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button2:
                    tvInfo.setText("");
                    phoneNo += "2";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button3:
                    tvInfo.setText("");
                    phoneNo += "3";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button4:
                    tvInfo.setText("");
                    phoneNo += "4";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button5:
                    tvInfo.setText("");
                    phoneNo += "5";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button6:
                    tvInfo.setText("");
                    phoneNo += "6";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button7:
                    tvInfo.setText("");
                    phoneNo += "7";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button8:
                    tvInfo.setText("");
                    phoneNo += "8";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.button9:
                    tvInfo.setText("");
                    phoneNo += "9";
                    etDailpad.setText(phoneNo);
                    break;
                case R.id.tvInfo:
                    tvInfo.setText("");
                    if (phoneNo != null && phoneNo.length() > 0) {
                        phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
                    }

                    etDailpad.setText(phoneNo);
                    break;
                case R.id.btnDelete:
                    tvInfo.setText("");
                    if (phoneNo != null && phoneNo.length() > 0) {
                        phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
                    }

                    etDailpad.setText(phoneNo);
                    break;
                case R.id.btnCall:
                    if (phoneNo.trim().equals("")) {
                        tvInfo.setText("Please enter a valid number.");
                    } else {
                        Boolean isHash = false;
                        if (phoneNo.subSequence(phoneNo.length() - 1, phoneNo.length()).equals("#")) {
                            phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
                            String callInfo = "tel:" + phoneNo + Uri.encode("#");
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse(callInfo));
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
                            startActivity(callIntent);
                        } else {
                            String callInfo = "tel:" + phoneNo;
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse(callInfo));
                            startActivity(callIntent);
                        }
                    }
                    break;
            }

        } catch (Exception ex) {
        }
    }
    public void Next(View view) {
        Intent i = new Intent(DialerActivity.this, ScheduledCallActivity.class);
        startActivity(i);
    }
    public void Back(View view) {
        Intent i = new Intent(DialerActivity.this, LanguagesActivity.class);
        startActivity(i);
    }

    public void Recorder(View view) {
        Intent i = new Intent(DialerActivity.this, CallRecorderActivity.class);
        startActivity(i);
    }

    public void Clear(View view) {
        tvInfo.setText("");
        etDailpad.setText("");
    }
}