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

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {


    List<String> data;
    List<Integer> imgList;
    List<String> address;
    List<String> type;
    Context mContext;

    public MyAdapter2(List<String> data,List<Integer> imgData,List<String> address,List<String> type,Context mContext){
        this.data = data;
        this.imgList = imgData;
        this.address = address;
        this.type= type;
        this.mContext = mContext;
    }

    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CardView cardView = (CardView) inflater.inflate(R.layout.list_item,null);
        ViewHolder viewHolder = new ViewHolder(cardView,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView2.setText(data.get(position));
        holder.imageView.setImageResource(imgList.get(position));
        holder.address.setText(address.get(position));
        holder.type.setText(type.get(position));
        holder.heart.setVisibility(View.VISIBLE);
    }


    @Override
    public int getItemCount()
    {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView2,address,type,distance;
        ImageView imageView,heart,tag,location;
        Context mCOntext;

        public ViewHolder(View itemView,Context context) {
            super(itemView);
            this.mCOntext = context;
            textView2 = (TextView) itemView.findViewById(R.id.free_beer);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            address = (TextView) itemView.findViewById(R.id.home);
            type =(TextView) itemView.findViewById(R.id.type);
            heart  = (ImageView) itemView.findViewById(R.id.heart);
            tag = (ImageView) itemView.findViewById(R.id.tag);
            location = (ImageView) itemView.findViewById(R.id.location_home);
            distance = (TextView) itemView.findViewById(R.id.distance_low);



            Typeface myCustomFont2=Typeface.createFromAsset(mCOntext.getAssets(),"fonts/Lato-Regular.ttf");
            //Typeface myCustomFont4=Typeface.createFromAsset(mCOntext.getAssets(),"fonts/Lato-Thin.ttf");
            textView2.setTypeface(myCustomFont2);
            address.setTypeface(myCustomFont2);
            type.setTypeface(myCustomFont2);

        }
    }



}
