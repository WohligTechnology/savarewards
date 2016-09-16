package com.wohlig.sava;

import android.*;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by adiam on 6/17/2016.
 */
public class ScanningCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    ImageView flash;
    boolean flash1=false;
    EditText etscancode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.scanningcode);
        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.cam_scanner);
        contentFrame.addView(mScannerView);
        etscancode= (EditText) findViewById(R.id.etscancode);
        flash = (ImageView) findViewById(R.id.flash);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flash1) {
                    mScannerView.setFlash(true);
                    flash.setImageResource(R.drawable.flash_on);
                    flash1=true;
                }
                else
                {
                    mScannerView.setFlash(false);
                    flash.setImageResource(R.drawable.flash);

                    flash1=false;
                }
            }
        });

    }

    public void pointsPage(View view){
        Intent intent = new Intent(this,CongratesForstamp.class);
        startActivity(intent);

    }

    public void QrScanner(View view){
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mScannerView.startCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.e("handler", result.getText()); // Prints scan results
        Log.e("handler", result.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
        Log.v("hello", result.getText()); // Prints scan results
        Log.v("hello", result.getBarcodeFormat().toString());
        etscancode.setText(result.getText());

        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        if(checkPermissionForCamera()) {// Register ourselves as a handler for scan results.
            mScannerView.startCamera();
        }// Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Intent intent = new Intent(this,CongratesForstamp.class);
        startActivity(intent);
        super.onActivityResult(requestCode, resultCode, data);

    }
    public boolean checkPermissionForCamera(){
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CAMERA},1);
            return false;
        }}
   /* private ZXingScannerView mScannerView;
    ImageView flash;
    boolean flash1=false;
    EditText etscancode;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.scanningcode);
        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.cam_scanner);
        contentFrame.addView(mScannerView);


        flash = (ImageView) findViewById(R.id.flash);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flash1) {
                    mScannerView.setFlash(true);
                    flash1=true;
                }
                else
                {
                    mScannerView.setFlash(false);
                    flash1=false;
                }
            }
        });

        // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v("hello", rawResult.getText()); // Prints scan results
        Log.v("hello", rawResult.getBarcodeFormat().toString());
        Toast.makeText(ScanningCodeActivity.this, rawResult.getBarcodeFormat().toString()+rawResult.getText(), Toast.LENGTH_SHORT).show();
        // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }*/
}
