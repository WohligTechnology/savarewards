package com.wohlig.sava;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StoreFragment extends Fragment {

    View view;

    private RecyclerView mRecyclerView;

    private RecyclerView mRecyclerView2;

    TextView light;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_screen_activity,container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));

        mRecyclerView2 = (RecyclerView)view.findViewById(R.id.my_recycler_view2);
        mRecyclerView2.setLayoutManager(new CustomGridLayoutManager(getActivity()));


        List<String> data = new ArrayList<>(Arrays.asList(new String[]{"Pizza Hut","McDonald's","Burgerking","Subway"}));
        List<Integer> imageDataOne = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.pizzahut,R.drawable.mcd,R.drawable.burgerking,R.drawable.pizzahut}));
        List<Integer> direction = new ArrayList<>(Arrays.asList(new Integer[]{R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location}));
        List<String> distance = new ArrayList<>(Arrays.asList(new String[]{"10 mi","10 mi","10 mi","10 mi"}));

        List<String> data2 = new ArrayList<>(Arrays.asList(new String[]{"Pizza Hut Plus Restaurant","McDonald's","Burgerking","Subway"}));
        List<String> address = new ArrayList<>(Arrays.asList(new String[]{"31,Opposite Globus,Hill Road Bandra..","32,Gloucester avenue,Ray Road,Khar..","31,Opposite Globus,MGD Road.","31,Opposite Globus,MGD Road Bandra"}));
        List<String> type = new ArrayList<>(Arrays.asList(new String[]{"Italian Restaurants, Pizza","Malaysian Restaurants","German Restaurants, Austrian Re..","American Restaurants"}));

        MyAdapter myAdapter = new MyAdapter(data,imageDataOne,direction,distance,getActivity());
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(10));

        MyAdapter2 myAdapter2 = new MyAdapter2(data2,imageDataOne,address,type,getActivity());
        mRecyclerView2.setAdapter(myAdapter2);
        mRecyclerView2.addItemDecoration(new HorizontalSpaceItemDecoration(2));

        return view;

    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mVerticalSpaceHeight;

        public VerticalSpaceItemDecoration(int mVerticalSpaceHeight) {
            this.mVerticalSpaceHeight = mVerticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.right = mVerticalSpaceHeight;
        }
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
