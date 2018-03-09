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

import java.util.ArrayList;

/**
 * Created by Yash shah on 30-06-2017.
 */

public class ArrayAdapterCategoryGrid extends RecyclerView.Adapter<ArrayAdapterCategoryGrid.MyViewHolder>
{
    Context mContext;
    private static LayoutInflater inflater=null;
    ArrayList<Category> mArrayListall;
    private ArrayList<Category> arraylist= new ArrayList<Category>();
    int Position;

    public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView Category_Name;
    public ImageView Category_Image;

    public MyViewHolder(View view) {
        super(view);
        Category_Name=(TextView)view.findViewById(R.id.Category_Name);
        Category_Image=(ImageView)view.findViewById(R.id.Category_image);
    }
}


    public ArrayAdapterCategoryGrid(Context mContext, ArrayList<Category> mArrayListall) {
        this.mContext = mContext;
        this.mArrayListall=mArrayListall;
        arraylist.addAll(mArrayListall);
    }

    @Override
    public ArrayAdapterCategoryGrid.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.caetogory_gridview_row, parent, false);
        return new ArrayAdapterCategoryGrid.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ArrayAdapterCategoryGrid.MyViewHolder holder, int position) {
        Glide.with(mContext).load(arraylist.get(position).getCategoryImageLink())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.Category_Image);
        holder.Category_Name.setText(arraylist.get(position).getCategoryName().toString());
        System.out.println("Category.."+arraylist.get(position).getCategoryName().toString());

    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}
