package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by adiam on 6/20/2016.
 */
public class qr4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_4);

    }
    public void qr4Page(View view){
        Intent intent = new Intent(this,qr2.class);
        startActivity(intent);
    }

}
