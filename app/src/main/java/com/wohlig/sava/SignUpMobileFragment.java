package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mahesh on 7/30/2016.
 */
public class SignUpMobileFragment extends AppCompatActivity {
    View view;
    ImageView left;
    ImageView edit;
    Button next;
    TextView digit;
    int mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_mobile_verification);
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
                i.putExtra("value",2);
                startActivity(i);
            }
        });
        digit = (TextView) findViewById(R.id.txt_digit);


    }
}
