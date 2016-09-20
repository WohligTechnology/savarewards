package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Mahesh on 8/12/2016.
 */
public class Contacts extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    TextView save;
    ImageView back;
    EditText etphone,etemail;
    Spinner spphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("Contacts");
//        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left5));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //What to do on back clicked
//                finish();
//            }
//        });

        etemail= (EditText) findViewById(R.id.etemail);
        etphone= (EditText) findViewById(R.id.etphone);
        spphone= (Spinner) findViewById(R.id.spphone);
        back= (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        save= (TextView) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Phone = String.valueOf(spphone.getSelectedItem())+" "+String.valueOf(etphone.getText()) ;
                String email = String.valueOf(etemail.getText()) ;
                Intent i = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("Phone", Phone); //This is for a String
                bundle.putString("email", email); //This is for a String
                i.setClass(getApplicationContext(), PersonalDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);            }
        });

    }
}
