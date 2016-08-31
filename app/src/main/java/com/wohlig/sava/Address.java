package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Mahesh on 8/12/2016.
 */
public class Address extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    TextView save;
    EditText etadd1, etadd2, ettown, etcity, etpincode, etcountry;
    String add1, add2, town, city, pincode, country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("Address");
//        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left5));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //What to do on back clicked
//                finish();
//            }
//        });
        etadd1 = (EditText) findViewById(R.id.etadd1);
        etadd2 = (EditText) findViewById(R.id.etadd2);
        etcity = (EditText) findViewById(R.id.etcity);
        etcountry = (EditText) findViewById(R.id.etcountry);
        ettown = (EditText) findViewById(R.id.ettown);
        etpincode = (EditText) findViewById(R.id.etpincode);


        save = (TextView) findViewById(R.id.saveadd);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Address = String.valueOf(etadd1.getText()) + ",\n" + String.valueOf(etadd2.getText()) + ",\n" + String.valueOf(ettown.getText()) + "," + String.valueOf(etcity.getText()) + "-" + String.valueOf(etpincode.getText()) + "," + String.valueOf(etcountry.getText());
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Address", Address); //This is for a String
                i.setClass(getApplicationContext(), PersonalDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


    }
}