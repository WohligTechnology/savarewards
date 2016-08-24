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


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<String> data;
    List<Integer> imagList;
    List<Integer> direction;
    List<String> distance;
    Context mContext;

    public MyAdapter(List<String> data,List<Integer> imgList,List<Integer> directn,List<String> distnce,Context mContext){
        this.data = data;
        this.imagList =imgList;
        this.direction = directn;
        this.distance= distnce;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CardView cardView = (CardView) inflater.inflate(R.layout.card_item,null);
        ViewHolder viewHolder = new ViewHolder(cardView,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        holder.imageView.setImageResource(imagList.get(position));
        holder.direction.setImageResource(direction.get(position));
        holder.distance.setText(distance.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,distance;
        ImageView imageView,direction;
        Context mCOntext;

        public ViewHolder(View itemView,Context context) {
            super(itemView);
            this.mCOntext = context;


            textView = (TextView) itemView.findViewById(R.id.info_text);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            direction =(ImageView) itemView.findViewById(R.id.direction);
            distance = (TextView) itemView.findViewById(R.id.distance);
            Typeface myCustomFont3=Typeface.createFromAsset(mCOntext.getAssets(),"fonts/Lato-Light.ttf");
            textView.setTypeface(myCustomFont3);
            distance.setTypeface(myCustomFont3);

        }
    }

}
