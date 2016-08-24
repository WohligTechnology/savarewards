package com.wohlig.sava;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adiam on 7/13/2016.
 */
public class MyLoyaltyAdapter extends RecyclerView.Adapter<MyLoyaltyAdapter.ViewHolder> {

    List<Integer> loyaltyIcon;
    List<String> loyaltyText1;
    List<String> loyaltyText2;
    List<String> loyaltyPointsText;
    List<Integer> loyaltyPointsIcon;
    List<String> dateTime;
    List<Integer> loyaltyStamps1;List<Integer> loyaltyStamps2;
    List<Integer> loyaltyStamps3;List<Integer> loyaltyStamps4;
    List<Integer> loyaltyStamps5;List<Integer> loyaltyStamps6;
    List<Integer> loyaltyStamps7;List<Integer> loyaltyStamps8;
    List<Integer> loyaltyStamps9;List<Integer> loyaltyStamps10;
    List<Integer> loyaltyStamps11;List<Integer> loyaltyStamps12;
    List<Integer> loyaltyStamps13;List<Integer> loyaltyStamps14;
    List<Integer> loyaltyStamps15;
    Context mContext;


    public MyLoyaltyAdapter(List<Integer> loyaltyIcon, List<String> loyaltyText1, List<String> loyaltyText2,
                            List<String> loyaltyPointsText, List<Integer> loyaltyPointsIcon,
                            List<String> dateTime, List<Integer> loyaltyStamps1,
                            List<Integer> loyaltyStamps2,List<Integer> loyaltyStamps3,
                            List<Integer> loyaltyStamps4,List<Integer> loyaltyStamps5,
                            List<Integer> loyaltyStamps6,List<Integer> loyaltyStamps7,
                            List<Integer> loyaltyStamps8,List<Integer> loyaltyStamps9,
                            List<Integer> loyaltyStamps10,List<Integer> loyaltyStamps11,
                            List<Integer> loyaltyStamps12,List<Integer> loyaltyStamps13,
                            List<Integer> loyaltyStamps14, List<Integer> loyaltyStamps15,Context mContext) {
        this.loyaltyIcon = loyaltyIcon;
        this.loyaltyText1 = loyaltyText1;
        this.loyaltyText2 = loyaltyText2;
        this.loyaltyPointsText = loyaltyPointsText;
        this.loyaltyPointsIcon = loyaltyPointsIcon;
        this.dateTime = dateTime;
        this.loyaltyStamps1 = loyaltyStamps1;
        this.loyaltyStamps2 = loyaltyStamps2;
        this.loyaltyStamps3 = loyaltyStamps3;
        this.loyaltyStamps4 = loyaltyStamps4;
        this.loyaltyStamps5 = loyaltyStamps5;this.loyaltyStamps6 = loyaltyStamps6;
        this.loyaltyStamps7 = loyaltyStamps7;this.loyaltyStamps8 = loyaltyStamps8;
        this.loyaltyStamps9 = loyaltyStamps9;this.loyaltyStamps10 = loyaltyStamps10;
        this.loyaltyStamps11 = loyaltyStamps11;this.loyaltyStamps12 = loyaltyStamps12;
        this.loyaltyStamps13 = loyaltyStamps13;this.loyaltyStamps14 = loyaltyStamps14;
        this.mContext = mContext;
    }


