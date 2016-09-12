package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mahesh on 7/30/2016.
 */
public class Mobile_verificationActivity extends AppCompatActivity {
    View view;
    ImageView left;
    ImageView edit;
    Button next;
    TextView digit,mob;
    int mobile;
    EditText etotp;
    private static final String FORMAT = "%01d:%02d";
    Button bresendotp,bcallme;
    int seconds ,minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_mobile_verification);
        Bundle bundle;
        bundle = this.getIntent().getExtras();
        mob= (TextView) findViewById(R.id.txt_mobile_number);
        if(bundle!=null) {
            String phone = bundle.getString("phone");
            mob.setText(phone);

        }
        bresendotp= (Button) findViewById(R.id.bresendotp);
        bcallme= (Button) findViewById(R.id.bcallme);

        left = (ImageView) findViewById(R.id.img_left_arrow);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edit = (ImageView) findViewById(R.id.img_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SavaActivity.class);
                startActivity(i);
            }
        });
        etotp= (EditText) findViewById(R.id.edt_otp);
        etotp.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    if(etotp.getText().equals("123456"))
                    {
                        Intent intent= new Intent(getApplicationContext(), SavaActivity.class);
                        startActivity(intent);
                    }
                }
                return false;
            }
        });
        etotp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    if(etotp.getText().equals("123456"))
                    {
                        Intent intent= new Intent(getApplicationContext(), SavaActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(etotp.getText().equals("123456"))
                {
                    Log.d("ganesh", "onTextChanged: "+etotp.getText());
                    Intent intent= new Intent(getApplicationContext(), SavaActivity.class);
                    startActivity(intent);
                }
            }
        });


        digit = (TextView) findViewById(R.id.txt_digit);
        new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {

                digit.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                bcallme.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bresendotp.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                digit.setText("done!");
            }

        }.start();



    }
}
