package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

/**
 * Created by Mahesh on 8/tag2/2016.
 */
public class Test extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    DotIndicator indicator;
    RelativeLayout im_new;
    TextView skip;
    RelativeLayout fb,gplus,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_welcome);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        indicator= (DotIndicator) findViewById(R.id.indicator);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i= viewPager.getCurrentItem();
                indicator.setSelectedItem(i,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        im_new= (RelativeLayout) findViewById(R.id.im_new);
        im_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),SingUpActivity.class);
                startActivity(i);

            }
        });
        skip= (TextView) findViewById(R.id.txt_skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),SavaActivity.class);
                i.putExtra("login",1);
                startActivity(i);
            }
        });
        fb= (RelativeLayout) findViewById(R.id.rel_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MobileVerificationActivity.class);
                startActivity(i);
            }
        });
        gplus= (RelativeLayout) findViewById(R.id.rel_gplus);
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MobileVerificationActivity.class);
                startActivity(i);
            }
        });
        email= (RelativeLayout) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MobileVerificationActivity.class);
                startActivity(i);
            }
        });



    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new One(), "1");
        adapter.addFragment(new One(), "2");
        adapter.addFragment(new One(), "3");
        adapter.addFragment(new One(), "4");
        viewPager.setAdapter(adapter);
    }



}