    @Override
    public MyLoyaltyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CardView cardView = (CardView) inflater.inflate(R.layout.loyalty_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(cardView,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyLoyaltyAdapter.ViewHolder holder, int position) {
        holder.loyaltyText1.setText(loyaltyText1.get(position));
        holder.loyaltyIcon.setImageResource(loyaltyIcon.get(position));
        holder.loyaltyText2.setText(loyaltyText2.get(position));
        holder.loyaltyPointsText.setText(loyaltyPointsText.get(position));
        holder.loyaltyIcon.setVisibility(View.VISIBLE);
        holder.loyaltyPointsIcon.setImageResource(loyaltyPointsIcon.get(position));
        if(holder.loyaltyText1.getText() == "McDonalds"){
            holder.loyaltyStamps1.setVisibility(View.VISIBLE);
            holder.loyaltyStamps2.setVisibility(View.VISIBLE);
            holder.loyaltyStamps3.setVisibility(View.VISIBLE);
            holder.loyaltyStamps4.setVisibility(View.VISIBLE);
            holder.loyaltyStamps5.setVisibility(View.VISIBLE);
            holder.loyaltyStamps6.setVisibility(View.VISIBLE);
            holder.loyaltyStamps7.setVisibility(View.VISIBLE);
            holder.loyaltyStamps8.setVisibility(View.VISIBLE);
            holder.loyaltyStamps9.setVisibility(View.VISIBLE);
            holder.loyaltyStamps10.setVisibility(View.VISIBLE);
            holder.loyaltyStamps11.setVisibility(View.VISIBLE);
            holder.loyaltyStamps12.setVisibility(View.VISIBLE);
            holder.loyaltyStamps13.setVisibility(View.VISIBLE);
            holder.loyaltyStamps14.setVisibility(View.VISIBLE);
            holder.loyaltyStamps15.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return loyaltyText1.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView loyaltyText1, loyaltyText2, loyaltyPointsText, dateTime;
        ImageView loyaltyIcon, loyaltyPointsIcon,loyaltyStamps1,loyaltyStamps2,loyaltyStamps3,loyaltyStamps4,
        loyaltyStamps5,loyaltyStamps6,loyaltyStamps7,loyaltyStamps8,loyaltyStamps9,loyaltyStamps10,
                loyaltyStamps11,loyaltyStamps12,loyaltyStamps13,loyaltyStamps14,loyaltyStamps15;
        Context mCOntext;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.mCOntext = context;
            loyaltyText1 = (TextView) itemView.findViewById(R.id.loyalty_text1);
            loyaltyIcon = (ImageView) itemView.findViewById(R.id.loyalty_icon);
            loyaltyText2 = (TextView) itemView.findViewById(R.id.loyalty_text2);
            loyaltyPointsText = (TextView) itemView.findViewById(R.id.loyalty_points);
            loyaltyPointsIcon = (ImageView) itemView.findViewById(R.id.loyalty_score);
            loyaltyStamps1 = (ImageView) itemView.findViewById(R.id.loyalty_stamp1);
            loyaltyStamps2 = (ImageView) itemView.findViewById(R.id.loyalty_stamp2);
            loyaltyStamps3 = (ImageView) itemView.findViewById(R.id.loyalty_stamp3);
            loyaltyStamps4 = (ImageView) itemView.findViewById(R.id.loyalty_stamp4);
            loyaltyStamps5 = (ImageView) itemView.findViewById(R.id.loyalty_stamp5);
            loyaltyStamps6 = (ImageView) itemView.findViewById(R.id.loyalty_stamp6);
            loyaltyStamps7 = (ImageView) itemView.findViewById(R.id.loyalty_stamp7);
            loyaltyStamps8 = (ImageView) itemView.findViewById(R.id.loyalty_stamp8);
            loyaltyStamps9 = (ImageView) itemView.findViewById(R.id.loyalty_stamp9);
            loyaltyStamps10 = (ImageView) itemView.findViewById(R.id.loyalty_stamp10);
            loyaltyStamps11 = (ImageView) itemView.findViewById(R.id.loyalty_stamp11);
            loyaltyStamps12 = (ImageView) itemView.findViewById(R.id.loyalty_stamp12);
            loyaltyStamps13 = (ImageView) itemView.findViewById(R.id.loyalty_stamp13);
            loyaltyStamps14 = (ImageView) itemView.findViewById(R.id.loyalty_stamp14);
            loyaltyStamps15 = (ImageView) itemView.findViewById(R.id.loyalty_stamp15);
            dateTime = (TextView) itemView.findViewById(R.id.date_time);


            Typeface myCustomFont2 = Typeface.createFromAsset(mCOntext.getAssets(), "fonts/Lato-Regular.ttf");
            Typeface myCustomFont3 = Typeface.createFromAsset(mCOntext.getAssets(),"fonts/Lato-Bold.ttf");
            //Typeface myCustomFont4=Typeface.createFromAsset(mCOntext.getAssets(),"fonts/Lato-Thin.ttf");
            loyaltyText1.setTypeface(myCustomFont3);
            loyaltyText2.setTypeface(myCustomFont2);
            loyaltyText2.setTypeface(myCustomFont2);
            dateTime.setTypeface(myCustomFont2);

        }
    }
}
