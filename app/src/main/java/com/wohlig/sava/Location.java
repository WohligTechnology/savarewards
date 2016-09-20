package com.wohlig.sava;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mahesh on 8/12/2016.
 */
public class Location extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    TextView save;
    EditText etadd1, etadd2, ettown, etcity, etpincode, etcountry;
    String add1, add2, town, city, pincode, country;
    RelativeLayout filllocation;
    LocationManager location_manager;
    String getLatitude;
    String getLongitude;
    ImageView back;


    double x;
    double y;

    Geocoder geocoder;
    List<android.location.Address> addresses;
    android.location.Location loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("Location");
//        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left5));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //What to do on back clicked
//                finish();
//            }
//        });

        location_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        etadd1 = (EditText) findViewById(R.id.etadd1);
        etadd2 = (EditText) findViewById(R.id.etadd2);
        etcity = (EditText) findViewById(R.id.etcity);
        etcountry = (EditText) findViewById(R.id.etcountry);
        ettown = (EditText) findViewById(R.id.ettown);
        etpincode = (EditText) findViewById(R.id.etpincode);
        filllocation= (RelativeLayout) findViewById(R.id.filllocation);
        filllocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationListener listner = new MyLocationListner();
                location_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                location_manager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 0, 0, listner);
            }
        });
        back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        save = (TextView) findViewById(R.id.saveadd);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Address = String.valueOf(etadd1.getText()) + ",\n" + String.valueOf(etadd2.getText()) + ",\n" + String.valueOf(ettown.getText()) + "," + String.valueOf(etcity.getText()) + "-" + String.valueOf(etpincode.getText()) + "," + String.valueOf(etcountry.getText());
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Location", Address); //This is for a String
                i.setClass(getApplicationContext(), PersonalDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


    }
    public class MyLocationListner implements LocationListener {

        @SuppressWarnings("static-access")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onLocationChanged(android.location.Location location) {
        // TODO Auto-generated method stub

            getLatitude = "" + location.getLatitude();
            getLongitude = "" + location.getLongitude();

            /*lati.setText(getLatitude);
            longi.setText(getLongitude);*/

            x = location.getLatitude();
            y = location.getLongitude();

            try {
                geocoder = new Geocoder(Location.this, Locale.ENGLISH);
                addresses = geocoder.getFromLocation(x, y, 1);
//                addresses = geocoder.getFromLocation(x, y, 1);
                StringBuilder str = new StringBuilder();
                if (geocoder.isPresent()) {
                    Toast.makeText(getApplicationContext(),
                            "geocoder present", Toast.LENGTH_SHORT).show();
                    android.location.Address returnAddress = addresses.get(0);

                    String localityString = returnAddress.getLocality();
                    String city = returnAddress.getCountryName();

                    String region_code = returnAddress.getCountryCode();
                    String zipcode = returnAddress.getPostalCode();

                    str.append(localityString + "");
                    str.append(city + "" + region_code + "");
                    str.append(zipcode + "");

/*
                    address.setText(str);
*/
                    etpincode.setText(zipcode);
                    etcountry.setText(city);
                    etcity.setText(localityString);
                    Toast.makeText(getApplicationContext(), str,
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "geocoder not present", Toast.LENGTH_SHORT).show();
                }


// } else {
// Toast.makeText(getApplicationContext(),
// "address not available", Toast.LENGTH_SHORT).show();
// }
            } catch (IOException e) {
// TODO Auto-generated catch block

                Log.e("tag", e.getMessage());
            }

        }

        @Override
        public void onProviderDisabled(String arg0) {
// TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String arg0) {
// TODO Auto-generated method stub

        }

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
// TODO Auto-generated method stub

        }

    }
}