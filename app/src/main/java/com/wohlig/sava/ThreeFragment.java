package com.wohlig.sava;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ThreeFragment extends Fragment {

    TextView regular,light;
    View view;


    public ThreeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_three, container, false);


        regular = (TextView) view.findViewById(R.id.rewards3);
        regular = (TextView) view.findViewById(R.id.txt_8thstamp3);
        regular = (TextView) view.findViewById(R.id.use_now3);
        light = (TextView) view.findViewById(R.id.txt_3rdstamp3);
        light = (TextView) view.findViewById(R.id.txt_6thstamp3);
        light = (TextView) view.findViewById(R.id.txt_10thstamp3);
        light = (TextView) view.findViewById(R.id.txt_15thstamp3);
        light = (TextView) view.findViewById(R.id.txt_visited3);

        Typeface myCustomFont2=Typeface.createFromAsset(getContext().getAssets(),"fonts/Lato-Regular.ttf");
        Typeface myCustomFont3=Typeface.createFromAsset(getContext().getAssets(),"fonts/Lato-Light.ttf");


        regular.setTypeface(myCustomFont2);
        light.setTypeface(myCustomFont3);

        return view;
    }


}
