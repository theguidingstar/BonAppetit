package com.example.yashshah.bonappetit;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class full_image_view extends AppCompatActivity {

    ArrayList<String> mArrayList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image_view);
        Toolbar toolbard = (Toolbar) findViewById(R.id.toolbar1d);
        setSupportActionBar(toolbard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbard.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewPager viewPager=(ViewPager)findViewById(R.id.ViewPager);
        Intent intent=getIntent();
        String imageLink=intent.getStringExtra("imageLink");
        mArrayList.add(imageLink);
        mArrayList.add("http://noithatlamdep.com/wp-content/uploads/2016/04/Phong-c%C3%A1ch-Urban-324x235.png");
        mArrayList.add("http://thicongxaydung.info/upload/userfiles/images/thi-cong-quan-cafe-pho-an-tuong-03.jpg");
        mArrayList.add("http://www.enterijer.rs/sites/default/files/8_56.jpg");
        adapterforViewPager adapterforViewPager=new adapterforViewPager(getApplicationContext(),mArrayList);
        viewPager.setAdapter(adapterforViewPager);
    }
}
