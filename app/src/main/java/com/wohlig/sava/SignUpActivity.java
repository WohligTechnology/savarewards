package com.wohlig.sava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mahesh on 7/30/2016.
 */
public class SignUpActivity extends Activity {
    EditText edt_password;
    ImageView eye_open,info;
    Button button3;
    ImageView left;
    boolean pass = false;
    CheckBox cb_tc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        cb_tc= (CheckBox) findViewById(R.id.cb_tc2);

        if (cb_tc != null) {
            cb_tc.setMovementMethod(LinkMovementMethod.getInstance());
        }
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_password.setTransformationMethod(new PasswordTransformationMethod());
        eye_open = (ImageView) findViewById(R.id.eye);
        eye_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!pass) {
                    edt_password.setTransformationMethod(null);
                    edt_password.setSelection(edt_password.getText().length());
                    pass = true;
                } else {
                    edt_password.setTransformationMethod(new PasswordTransformationMethod());
                    edt_password.setSelection(edt_password.getText().length());
                    pass = false;
                }
            }
        });
        info = (ImageView) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "short length", Toast.LENGTH_SHORT).show();
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mobile_verificationActivity.class);
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
