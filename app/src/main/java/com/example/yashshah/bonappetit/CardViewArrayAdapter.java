package com.example.yashshah.bonappetit;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class CardViewArrayAdapter extends RecyclerView.Adapter<CardViewArrayAdapter.MyViewHolder> {

    Context mContext;
    private static LayoutInflater inflater=null;
    ArrayList<details> mArrayListall;
    private ArrayList<details> arraylist= new ArrayList<details>();
    int Position;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView CardView_hotel_Name,radioButton_cardView,Open_Close_cardView,CardView_address;
        public ImageView Hotel_image_Cardview;
        public RelativeLayout relativelayout_cardview;

        public MyViewHolder(View view) {
            super(view);
            Hotel_image_Cardview = (ImageView) view.findViewById(R.id.Hotel_image_Cardview);
            CardView_hotel_Name = (TextView) view.findViewById(R.id.CardView_hotel_Name);
            radioButton_cardView = (TextView) view.findViewById(R.id.radioButton_cardView);
            Open_Close_cardView=(TextView)view.findViewById(R.id.Open_Close_cardView);
            CardView_address=(TextView)view.findViewById(R.id.CardView_address);
            relativelayout_cardview=(RelativeLayout)view.findViewById(R.id.relativelayout_cardview);
        }
    }


    public CardViewArrayAdapter(Context mContext, ArrayList<details> mArrayListall) {
        this.mContext = mContext;
        this.mArrayListall=mArrayListall;
        arraylist.addAll(mArrayListall);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_row_hotel, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Glide.with(mContext).load(arraylist.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.Hotel_image_Cardview);
        holder.radioButton_cardView.setText(arraylist.get(position).getRating()+"");
        holder.CardView_address.setText(arraylist.get(position).getAddress());
        holder.CardView_hotel_Name.setText(arraylist.get(position).getHotel_name());

        if(arraylist.get(position).getRating()<=2.5&&arraylist.get(position).getRating()>=1.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle);
            holder.Open_Close_cardView.setText("Open Now");
            holder.Open_Close_cardView.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=1.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle);
            holder.Open_Close_cardView.setText("Open Now");
            holder.Open_Close_cardView.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=3.5&&arraylist.get(position).getRating()>=2.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);
            holder.Open_Close_cardView.setText("Open Now");
            holder.Open_Close_cardView.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=4.5&&arraylist.get(position).getRating()>=3.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);
            holder.Open_Close_cardView.setText("Close Now");
            holder.Open_Close_cardView.setTextColor(Color.RED);
        }
        if(arraylist.get(position).getRating()<=5.0 && arraylist.get(position).getRating()>=4.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);;
            holder.Open_Close_cardView.setText("Open Now");
            holder.Open_Close_cardView.setTextColor(Color.parseColor("#185116"));
        }
        holder.radioButton_cardView.setClickable(false);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}