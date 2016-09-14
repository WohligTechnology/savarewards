/**
 * Created by adiam on 5/31/2016.
 */

package com.wohlig.sava;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class secondPage extends AppCompatActivity {

    TextView bold,regular,light,thin,medium,semibold;


    private TabLayout tabLayout;
    private ViewPager viewPager;
    CardView burger,pizza;
    RelativeLayout rlviewpager;
    CardView card_view_some_wrong;
    ImageView ivwrong;
    LinearLayout linearLayout;
    ScrollView scrollView;
    Button buttonAddPage;
    FragmentParent fragmentParent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);
        regular = (TextView) findViewById(R.id.pizza_restro);
        regular = (TextView) findViewById(R.id.more_offers);
        regular = (TextView) findViewById(R.id.some_wrong);
        regular = (TextView) findViewById(R.id.see_other_offers);
        regular = (TextView) findViewById(R.id.more_redemption_offers);
        regular = (TextView) findViewById(R.id.ccd_loyalty);
        regular = (TextView) findViewById(R.id.claim_offer);
        regular = (TextView) findViewById(R.id.offers);
        regular = (TextView) findViewById(R.id.fluer);
        regular = (TextView) findViewById(R.id.choco);
        regular = (TextView) findViewById(R.id.chicken);
        regular = (TextView) findViewById(R.id.gold);
        regular = (TextView) findViewById(R.id.points);
        regular = (TextView) findViewById(R.id.submit);
        light = (TextView) findViewById(R.id.phone_number);
        light = (TextView) findViewById(R.id.address_info);
        light = (TextView) findViewById(R.id.menu);
        light = (TextView) findViewById(R.id.other);
        light = (TextView) findViewById(R.id.min_spend_fluer);
        light = (TextView) findViewById(R.id.Modern_Meadow_chicken);
        light = (TextView) findViewById(R.id.modern_meadow_fluer);
        light = (TextView) findViewById(R.id.modern_meadow_choco);
        light = (TextView) findViewById(R.id.expires_choco);
        light = (TextView) findViewById(R.id.expires_in_fluer);
        light = (TextView) findViewById(R.id.expires_in_chicken);
        light = (TextView) findViewById(R.id.cancelled_price_fluer);
        light = (TextView) findViewById(R.id.address);
        light = (TextView) findViewById(R.id.cancelled_price_chicken);
        light = (TextView) findViewById(R.id.expires_in1);
        light = (TextView) findViewById(R.id.websites);
        light = (TextView) findViewById(R.id.Carte_menu);
        light = (TextView) findViewById(R.id.meal_from_menu);
        light = (TextView) findViewById(R.id.total_points);
        light = (TextView) findViewById(R.id.total_points);
        light = (TextView) findViewById(R.id.free_beer);
        light = (TextView) findViewById(R.id.text_33_off);
        light = (TextView) findViewById(R.id.loyalty_statement);
        light = (TextView) findViewById(R.id.comm);
        light = (TextView) findViewById(R.id.more_business_info);
        light = (TextView) findViewById(R.id.distance);
        bold = (TextView) findViewById(R.id.modern_ccd);
        bold = (TextView) findViewById(R.id.free_burger1);
        bold = (TextView) findViewById(R.id.points_5001);
        bold = (TextView) findViewById(R.id.points_6501);
        bold = (TextView) findViewById(R.id.free_pizza1);
        bold = (TextView) findViewById(R.id.free_fluer);
        bold = (TextView) findViewById(R.id.upto);
        bold = (TextView) findViewById(R.id.price_chicken);
        Typeface myCustomFont2=Typeface.createFromAsset(getAssets(),"fonts/Lato-Regular.ttf");
        Typeface myCustomFont3=Typeface.createFromAsset(getAssets(),"fonts/Lato-Light.ttf");
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Lato-Bold.ttf");
        Typeface myCustomFont4=Typeface.createFromAsset(getAssets(),"fonts/Lato-Thin.ttf");
        Typeface myCustomFont5=Typeface.createFromAsset(getAssets(),"fonts/Lato-Medium.ttf");
        Typeface myCustomFont6=Typeface.createFromAsset(getAssets(),"fonts/Lato-Semibold.ttf");
        bold.setTypeface(myCustomFont);
        regular.setTypeface(myCustomFont2);
        light.setTypeface(myCustomFont3);
//
//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        setupViewPager(viewPager);
//
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);

        getIDs();
        setEvents();
        ImageView share_icon= (ImageView) findViewById(R.id.share_icon);
        share_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    getApplicationContext().startActivity(Intent.createChooser(shareIntent, "Share Via"));

                }
                catch(Exception e)
                { //e.toString();
                }
            }
        });

        pizza= (CardView) findViewById(R.id.card_view_pizza1);
        burger= (CardView) findViewById(R.id.card_view_burger1);
        scrollView= (ScrollView) findViewById(R.id.scroll);
        linearLayout= (LinearLayout) findViewById(R.id.linear1);
        rlviewpager = (RelativeLayout) findViewById(R.id.rlviewpager);
        ivwrong= (ImageView) findViewById(R.id.img_arrw_some_wrong);
        card_view_some_wrong = (CardView) findViewById(R.id.card_view_some_wrong);
        card_view_some_wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                if (linearLayout.isShown())
                {
                    ivwrong.setRotation(360);
                    scrollView.scrollTo(0, (int) burger.getY());
                    linearLayout.setVisibility(View.GONE );
                }else{
                    ivwrong.setRotation(180);
                    linearLayout.setVisibility(View.VISIBLE );

                }
//                linearLayout.setVisibility(linearLayout.isShown() ? View.GONE  : View.VISIBLE);

            }
        });

        Intent i=getIntent();
        int j = i.getIntExtra("stamp",0);
        Intent i1=getIntent();

        int j1 = i1.getIntExtra("loyalty",0);
        Log.d("onCreate: ",String.valueOf(j1));

        if(j==1)
        {
            pizza.setVisibility(View.GONE);
            burger.setVisibility(View.GONE);
            rlviewpager.setVisibility(View.VISIBLE);



        }
        if(j1==1)
        {
            scrollView.scrollTo(0, (int) burger.getY());
        }

        if(j==2)
        {
            rlviewpager.setVisibility(View.GONE);
            pizza.setVisibility(View.VISIBLE);
            burger.setVisibility(View.VISIBLE);
        }


    }

    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Card A");
        adapter.addFragment(new OneFragment(), "Card B");
        adapter.addFragment(new OneFragment(), "Card C");

        viewPager.setAdapter(adapter);/*
        View v = getActionBar().getTabAt(0).getCustomView();
        BadgeView badge = new BadgeView(this, v);
        badge.setText("1");
        badge.show();*/
    }
    public void card(View view) {
        Intent intent = new Intent(this, ConfirmRedemption.class);
        startActivity(intent);

    }

    public void points(View view) {
        Intent intent = new Intent(this, ConfirmRedemption1.class);
        startActivity(intent);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void backPage(View view){
        Intent intent = new Intent(this,SavaActivity.class);
        startActivity(intent);
    }
    private void getIDs() {
        buttonAddPage = (Button) findViewById(R.id.buttonAddPage);
        fragmentParent = (FragmentParent) this.getSupportFragmentManager().findFragmentById(R.id.fragmentParent);
        textView = (TextView) findViewById(R.id.editTextPageName);
    }

    private void setEvents() {
        buttonAddPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textView.getText().toString().equals("")) {
                    fragmentParent.addPage(/*textView.getText() +*/ "CARD");
                    textView.setText("");
                } else {
                    Toast.makeText(secondPage.this, "Page name is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
