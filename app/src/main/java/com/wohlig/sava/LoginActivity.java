package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Mahesh on 8/12/2016.
 */
public class LoginActivity extends AppCompatActivity {
    Button login;
    ImageView eye_open,info;
    EditText edt_password;
    boolean pass = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SavaActivity.class);
                startActivity(intent);
            }
        });
        edt_password = (EditText) findViewById(R.id.et_password);
        edt_password.setTransformationMethod(new PasswordTransformationMethod());
        eye_open = (ImageView) findViewById(R.id.eye1);
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
        info = (ImageView) findViewById(R.id.info1);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "short length", Toast.LENGTH_SHORT).show();
            }
        });

    }
}