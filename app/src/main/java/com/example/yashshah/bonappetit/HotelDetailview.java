package com.example.yashshah.bonappetit;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class HotelDetailview extends AppCompatActivity {

    AlertDialog.Builder mBuilder;
    View vi;
    FrameLayout fullImageView;
    Button bookMyRoom;
    List<Review> contacts;
    Float Rating;
    String id,Name,Address,
     desc_data, avgcst_data, homedelivery_data, Veg_data, Parking_data,
     Wifi_data, jainfood_data, cardaccepted_data, walletaccepted_data,
     addresscomplete_data, LAT_data, LONG_data, phoneno, fav;
    Integer userID,HotelID;
    private static DBHelper mydb;
    public static int fav_count=2;
    RelativeLayout UserReviews;
    Float Average_rating=0.0f;
    ArrayList<Integer> mArrayList_userId=new ArrayList<Integer>();
    ArrayList<Float> mArrayList_star=new ArrayList<Float>();
    ArrayList<String> mArrayList_reviewtitle=new ArrayList<String>();
    ArrayList<String> mArrayList_review=new ArrayList<String>();
    ArrayList<Review> mArrayList=new ArrayList<Review>();
    TextView Hotel_address_hotel_full_detail, Rating_full_detail,
            avgcst, home_delivery, wifi, parking, veg, jainfood, cardaccepted, walletaccepted, completeAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_full_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mydb=new DBHelper(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        UserReviews=(RelativeLayout)findViewById(R.id.UserReviews);

        fullImageView = (FrameLayout) findViewById(R.id.frameLayout);


        final ImageView Call_now, Favourite;

        home_delivery = (TextView) findViewById(R.id.home_delivery);
        wifi = (TextView) findViewById(R.id.wifi);
        parking = (TextView) findViewById(R.id.Parking);
        avgcst = (TextView) findViewById(R.id.AverageCostForTwo);
        veg = (TextView) findViewById(R.id.Vegan);
        jainfood = (TextView) findViewById(R.id.jain_food);
        cardaccepted = (TextView) findViewById(R.id.cardaccepted);
        walletaccepted = (TextView) findViewById(R.id.WalletAccepted);
        Hotel_address_hotel_full_detail = (TextView) findViewById(R.id.Hotel_address_hotel_full_detail);
        Hotel_address_hotel_full_detail.setText(Address);
        TextView textView_Hotel_name = (TextView) findViewById(R.id.Hotel_Name_hotel_full_detail);
        ImageView relativeLayout = (ImageView) findViewById(R.id.Hotel_image);
        final Intent intent = getIntent();
        id = intent.getStringExtra("image");
        Name = intent.getStringExtra("Hotel_Name");
        Rating = intent.getFloatExtra("Rating",1.5f);
        Address = intent.getStringExtra("Address");
        desc_data = intent.getStringExtra("desc");
        homedelivery_data = intent.getStringExtra("homedelivery");
        Veg_data = intent.getStringExtra("veg");
        avgcst_data = intent.getStringExtra("avgcst");
        Wifi_data = intent.getStringExtra("wifi");
        Parking_data = intent.getStringExtra("parking");
        jainfood_data = intent.getStringExtra("jainfood");
        cardaccepted_data = intent.getStringExtra("cardaccepted");
        walletaccepted_data = intent.getStringExtra("walletaccepted");
        addresscomplete_data = intent.getStringExtra("addresscomplete");
        LAT_data = intent.getStringExtra("LAT");
        LONG_data = intent.getStringExtra("LONG");
        phoneno = intent.getStringExtra("Number");
        userID=intent.getIntExtra("id",1);
        HotelID=intent.getIntExtra("hotelid",1);
        fav=intent.getStringExtra("fav");
        Rating_full_detail=(TextView)findViewById(R.id.Rating_full_detail);
        System.out.println(Rating);
        Rating=Rating+0.0f;
        if(Rating<=2.5f)
        {
            Rating_full_detail.setBackgroundResource(R.drawable.rounded_rectangle);
            Rating_full_detail.setText(new DecimalFormat("#.#").format(Rating)+".0");
        }


        if(Rating<=5.0f && Rating>2.5f)
        {
            Rating_full_detail.setBackgroundResource(R.drawable.rounded_rectangle_green);
            Rating_full_detail.setText(new DecimalFormat("#.#").format(Rating)+".0");
        }

        if (homedelivery_data.matches("true")) {
            home_delivery.setVisibility(View.VISIBLE);
            ;
        } else {
            home_delivery.setVisibility(GONE);
        }

        if (Veg_data.matches("true")) {
            veg.setVisibility(View.VISIBLE);
            ;
        } else {
            veg.setVisibility(GONE);
        }

        if (Parking_data.matches("true")) {
            parking.setVisibility(View.VISIBLE);
            ;
        } else {
            parking.setVisibility(GONE);
        }

        if (Wifi_data.matches("true")) {
            wifi.setVisibility(View.VISIBLE);
            ;
        } else {
            wifi.setVisibility(GONE);
        }

        if (jainfood_data.matches("true")) {
            jainfood.setVisibility(View.VISIBLE);
            ;
        } else {
            jainfood.setVisibility(GONE);
        }

        if (cardaccepted_data.matches("true")) {
            cardaccepted.setVisibility(View.VISIBLE);
            ;
        } else {
            cardaccepted.setVisibility(GONE);
        }

        if (walletaccepted_data.matches("true")) {
            walletaccepted.setVisibility(View.VISIBLE);
        } else {
            walletaccepted.setVisibility(GONE);
        }

        ImageView AddReview_image=(ImageView)findViewById(R.id.Review);
        AddReview_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),review_rating_submit.class);
                intent1.putExtra("userid",userID);
                intent1.putExtra("hotelid",HotelID);
                startActivity(intent1);
            }
        });
        Call_now = (ImageView) findViewById(R.id.Call_now);
        Call_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(HotelDetailview.this);
                alertDialog.setTitle("Do you Want to Call?");
                alertDialog.setMessage("" + phoneno);

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String uri = "tel:" + phoneno.trim();
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(uri));
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });

        Favourite=(ImageView)findViewById(R.id.Favourite);
        fav=mydb.getfavDetail(Name);
        if(fav.matches("true"))
        {
            Favourite.setImageResource(R.drawable.ic_favdone);
            if(fav_count%2==0)
            {
                fav_count=2;
                fav_count=fav_count+1;
            }
        }

        Favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favourite.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_fade_out));
                if(fav_count%2==0) {
                    Favourite.setImageResource(R.drawable.ic_favdone);
                    mydb.updateFav(Name,"true");
                }
                if(fav_count%2!=0)
                {
                    Favourite.setImageResource(R.drawable.ic_fav);
                    mydb.updateFav(Name,"false");
                }
                System.out.println("Inside fav Count Click"+fav_count);
                fav_count++;
            }
        });



        avgcst.setText(avgcst_data+" for two People Approximately");
        completeAddress=(TextView)findViewById(R.id.Complete_address);
        completeAddress.setText(addresscomplete_data);
        LinearLayout getDirection=(LinearLayout)findViewById(R.id.getDirection);
        getDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?daddr="+LAT_data+ ","+LONG_data;
                Intent goZe = new Intent(Intent.ACTION_VIEW);
                goZe.setData(Uri.parse(url));
                startActivity(goZe);
            }
        });
        textView_Hotel_name.setText(Name);
        Hotel_address_hotel_full_detail.setText(Address);

        bookMyRoom=(Button)findViewById(R.id.bookMyRoom);
        bookMyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Checkout_activity.class);
                intent1.putExtra("Name",Name);
                intent1.putExtra("id",id);
                startActivity(intent1);
            }
        });
        Glide.with(getApplicationContext()).load(id)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(relativeLayout);
        mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Share");
        mBuilder.setMessage("With Whom you want to share this Product?");

        mBuilder.setPositiveButton("Admin", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Shared With Admin", Toast.LENGTH_LONG).show();
            }
        });

        mBuilder.setNegativeButton("Friend", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getApplicationContext(),contact_list.class);
                intent.putExtra("Product","Nike Blue Shoe for Rs. 3000/-");
                startActivity(intent);
                finish();
            }
        });

        UserReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),review_all.class);
                intent1.putExtra("hotelid",HotelID);
                startActivity(intent1);
            }
        });

        fullImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),full_image_view.class);
                intent1.putExtra("imageLink",id);
                startActivity(intent1);
            }
        });
        contacts = mydb.getReview(HotelID);
        int size=contacts.size();
        TextView total_review_full_detail_page=(TextView)findViewById(R.id.total_review_full_detail_page);
        total_review_full_detail_page.setText("From "+ size +" Rating");
        for (Review cn : contacts) {
            mArrayList_userId.add(cn.getUser_id());
            mArrayList_star.add(cn.getStar());
            mArrayList_reviewtitle.add(cn.getReview_title());
            mArrayList_review.add(cn.getReview());
        }
        Average_rating=0.0f;
        for (int i = 0; i < mArrayList_userId.size(); i++)
        {

            Average_rating=Average_rating+(mArrayList_star.get(i));
        }
        float Rating=Average_rating/mArrayList_userId.size();
        if(Float.isNaN(Rating))
        {
            Rating=0.0f;
        }
        TextView AverageRating=(TextView)findViewById(R.id.starRating);
        AverageRating.setText((new DecimalFormat("#.#").format(Rating))+"");
        if(contacts.size()==0)
        {
            UserReviews.setVisibility(GONE);
        }
        else
        {
            UserReviews.setVisibility(View.VISIBLE);
        }
    }

    public void displayShareDetail(View v)
    {
        vi=v;
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }

    public void backIntent(View v)
    {
        Intent intent=new Intent(getApplicationContext(),Main_Navigation_activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Average_rating = 0.0f;
        contacts.clear();
        contacts = mydb.getReview(HotelID);
        if (contacts.size() == 0) {
            UserReviews.setVisibility(GONE);
        } else {
            UserReviews.setVisibility(View.VISIBLE);
        }

        int size = contacts.size();
        TextView total_review_full_detail_page = (TextView) findViewById(R.id.total_review_full_detail_page);
        total_review_full_detail_page.setText("From " + size + " Rating");
        for (Review cn : contacts) {
            mArrayList_userId.add(cn.getUser_id());
            mArrayList_star.add(cn.getStar());
            mArrayList_reviewtitle.add(cn.getReview_title());
            mArrayList_review.add(cn.getReview());
        }
        Average_rating = 0.0f;
        for (int i = 0; i < mArrayList_userId.size(); i++) {

            Average_rating = Average_rating + (mArrayList_star.get(i));
        }
        float Rating_user = Average_rating / mArrayList_userId.size();
        if (Float.isNaN(Rating_user)) {
            Rating_user = 0.0f;
        }
        TextView AverageRating = (TextView) findViewById(R.id.starRating);
        AverageRating.setText((new DecimalFormat("#.#").format(Rating_user))+".0");
        if (Rating_user != 0.0) {
            mydb.insertRating(HotelID, Rating_user);
            Rating_full_detail.setText((new DecimalFormat("#.#").format(Rating_user))+".0");
        }

    }
}
