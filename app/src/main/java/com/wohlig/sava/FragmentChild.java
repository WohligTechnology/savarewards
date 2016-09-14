package com.wohlig.sava;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DAT on 9/1/2015.
 */
public class FragmentChild extends Fragment {
    String childname;
    TextView textViewChildName;
    EditText editText;
    TextView regular,light;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Bundle bundle = getArguments();
        childname = bundle.getString("data");
        getIDs(view);
        setEvents();
        return view;
    }

    private void getIDs(View view) {
//        textViewChildName = (TextView) view.findViewById(R.id.textViewChild);
//        textViewChildName.setText(childname);
//        editText = (EditText) view.findViewById(R.id.editText);
//        editText.setText("");
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

    }

    private void setEvents() {

    }
}
