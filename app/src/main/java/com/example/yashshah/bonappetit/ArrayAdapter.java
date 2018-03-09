package com.example.yashshah.bonappetit;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Yash shah on 19-06-2017.
 */

public class ArrayAdapter extends BaseAdapter {
    Context mContext;
    private static LayoutInflater inflater=null;
    ArrayList<details> mArrayListall;
    private ArrayList<details> arraylist= new ArrayList<details>();
    private int mLastPosition;
    public ArrayAdapter(Context context,ArrayList<details> mArrayListall)

    {
        mContext=context;
        this.mArrayListall=mArrayListall;
        arraylist.addAll(mArrayListall);
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mArrayListall.size();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mArrayListall.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.hotel_list_row,null);

            holder.imageView_hotel = (ImageView) convertView.findViewById(R.id.imageView_Hotel);
            holder.textView_hotel_name = (TextView) convertView.findViewById(R.id.textView_hotel_name);
            holder.radioButton=(TextView)convertView.findViewById(R.id.radioButton);
            holder.Open_Close=(TextView)convertView.findViewById(R.id.Open_Close);
            holder.Address=(TextView)convertView.findViewById(R.id.textView3);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }

        Glide.with(mContext).load(arraylist.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView_hotel);

        holder.textView_hotel_name.setText(arraylist.get(position).getHotel_name());
        System.out.println(arraylist.get(position).getRating());
        holder.radioButton.setText(arraylist.get(position).getRating()+"");
        holder.Address.setText(arraylist.get(position).getAddress());

        if(arraylist.get(position).getRating()<=2.5&&arraylist.get(position).getRating()>=1.5)
        {
            holder.radioButton.setBackgroundResource(R.drawable.onside_rounded_rectangle);
            holder.Open_Close.setText("Open Now");
            holder.Open_Close.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=1.5)
        {
            holder.radioButton.setBackgroundResource(R.drawable.onside_rounded_rectangle);
            holder.Open_Close.setText("Open Now");
            holder.Open_Close.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=3.5&&arraylist.get(position).getRating()>=2.5)
        {
            holder.radioButton.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);
            holder.Open_Close.setText("Open Now");
            holder.Open_Close.setTextColor(Color.parseColor("#185116"));
        }

        if(arraylist.get(position).getRating()<=4.5&&arraylist.get(position).getRating()>=3.5)
        {
            holder.radioButton.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);
            holder.Open_Close.setText("Close Now");
            holder.Open_Close.setTextColor(Color.RED);
        }

        if(arraylist.get(position).getRating()<=5.0&&arraylist.get(position).getRating()>=4.5)
        {
            holder.radioButton.setBackgroundResource(R.drawable.onside_rounded_rectangle_green);
            holder.Open_Close.setText("Open Now");
            holder.Open_Close.setTextColor(Color.parseColor("#185116"));
        }
        holder.radioButton.setClickable(false);

        float initialTranslation = (mLastPosition <= position ? 500f : -500f);

        convertView.setTranslationY(initialTranslation);
        convertView.animate()
                .setInterpolator(new DecelerateInterpolator(1.0f))
                .translationY(0f)
                .setDuration(300l)
                .setListener(null);

        // Keep track of the last position we loaded
        mLastPosition = position;

        return convertView;
    }

    public class Holder
    {
        ImageView imageView_hotel;
        TextView textView_hotel_name;
        TextView radioButton;
        TextView Open_Close,Address;
    }

}

