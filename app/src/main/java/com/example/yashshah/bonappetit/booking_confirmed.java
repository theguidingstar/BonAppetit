package com.example.yashshah.bonappetit;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class booking_confirmed extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmed);
        Toolbar toolbar21 = (Toolbar) findViewById(R.id.toolbar32);

        setSupportActionBar(toolbar21);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar21.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView Confirmed_image_view=(ImageView)findViewById(R.id.Confirmed_image_view);
        Glide.with(getApplicationContext()).load("http://totallnews.com/cropped-green-tick.gif")
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(Confirmed_image_view);
        int SPLASH_TIME_OUT = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
