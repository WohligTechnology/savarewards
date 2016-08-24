package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by adiam on 7/19/2016.
 */
public class MobileVerificationActivity extends AppCompatActivity {
    ImageView left_arrow;
    View view;
    Button button3;
    EditText code,mob_ph;
    String code1,mob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_mobile);
        left_arrow = (ImageView) findViewById(R.id.img_left_arrow);
        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button3= (Button) findViewById(R.id.button31);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),SignUpMobileFragment.class);
                startActivity(i);
            }
        });
        code= (EditText) findViewById(R.id.edt_code);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code1= String.valueOf(code.getText());
            }
        });
        mob_ph= (EditText) findViewById(R.id.edt_mobile);
        mob_ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mob= String.valueOf(mob_ph.getText());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
