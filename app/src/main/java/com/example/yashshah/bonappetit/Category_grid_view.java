package com.example.yashshah.bonappetit;

import android.content.Context;
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

public class Category_grid_view extends AppCompatActivity {

    ArrayList<String> mArrayListCategoryimages=new ArrayList<String>();
    ArrayList<String> mArrayListCategoryNames=new ArrayList<String>();
    ArrayList<String> mArrayListCategoryCategoryID=new ArrayList<String>();
    ArrayList<Category> mArrayList=new ArrayList<Category>();
    private static DBHelper mydb;
    RecyclerView recyclerView_category;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_gridview);
        mContext = this;
        recyclerView_category = (RecyclerView) findViewById(R.id.reCycle_view_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_category);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mydb = new DBHelper(this);

        List<Category> mCategories = mydb.getAllCategories();
        for (Category cn : mCategories) {
            mArrayListCategoryNames.add(cn.getCategoryName());
            mArrayListCategoryCategoryID.add(cn.getCategoryID());
            mArrayListCategoryimages.add(cn.getCategoryImageLink());
        }

        for (int i = 0; i < mArrayListCategoryNames.size(); i++) {
            String Name = mArrayListCategoryNames.get(i).toString();
            String Categoryid = mArrayListCategoryCategoryID.get(i).toString();
            String image = mArrayListCategoryimages.get(i).toString();
            Category mCategory = new Category(Name, Categoryid, image);
            mArrayList.add(mCategory);
            System.out.println("Inside Grid View in..." + Name + "......." + Name + ".....");
        }


        ArrayAdapterCategoryGrid adapter_cardview = new ArrayAdapterCategoryGrid(mContext, mArrayList);
        RecyclerView.LayoutManager mLayoutManager_category = new GridLayoutManager(mContext, 2);
        recyclerView_category.setLayoutManager(mLayoutManager_category);
        recyclerView_category.addItemDecoration(new Category_grid_view.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView_category.setItemAnimator(new DefaultItemAnimator());
        recyclerView_category.setAdapter(adapter_cardview);

        recyclerView_category.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_category, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(getApplicationContext(), CategorySpecificHotel.class);
                intent.putExtra("CategoryID",mArrayList.get(position).getCategoryID().toString());
                startActivity(intent);
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
