package com.wohlig.sava;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adiam on 7/6/2016.
 */
public class LoyaltyFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_loyalty, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.loyalty_recyclerview);
        recyclerView.setLayoutManager(new CustomGridLayoutManager(getActivity()));

        List<Integer> loyaltyIcon = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.teavilla,
                R.drawable.mac,R.drawable.teavilla,R.drawable.mac,R.drawable.teavilla,R.drawable.mac}));

        List<String> loyaltyText1 = new ArrayList<>(Arrays.asList(new String[]{"Tea Villa",
                "McDonalds","Tea Villa","McDonalds","Tea Villa","McDonalds"}));

        List<String> loyaltyText2 = new ArrayList<>(Arrays.asList(new String[]{"You can redeem three Loyalty offers!!!!",
                "You can redeem one free burger!!!!","You can redeem three Loyalty offers!!!!",
        "You can redeem one free burger!!!!","You can redeem three Loyalty offers!!!!","You can redeem one free burger!!!!"}));

        List<String> loyaltyPointsText = new ArrayList<>(Arrays.asList(new String[]{"500","12/15","500","12/15","500","12/15"}));

        List<Integer> loyaltyPointsIcon = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.coins,R.drawable.red,
                R.drawable.coins,R.drawable.red,R.drawable.coins,R.drawable.red}));

        List<String> dateTime = new ArrayList<>(Arrays.asList(new String[]{"10.30am","12/6/16","10.30am","12/6/16","10.30am","12/6/16",}));

        List<Integer> loyaltyStamps1 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps2 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps3 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps4 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps5 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps6 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps7 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps8 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps9 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps10 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps11 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps12 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps13 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps14 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));
        List<Integer> loyaltyStamps15 = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.red,}));

        MyLoyaltyAdapter myLoyaltyAdapter = new MyLoyaltyAdapter(loyaltyIcon,loyaltyText1,loyaltyText2,
                loyaltyPointsText,loyaltyPointsIcon,dateTime,loyaltyStamps1,loyaltyStamps2,
                loyaltyStamps3,loyaltyStamps4,loyaltyStamps5,loyaltyStamps6,loyaltyStamps7,
                loyaltyStamps8,loyaltyStamps9,loyaltyStamps10,loyaltyStamps11,
                loyaltyStamps12,loyaltyStamps13,loyaltyStamps14,loyaltyStamps15,getActivity());
        recyclerView.setAdapter(myLoyaltyAdapter);
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecoration(1));
        return view;

    }

    public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mHorizontalSpaceHeight;

        public HorizontalSpaceItemDecoration(int mHorizontalSpaceHeight) {
            this.mHorizontalSpaceHeight = mHorizontalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mHorizontalSpaceHeight;
        }
    }

    public class CustomGridLayoutManager extends LinearLayoutManager {


        public CustomGridLayoutManager(Context context) {
            super(context);
            setOrientation(LinearLayoutManager.VERTICAL);
        }


        @Override
        public boolean canScrollVertically() {
            return false;
        }
    }


}
