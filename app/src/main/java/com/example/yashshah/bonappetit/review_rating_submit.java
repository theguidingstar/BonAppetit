package com.example.yashshah.bonappetit;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class review_rating_submit extends AppCompatActivity {

    RatingBar ratingBar;
    EditText editText_review_title,editText_review;
    Button button_submit_reivew;
    private static DBHelper mydb;
    RelativeLayout write_review,review_success;
    Integer userid,hotelid;
    TextInputLayout textInputType_review_title,textInputType_review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_and_rating_page);
        textInputType_review_title=(TextInputLayout)findViewById(R.id.textInputType_review_title);
        textInputType_review=(TextInputLayout)findViewById(R.id.textInputType_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_reivew);
        setSupportActionBar(toolbar);
        mydb=new DBHelper(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        userid=intent.getIntExtra("userid",1);
        hotelid=intent.getIntExtra("hotelid",1);
        write_review=(RelativeLayout)findViewById(R.id.Write_review);
        review_success=(RelativeLayout)findViewById(R.id.Review_success);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        editText_review_title=(EditText)findViewById(R.id.edittext_review_title);
        editText_review=(EditText)findViewById(R.id.edittext_review);
        button_submit_reivew=(Button)findViewById(R.id.Add_review);
        ImageView imageView=(ImageView)findViewById(R.id.imageView_gif_revie_submitted);
        Glide.with(this).load("http://totallnews.com/cropped-green-tick.gif")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        button_submit_reivew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateRating()) {
                    return;
                }

                if (!validateTitle()) {
                    return;
                }

                if (!validateCompleteReview()) {
                    return;
                }
                Float Rating_value=ratingBar.getRating()+0.0f;
                System.out.print(Rating_value);
                mydb.insertReview(hotelid,userid,Rating_value,editText_review_title.getText().toString(),
                        editText_review.getText().toString());
                //System.out.println("Review Checking"+ratingBar.getRating()+"---"+editText_review_title.getText()+"---"+editText_review.getText().toString());
                write_review.setVisibility(View.GONE);
                review_success.setVisibility(View.VISIBLE);
                int SPLASH_TIME_OUT = 2000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, SPLASH_TIME_OUT);

            }
        });
    }

    private boolean validateTitle() {
        if (editText_review_title.getText().toString().trim().isEmpty()) {
            textInputType_review_title.setError("Please Enter Name");
            requestFocus(editText_review_title);
            return false;
        } else {
            textInputType_review_title.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateCompleteReview() {
        if (editText_review.getText().toString().trim().isEmpty()) {
            textInputType_review.setError("Please Enter Name");
            requestFocus(editText_review);
            return false;
        } else {
            textInputType_review.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRating() {
        if (ratingBar.getRating()==0.0) {
            Toast.makeText(this, "Please do rate as well.. (Min 1 star)", Toast.LENGTH_SHORT).show();
            requestFocus(editText_review);
            return false;
        } else {

        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
