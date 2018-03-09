package com.example.yashshah.bonappetit;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yash shah on 05-07-2017.
 */

public class adapterforViewPager extends PagerAdapter {
    Context mcontext;
    ArrayList<String> imageLink=new ArrayList<String>();
    LayoutInflater mLayoutInflater;

    public adapterforViewPager(Context context, ArrayList<String> image)
    {
        this.mcontext=context;
        mLayoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLink.addAll(image);
    }

    @Override
    public int getCount() {
        return imageLink.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.full_image_view_custome_row, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView3);
        Glide.with(mcontext).load(imageLink.get(position).toString())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}

