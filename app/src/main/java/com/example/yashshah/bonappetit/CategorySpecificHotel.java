package com.example.yashshah.bonappetit;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CategorySpecificHotel extends AppCompatActivity {

    private static DBHelper mydb;
    ArrayList<String> mArrayListimages=new ArrayList<String>();
    ArrayList<String> mArrayListNames=new ArrayList<String>();
    ArrayList<String> mArrayListAddress=new ArrayList<String>();
    ArrayList<String> mArrayListNumber=new ArrayList<String>();
    ArrayList<String> mArrayListCategoryID=new ArrayList<String>();
    ArrayList<Float> mArrayListTypeRating=new ArrayList<Float>();
    ArrayList<String> mArrayListTypeDesc=new ArrayList<String>();
    ArrayList<Double> mArrayListTypeavgcst=new ArrayList<Double>();
    ArrayList<String> mArrayListTypeHomedelivery=new ArrayList<String>();
    ArrayList<String> mArrayListTypeVeg=new ArrayList<String>();
    ArrayList<String> mArrayListTypeParking=new ArrayList<String>();
    ArrayList<String> mArrayListTypeWifi=new ArrayList<String>();
    ArrayList<String> mArrayListTypeJainfood=new ArrayList<String>();
    ArrayList<String> mArrayListTypeCardAccepted=new ArrayList<String>();
    ArrayList<String> mArrayListTypeWalletAccepted=new ArrayList<String>();
    ArrayList<String> mArrayListTypeAddressComplete=new ArrayList<String>();
    ArrayList<String> mArrayListTypeLAT=new ArrayList<String>();
    ArrayList<String> mArrayListTypeLONG=new ArrayList<String>();
    ArrayList<String> mArrayListTypeFav=new ArrayList<String>();
    ArrayList<details> mArrayList=new ArrayList<details>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_specific_hotel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_categorySpecific);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mydb = new DBHelper(this);
        Intent intent=getIntent();
        String CategoryID=intent.getStringExtra("CategoryID");
        recyclerView=(RecyclerView)findViewById(R.id.reCycle_view_category_specifichotel);
        List<Resturant> mResturant= mydb.getDataCategoryID(CategoryID);
        for (Resturant cn : mResturant) {
            mArrayListNames.add(cn.getName());
            mArrayListAddress.add(cn.getAddress());
            mArrayListimages.add(cn.getImageLink());
            mArrayListNumber.add(cn.getPhoneno());
            mArrayListCategoryID.add(cn.getCategoryID());
            mArrayListTypeRating.add(cn.getRating());
            mArrayListTypeDesc.add(cn.getDesc());
            mArrayListTypeavgcst.add(cn.getAvgcst());
            mArrayListTypeHomedelivery.add(cn.getHome_delivery());
            mArrayListTypeVeg.add(cn.getVeg());
            mArrayListTypeParking.add(cn.getParking());
            mArrayListTypeWifi.add(cn.getWifi());
            mArrayListTypeJainfood.add(cn.getJainfood());
            mArrayListTypeCardAccepted.add(cn.getCardaccepted());
            mArrayListTypeWalletAccepted.add(cn.getWalletaccepted());
            mArrayListTypeAddressComplete.add(cn.getAddresscomplete());
            mArrayListTypeLAT.add(cn.getLAT());
            mArrayListTypeLONG.add(cn.getLONG());
            mArrayListTypeFav.add(cn.getFav());
        }

        for (int i = 0; i < mArrayListNames.size(); i++)
        {
            String image=mArrayListimages.get(i);
            String Name=mArrayListNames.get(i).toString();
            String Address=mArrayListAddress.get(i).toString();
            Float Rating=mArrayListTypeRating.get(i);
            details details=new details(image,Name,Rating,Address);
            mArrayList.add(details);
            System.out.println("Yash Shah in..."+image+"......."+Name+".....");
        }

        CardViewArrayAdapter adapter_cardview=new CardViewArrayAdapter(getApplicationContext(),mArrayList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new CategorySpecificHotel.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter_cardview);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(getApplicationContext(),HotelDetailview.class);
                intent.putExtra("image",mArrayList.get(position).getImage());
                intent.putExtra("Hotel_Name",mArrayList.get(position).getHotel_name());
                intent.putExtra("Rating",mArrayList.get(position).getRating());
                intent.putExtra("Number",mArrayListNumber.get(position).toString());
                intent.putExtra("Address",mArrayList.get(position).getAddress());
                intent.putExtra("desc",mArrayListTypeDesc.get(position).toString());
                intent.putExtra("avgcst",mArrayListTypeavgcst.get(position).toString());
                intent.putExtra("homedelivery",mArrayListTypeHomedelivery.get(position).toString());
                intent.putExtra("avgcst",mArrayListTypeavgcst.get(position).toString());
                intent.putExtra("veg",mArrayListTypeVeg.get(position).toString());
                intent.putExtra("parking",mArrayListTypeParking.get(position).toString());
                intent.putExtra("wifi",mArrayListTypeWifi.get(position).toString());
                intent.putExtra("jainfood",mArrayListTypeWifi.get(position).toString());
                intent.putExtra("cardaccepted",mArrayListTypeCardAccepted.get(position).toString());
                intent.putExtra("walletaccepted",mArrayListTypeWalletAccepted.get(position).toString());
                intent.putExtra("addresscomplete",mArrayListTypeAddressComplete.get(position).toString());
                intent.putExtra("LAT",mArrayListTypeLAT.get(position).toString());
                intent.putExtra("LONG",mArrayListTypeLONG.get(position).toString());
                intent.putExtra("fav",mArrayListTypeFav.get(position).toString());
                startActivityForResult(intent,2);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
