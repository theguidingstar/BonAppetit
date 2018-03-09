package com.example.yashshah.bonappetit;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by Yash shah on 19-06-2017.
 */

public class ArrayAdapterReview extends BaseAdapter {
    Context mContext;
    private static LayoutInflater inflater=null;
    ArrayList<Review> mArrayListall;
    private ArrayList<Review> arraylist= new ArrayList<Review>();
    private static DBHelper mydb;
    String Name;
    public ArrayAdapterReview(Context context,ArrayList<Review> mArrayListall)

    {
        mContext=context;
        this.mArrayListall=mArrayListall;
        arraylist.addAll(mArrayListall);
        inflater = LayoutInflater.from(mContext);
        mydb=new DBHelper(mContext);
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
            convertView = inflater.inflate(R.layout.review_data_row,null);


            holder.review_title = (TextView) convertView.findViewById(R.id.Review_title);
            holder.review_data=(TextView)convertView.findViewById(R.id.Review_data);
            holder.star_rating=(TextView)convertView.findViewById(R.id.starRating);
            holder.User_name=(TextView)convertView.findViewById(R.id.UserName);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }
        Name=mydb.getName(mArrayListall.get(position).getUser_id());
        holder.User_name.setText(Name);
        holder.review_title.setText(mArrayListall.get(position).getReview_title().toString());
        holder.review_data.setText(mArrayListall.get(position).getReview());
        holder.star_rating.setText(Float.toString(mArrayListall.get(position).getStar()));
        return convertView;
    }

    public class Holder
    {

        TextView User_name;
        TextView review_title;
        TextView review_data;
        TextView star_rating;
    }

}

