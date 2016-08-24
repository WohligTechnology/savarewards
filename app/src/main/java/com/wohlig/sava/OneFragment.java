package com.wohlig.sava;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OneFragment extends Fragment {

    TextView regular,light;
    View view;


    public OneFragment() {
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

        view =inflater.inflate(R.layout.fragment_one, container, false);

        regular = (TextView) view.findViewById(R.id.rewards);
        regular = (TextView) view.findViewById(R.id.txt_8thstamp);
        regular = (TextView) view.findViewById(R.id.use_now);
        light = (TextView) view.findViewById(R.id.txt_3rdstamp);
        light = (TextView) view.findViewById(R.id.txt_6thstamp);
        light = (TextView) view.findViewById(R.id.txt_10thstamp);
        light = (TextView) view.findViewById(R.id.txt_15thstamp);
        light = (TextView) view.findViewById(R.id.txt_visited);

        Typeface myCustomFont2=Typeface.createFromAsset(getContext().getAssets(),"fonts/Lato-Regular.ttf");
        Typeface myCustomFont3=Typeface.createFromAsset(getContext().getAssets(),"fonts/Lato-Light.ttf");


        regular.setTypeface(myCustomFont2);
        light.setTypeface(myCustomFont3);

        return inflater.inflate(R.layout.fragment_one, container, false);
    }


}
