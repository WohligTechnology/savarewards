package com.wohlig.sava;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Mahesh on 8/11/2016.
 */
public class Nav_draw extends Fragment {
    RelativeLayout categories,header;
    LinearLayout subcategories;
    ImageView imageView1;
    Button bsignup,blogin;
    RelativeLayout notification;
    View view;
    LinearLayout setting,about,help,all_offer,saved_offers,cafe,restaurants,lunch,bars,gas_stations;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.nav_draw, container, false);
        notification= (RelativeLayout) view.findViewById(R.id.notifications);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",3);
                startActivity(intent);
            }
        });
        categories = (RelativeLayout) view.findViewById(R.id.categories1);
        subcategories = (LinearLayout) view.findViewById(R.id.sub_categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "categories", Toast.LENGTH_SHORT).show();
                subcategories.setVisibility(subcategories.isShown() ? View.GONE : View.VISIBLE);

            }
        });
        setting = (LinearLayout) view.findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "setting", Toast.LENGTH_SHORT).show();

            }
        });
        about = (LinearLayout) view.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "about", Toast.LENGTH_SHORT).show();

            }
        });
        help = (LinearLayout) view.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "help", Toast.LENGTH_SHORT).show();

            }
        });
        all_offer = (LinearLayout) view.findViewById(R.id.all_offers);
        all_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",2);
                startActivity(intent);
                Toast.makeText(getActivity(), "all_offer", Toast.LENGTH_SHORT).show();

            }
        });
        saved_offers = (LinearLayout) view.findViewById(R.id.saved_offers);
        saved_offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",2);
                startActivity(intent);
                Toast.makeText(getActivity(), "saved_offers", Toast.LENGTH_SHORT).show();

            }
        });
        cafe = (LinearLayout) view.findViewById(R.id.cafe);
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "cafe", Toast.LENGTH_SHORT).show();

            }
        });
        restaurants = (LinearLayout) view.findViewById(R.id.restaurants);
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "restaurants", Toast.LENGTH_SHORT).show();

            }
        });
        lunch = (LinearLayout) view.findViewById(R.id.lunch);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "lunch", Toast.LENGTH_SHORT).show();

            }
        });
        bars = (LinearLayout) view.findViewById(R.id.bars);
        bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "bars", Toast.LENGTH_SHORT).show();

            }
        });
        gas_stations = (LinearLayout) view.findViewById(R.id.gas_stations);
        gas_stations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "gas_stations", Toast.LENGTH_SHORT).show();

            }
        });
        header= (RelativeLayout) view.findViewById(R.id.header);
        imageView1 = (ImageView) header.findViewById(R.id.pencil);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalDetailActivity.class);
                startActivity(intent);
            }
        });
        bsignup = (Button) view.findViewById(R.id.bsignup);
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SingUpActivity.class);
                startActivity(intent);
            }
        });
        blogin = (Button) view.findViewById(R.id.blogin);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
