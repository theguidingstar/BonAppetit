package com.example.yashshah.bonappetit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class review_all extends AppCompatActivity {

    ListView Listview_review;
    private static DBHelper mydb;
    ArrayList<Integer> mArrayList_userId=new ArrayList<Integer>();
    ArrayList<Float> mArrayList_star=new ArrayList<Float>();
    ArrayList<String> mArrayList_reviewtitle=new ArrayList<String>();
    ArrayList<String> mArrayList_review=new ArrayList<String>();
    ArrayList<Review> mArrayList=new ArrayList<Review>();
    Integer Hotelid;
    Float Average_rating=0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_all);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_review_all);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Listview_review=(ListView)findViewById(R.id.Listview_review);
        mydb=new DBHelper(this);
        Intent intent=getIntent();
        Hotelid=intent.getIntExtra("hotelid",1);
        TextView Hotel_Name=(TextView)findViewById(R.id.Review_Page_hotel_Name);
        Hotel_Name.setText(mydb.getHotelName(Hotelid));
        List<Review> contacts = mydb.getReview(Hotelid);
        for (Review cn : contacts) {
            mArrayList_userId.add(cn.getUser_id());
            mArrayList_star.add(cn.getStar());
            mArrayList_reviewtitle.add(cn.getReview_title());
            mArrayList_review.add(cn.getReview());
        }
        TextView Total_review=(TextView)findViewById(R.id.Total_Review);
        Total_review.setText("Total Review \n"+contacts.size());
        for (int i = 0; i < mArrayList_userId.size(); i++)
        {
            Integer userid=mArrayList_userId.get(i);
            Float star=mArrayList_star.get(i);
            String review_title=mArrayList_reviewtitle.get(i).toString();
            String review=mArrayList_review.get(i).toString();
            Review details=new Review(userid,star,review_title,review);
            Average_rating=Average_rating+(mArrayList_star.get(i));
            mArrayList.add(details);
        }

        float Rating=Average_rating/(contacts.size());
        if(Float.isNaN(Rating))
        {
        }
        TextView AverageRating=(TextView)findViewById(R.id.Average_rating);
        AverageRating.setText((new DecimalFormat("#.#").format(Rating))+"/5.0");
        ArrayAdapterReview adapterReview=new ArrayAdapterReview(this,mArrayList);
        Listview_review.setAdapter(adapterReview);
    }
}
