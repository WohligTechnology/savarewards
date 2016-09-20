package com.wohlig.sava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adiam on 6/17/2016.
 */
public class CongratesForstamp extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.tag,
            R.drawable.tag,
            R.drawable.tag
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratesforstamp);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ImageView share_icon= (ImageView) findViewById(R.id.share_icon);
        share_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                  /*  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/html");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text that will be shared.</p>"));
                    startActivity(Intent.createChooser(sharingIntent,"Share using"));*/

                    Intent sharingIntent1 = new Intent(Intent.ACTION_SEND);
                    Uri screenshotUri = Uri.parse("http://sudarmuthu.com/wp/wp-content/uploads/2011/01/sharing-content-android.png");
                    sharingIntent1.setType("image/png");
                    sharingIntent1.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                    startActivity(Intent.createChooser(sharingIntent1, "Share image using"));

                }
                catch(Exception e)
                { //e.toString();
                }
            }
        });

    }
    public void qr3Page(View view){
        Intent intent = new Intent(this,ConfirmRedemption.class);
        startActivity(intent);
    }


    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Card A");
        adapter.addFragment(new OneFragment(), "Card B");
        adapter.addFragment(new OneFragment(), "Card C");



        viewPager.setAdapter(adapter);
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


    }
