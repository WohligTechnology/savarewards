package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mahesh on 7/30/2016.
 */
public class SignUpMobileFragment extends AppCompatActivity {
    View view;
    ImageView left;
    ImageView edit;
    Button next;
    TextView digit,mob;
    int mobile;
    EditText etotp;
    private static final String FORMAT = "%01d:%02d";

    int seconds , minutes;

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

                digit.setText("done!");
            }

        }.start();



    }
}
