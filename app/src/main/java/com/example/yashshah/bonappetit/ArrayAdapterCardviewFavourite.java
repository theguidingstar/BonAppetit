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

import static android.view.View.GONE;


public class ArrayAdapterCardviewFavourite extends RecyclerView.Adapter<ArrayAdapterCardviewFavourite.MyViewHolder> {

    Context mContext;
    private static LayoutInflater inflater=null;
    ArrayList<details> mArrayListall;
    private ArrayList<details> arraylist= new ArrayList<details>();
    int Position;
    public static int fav_count=1;
    private static DBHelper mydb;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView CardView_hotel_Name, Room_type_cardview,radioButton_cardView,Open_Close_cardView,CardView_address;
        public ImageView Hotel_image_Cardview,imageView_fav_image;
        public RelativeLayout relativelayout_cardview;


        public MyViewHolder(View view) {
            super(view);
            Hotel_image_Cardview = (ImageView) view.findViewById(R.id.Hotel_image_Cardview_fav);
            CardView_hotel_Name = (TextView) view.findViewById(R.id.CardView_hotel_Name_fav);
            radioButton_cardView = (TextView) view.findViewById(R.id.radioButton_cardView_fav);
            Open_Close_cardView=(TextView)view.findViewById(R.id.Open_Close_cardView_fav);
            CardView_address=(TextView)view.findViewById(R.id.CardView_address_fav);
            relativelayout_cardview=(RelativeLayout)view.findViewById(R.id.relativelayout_cardview_fav);
            imageView_fav_image=(ImageView)view.findViewById(R.id.imageView_fav);
        }
    }


    public ArrayAdapterCardviewFavourite(Context mContext, ArrayList<details> mArrayListall) {
        this.mContext = mContext;
        this.mArrayListall=mArrayListall;
        arraylist.addAll(mArrayListall);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_favourite_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        mydb=new DBHelper(mContext);
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
        if(arraylist.get(position).getRating()<=5.0&&arraylist.get(position).getRating()>=4.5)
        {
            holder.radioButton_cardView.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);;
            holder.Open_Close_cardView.setText("Open Now");
            holder.Open_Close_cardView.setTextColor(Color.parseColor("#185116"));
        }
        holder.radioButton_cardView.setClickable(false);
        Position=position;

        holder.imageView_fav_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fav_count%2==0) {
                    holder.imageView_fav_image.setImageResource(R.drawable.ic_favdone);
                    mydb.updateFav(arraylist.get(Position).getHotel_name().toString(),"true");
                }
                if(fav_count%2!=0)
                {
                    holder.imageView_fav_image.setImageResource(R.drawable.ic_fav);
                    mydb.updateFav(arraylist.get(Position).getHotel_name().toString(),"false");
                }
                fav_count++;
            }
        });
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}