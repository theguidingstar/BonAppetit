package com.example.yashshah.bonappetit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

public class Main_Navigation_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int shorting;
    private static LayoutInflater inflater=null;
    ArrayList<Integer> mArrayListID=new ArrayList<Integer>();
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
    ArrayList<details> mArrayListRatingDesc=new ArrayList<details>();
    ArrayList<details> mArrayListAvgcstAsc=new ArrayList<details>();
    ArrayAdapter arrayAdapter;
    CardViewArrayAdapter adapter_cardview;
    ListView listView;
    int backButtonCount=0;
    Context mcontext;
    private static DBHelper mydb;
    View header;
    int id_user;
    ImageView textView_display_Gridview;
    TextView textView_display_Sortby;
    private RecyclerView recyclerView;
    String name_database,phone_database,email_database,pass_database;
    String email_passed_email;
    int l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__navigation_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mcontext=this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        mydb=new DBHelper(this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header= navigationView.getHeaderView(0);
        Intent intentEMail=getIntent();
        ImageView imageView_navigation_profile=(ImageView)header.findViewById(R.id.imageView);
        String name_image_view="";
        email_passed_email=intentEMail.getStringExtra("email");
        List<details> contacts = mydb.getDataEmail(email_passed_email);
        for (details cn : contacts) {
            id_user=cn.getId();
            name_database=cn.getName().toString();
            email_database=cn.getEmail().toString();
            phone_database=cn.getPhone();
            pass_database=cn.getPass();
            name_image_view=cn.getName().toString();
        }



        TextView Navigation_drawer_name,Navigation_drawer_email;
        Navigation_drawer_name=(TextView)header.findViewById(R.id.Name_Navigation_drawer);
        Navigation_drawer_email=(TextView)header.findViewById(R.id.Email_Navigation_drawer);
        Navigation_drawer_email.setText(email_database);
        Navigation_drawer_name.setText(name_database);
        RelativeLayout relative_layout_edit = (RelativeLayout) header.findViewById(R.id.profile_edit);
        name_image_view = name_image_view.substring(0,1);
       TextDrawable drawable = TextDrawable.builder()
                .buildRound(name_image_view.toUpperCase(), Color.BLACK);
        imageView_navigation_profile.setImageDrawable(drawable);

        relative_layout_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentz=new Intent(getApplicationContext(),profile_edit.class);
                intentz.putExtra("id",id_user);
                intentz.putExtra("name",name_database);
                intentz.putExtra("phone",phone_database);
                intentz.putExtra("email",email_database);
                intentz.putExtra("pass",pass_database);
                startActivity(intentz);
            }
        });

        listInflating();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(getApplicationContext(),HotelDetailview.class);
                intent.putExtra("image",mArrayListimages.get(position).toString());
                intent.putExtra("Hotel_Name",mArrayListNames.get(position).toString());
                intent.putExtra("Rating",mArrayListTypeRating.get(position));
                intent.putExtra("Number",mArrayListNumber.get(position).toString());
                intent.putExtra("Address",mArrayListAddress.get(position).toString());
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
                intent.putExtra("id",id_user);
                intent.putExtra("hotelid",mArrayListID.get(position));
                startActivityForResult(intent,21);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                details clickedObj = (details) parent.getItemAtPosition(position);
                Intent intent=new Intent(getApplicationContext(),HotelDetailview.class);
                intent.putExtra("image",clickedObj.getImage());
                intent.putExtra("Hotel_Name",clickedObj.getHotel_name());
                intent.putExtra("Rating",clickedObj.getRating());
                intent.putExtra("Address",clickedObj.getAddress());
                intent.putExtra("Number",mArrayListNumber.get(position).toString());
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
                intent.putExtra("id",id_user);
                intent.putExtra("hotelid",mArrayListID.get(position));
                startActivityForResult(intent,21);

            }
        });


        textView_display_Gridview=(ImageView)findViewById(R.id.Display_GridView);
        textView_display_Sortby=(TextView)findViewById(R.id.Display_ListView);
        textView_display_Sortby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names[] ={"Rating","Average Cost for Two"};
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main_Navigation_activity.this);
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                alertDialog.setView(convertView);
                alertDialog.setTitle("Sort By:-");
                ListView lv = (ListView) convertView.findViewById(R.id.listView111);
                android.widget.ArrayAdapter<String> adapter = new android.widget.ArrayAdapter<String>(Main_Navigation_activity.this,android.R.layout.simple_list_item_1,names);
                lv.setAdapter(adapter);
                final Dialog dialog=alertDialog.create();
                dialog.show();

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0)
                        {
                            listClearing();
                            descRatingInfalting();
                            dialog.dismiss();

                        }

                        else if(position==1)
                        {
                            listClearing();
                            ascAvgcstInfalting();
                            dialog.dismiss();
                        }

                    }

                });
            }
        });

        textView_display_Gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l++;
                if(l%2==0)
                {
                    recyclerView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    textView_display_Gridview.setImageResource(R.drawable.ic_grid);
                }
                else if(l%2!=0) {
                    recyclerView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    textView_display_Gridview.setImageResource(R.drawable.ic_list);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        if (backButtonCount >= 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);


        }
        else if (id == R.id.nav_logout) {
            Intent intent= new Intent(getApplicationContext(), Login.class);
            intent.putExtra("spclear",true);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.nav_profile) {
            Intent intentz=new Intent(getApplicationContext(),profile_edit.class);
            intentz.putExtra("id",id);
            intentz.putExtra("name",name_database);
            intentz.putExtra("phone",phone_database);
            intentz.putExtra("email",email_database);
            intentz.putExtra("pass",pass_database);
            startActivity(intentz);
        }

        else if (id == R.id.nav_category) {
            Intent intentz=new Intent(getApplicationContext(),Category_grid_view.class);
            startActivity(intentz);
        }

        else if (id == R.id.nav_fav) {
            Intent intentz=new Intent(getApplicationContext(),fav_grid_view.class);
            startActivity(intentz);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
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

    @Override
    protected void onResume() {
        super.onResume();
        backButtonCount=0;
        listClearing();
        if(shorting==1)
        {
            listInflating();
        }
        else if (shorting==2)
        {
            ascAvgcstInfalting();
        }
        else if (shorting==3)
        {
            descRatingInfalting();
        }

    }

    public void ascAvgcstInfalting()
    {
        List<Resturant> mResturant= mydb.getAllResturantsAverageCostAsc();
        for (Resturant cn : mResturant) {
            mArrayListID.add(cn.getId());
            mArrayListNames.add(cn.getName());
            mArrayListAddress.add(cn.getAddress());
            mArrayListimages.add(cn.getImageLink());
            mArrayListCategoryID.add(cn.getCategoryID());
            mArrayListNumber.add(cn.getPhoneno());
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
            mArrayListRatingDesc.add(details);
            shorting=2;
            System.out.println("Yash Shah in..."+image+"......."+Name+".....");
        }

        arrayAdapter = new ArrayAdapter(this,mArrayListRatingDesc);
        arrayAdapter.notifyDataSetChanged();
        listView=(ListView)findViewById(R.id.Listview_hotel);
        listView.setAdapter(arrayAdapter);
        recyclerView = (RecyclerView) findViewById(R.id.reCycle_view);
        adapter_cardview=new CardViewArrayAdapter(getApplicationContext(),mArrayListRatingDesc);
        recyclerView.setAdapter(adapter_cardview);
    }

    public void descRatingInfalting()
    {
        List<Resturant> mResturant= mydb.getAllResturantsRatingDesc();
        for (Resturant cn : mResturant) {
            mArrayListID.add(cn.getId());
            mArrayListNames.add(cn.getName());
            mArrayListAddress.add(cn.getAddress());
            mArrayListimages.add(cn.getImageLink());
            mArrayListCategoryID.add(cn.getCategoryID());
            mArrayListNumber.add(cn.getPhoneno());
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
            mArrayListAvgcstAsc.add(details);
            shorting=3;
            System.out.println("Yash Shah in..."+image+"......."+Name+".....");
        }

        arrayAdapter = new ArrayAdapter(this,mArrayListAvgcstAsc);
        arrayAdapter.notifyDataSetChanged();
        listView=(ListView)findViewById(R.id.Listview_hotel);
        listView.setAdapter(arrayAdapter);
        recyclerView = (RecyclerView) findViewById(R.id.reCycle_view);
        adapter_cardview=new CardViewArrayAdapter(getApplicationContext(),mArrayListAvgcstAsc);
        recyclerView.setAdapter(adapter_cardview);
    }

    public void listClearing()
    {
        mArrayListID.clear();
        mArrayListimages.clear();
        mArrayListNames.clear();
        mArrayListAddress.clear();
        mArrayListNumber.clear();
        mArrayListCategoryID.clear();
        mArrayListTypeRating.clear();
        mArrayListTypeDesc.clear();
        mArrayListTypeavgcst.clear();
        mArrayListTypeHomedelivery.clear();
        mArrayListTypeVeg.clear();
        mArrayListTypeParking.clear();
        mArrayListTypeWifi.clear();
        mArrayListTypeJainfood.clear();
        mArrayListTypeCardAccepted.clear();
        mArrayListTypeWalletAccepted.clear();
        mArrayListTypeAddressComplete.clear();
        mArrayListTypeLAT.clear();
        mArrayListTypeLONG.clear();
        mArrayListTypeFav.clear();
        listView.setAdapter(null);
        recyclerView.setAdapter(null);
        mArrayList.clear();
        mArrayListAvgcstAsc.clear();
        mArrayListRatingDesc.clear();
    }

    public  void listInflating()
    {
        List<Resturant> mResturant= mydb.getAllResturants();
        for (Resturant cn : mResturant) {
            mArrayListID.add(cn.getId());
            mArrayListNames.add(cn.getName());
            mArrayListAddress.add(cn.getAddress());
            mArrayListimages.add(cn.getImageLink());
            mArrayListCategoryID.add(cn.getCategoryID());
            mArrayListNumber.add(cn.getPhoneno());
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
            shorting=1;
            System.out.println("Yash Shah in..."+image+"......."+Name+".....");
        }


        arrayAdapter = new ArrayAdapter(this,mArrayList);
        arrayAdapter.notifyDataSetChanged();
        listView=(ListView)findViewById(R.id.Listview_hotel);
        listView.setAdapter(arrayAdapter);
        recyclerView = (RecyclerView) findViewById(R.id.reCycle_view);
        adapter_cardview=new CardViewArrayAdapter(getApplicationContext(),mArrayList);
        arrayAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter_cardview);
    }

}





