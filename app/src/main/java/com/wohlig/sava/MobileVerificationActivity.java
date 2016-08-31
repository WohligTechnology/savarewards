package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.hbb20.CountryCodePicker;

/**
 * Created by adiam on 7/19/2016.
 */
public class MobileVerificationActivity extends AppCompatActivity {
    ImageView left_arrow;
    View view;
    Button button3;
    EditText mob_ph;
    Spinner code;
    String code1,mob;
    CountryCodePicker code2;


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

        code= (Spinner) findViewById(R.id.spcode);
        code2= (CountryCodePicker) findViewById(R.id.ccp);
      /*  code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code1= String.valueOf(code.getSelectedItem());
            }
        });*/
        mob_ph= (EditText) findViewById(R.id.edt_mobile);
        mob_ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mob= String.valueOf(mob_ph.getText());
            }
        });
        button3= (Button) findViewById(R.id.button31);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mob= String.valueOf(mob_ph.getText());
                code1= String.valueOf(code.getSelectedItem());
                code2.getSelectedCountryCodeAsInt();

                String phone=code1+" "+mob;
                Intent i= new Intent(getApplicationContext(),SignUpMobileFragment.class);
                Bundle bundle = new Bundle();
                bundle.putString("phone", phone); //This is for a String
                i.setClass(getApplicationContext(), SignUpMobileFragment.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
