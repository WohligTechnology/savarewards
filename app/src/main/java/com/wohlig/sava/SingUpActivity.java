package com.wohlig.sava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Mahesh on 7/30/2016.
 */
public class SingUpActivity extends Activity {
    CheckBox checkBox;
    EditText edt_password;
    ImageView eye_open;
    Button button3;
    ImageView left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        edt_password = (EditText) findViewById(R.id.edt_password);
        eye_open = (ImageView) findViewById(R.id.eye);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpMobileFragment.class);
                startActivity(i);
            }
        });
        left = (ImageView) findViewById(R.id.img_left_arrow);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
