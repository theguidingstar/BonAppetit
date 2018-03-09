package com.example.yashshah.bonappetit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
/**
 * Created by Yash shah on 20-06-2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName1.db";
    public static final String DETAILS_TABLE_NAME = "contacts";
    public static final String CATEGORIES_TABLE_NAME = "categories";
    public static final String RESTURANTS_TABLE_NAME = "resturant";
    public static final String RESTURANTS_REVIEW_TABLE_NAME = "review";

    public static final String RESTURANTS_REVIEW_COLOUMN_ID="id";
    public static final String RESTURANTS_REVIEW_COLOUMN_RESUTRANT_ID="resturant_id";
    public static final String RESTURANTS_REVIEW_COLOUMN_REIVEW_USER_ID="user_id";
    public static final String RESTURANTS_REVIEW_COLOUMN_REVIEW_STAR="star";
    public static final String RESTURANTS_REVIEW_COLOUMN_REVIEW_TITLE="review_title";
    public static final String RESTURANTS_REVIEW_COLOUMN_REVIEW_COMPLETE="review_complete";

    public static final String CATEGORIES_COLOUMN_ID="id";
    public static final String CATEGORIES_COLOUMN_CATEGORY="category";
    public static final String CATEGORIES_COLOUMN_CATEGORYID="categoryid";
    public static final String CATEGORIES_COLOUMN_CATEGORYIMAGE="categoryimage";

    public static final String RESTURANTS_COLOUMN_ID="id";
    public static final String RESTURANTS_COLOUMN_NAME="name";
    public static final String RESTURANTS_COLOUMN_ADDRESS="address";
    public static final String RESTURANTS_COLOUMN_MAINIMAGE="imagelink";
    public static final String RESTURANTS_COLOUMN_CATEGORYID="category_id";
    public static final String RESTURANTS_COLOUMN_PHONENO="number";
    public static final String RESTURANTS_COLOUMN_RATING="rating";
    public static final String RESTURANTS_COLOUMN_Description="desc";
    public static final String RESTURANTS_COLOUMN_AVERAGECOST="avgcst";
    public static final String RESTURANTS_COLOUMN_HOME_DELIVERY="homedelivery";
    public static final String RESTURANTS_COLOUMN_VEGETARIAN="veg";
    public static final String RESTURANTS_COLOUMN_PARKING="parking";
    public static final String RESTURANTS_COLOUMN_WIFI="wifi";
    public static final String RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD="jainfood";
    public static final String RESTURANTS_COLOUMN_CARD_ACCEPTED="cardaccepted";
    public static final String RESTURANTS_COLOUMN_WALLET_ACCEPTED="walletaccepted";
    public static final String RESTURANTS_COLOUMN_AddressComplete="addresscomplete";
    public static final String RESTURANTS_COLOUMN_Address_LAT="LAT";
    public static final String RESTURANTS_COLOUMN_Address_LONG="LONG";
    public static final String RESTURANTS_COLOUMN_Address_Fav="fav";

    public static final String DETAILS_COLUMN_ID = "id";
    public static final String DETAILS_COLUMN_NAME = "name";
    public static final String DETAILS_COLUMN_PHONE = "phone";
    public static final String DETAILS_COLUMN_EMAIL = "email";
    public static final String DETAILS_COLUMN_PASSWORD = "password";
    public static final String DETAILS_COLUMN_ADDRESS = "address";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table categories " +
                        "(id integer primary key, category text,categoryid text,categoryimage text)");
        db.execSQL(
                "create table resturant " +
                        "(id integer primary key, name text,address text,imagelink text,category_id integer," +
                        "number text,rating real,desc text,avgcst real,homedelivery text,veg text,parking text," +
                        "wifi text,jainfood text,cardaccepted text,walletaccepted text,addresscomplete text,LAT text," +
                        "LONG text,fav text)");
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text,password text,address text)");

        db.execSQL(
                "create table review " +
                        "(id integer primary key, resturant_id integer,user_id integer,star real,review_title text,review_complete text)");

        ContentValues contentValues = new ContentValues();
        String name;
        String address;
        String MainImageLink;
        String CategoryID;
        String Number;
        Float Rating;
        String desc;
        Double avgcst;
        String home_delivery;
        String Veg;
        String Parking;
        String Wifi;
        String jainfood;
        String cardaccepted;
        String walletaccepted;
        String Address;
        String LAT;
        String LONG;
        String fav="false";
        name="Red Chillies";
        address="Navrangpura, Ahmedabad";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/originals/f4/fc/1e/f4fc1edfee5eae66ee15955e40c47e65.jpg";
        CategoryID="3";
        Number="5426654325";
        Rating=4.5f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=800.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Inder Residency, Opposite Gujarat College, Ellis Bridge, Ahmedabad";
        LAT="23.029545";
        LONG="72.544895";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Brownie World";
        address="Naranpura, Ahmedabad";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/originals/9b/30/30/9b3030964c96550d2d69bc662233972a.jpg";
        CategoryID="2";
        Number="5456254325";
        Rating=3.2f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=600.0;
        home_delivery="true";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="false";
        Address="B.B.C Market, Devkinadan Market, Lal Darwaja, Relief Rd, Suodagarpole, Revdi Bazar, Kalupur, Ahmedabad, Gujarat 380002";
        LAT="23.033025";
        LONG="72.542410";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Pizza Empire";
        address="Main City, Ahmedabad";
        MainImageLink="http://68.media.tumblr.com/tumblr_m4fplqwXW71qmkzruo1_1280.jpg";
        CategoryID="4";
        Number="5456277725";
        Rating=4.1f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=500.0;
        home_delivery="false";
        Veg="true";
        Parking="true";
        Wifi="false";
        jainfood="true";
        cardaccepted="false";
        walletaccepted="true";
        Address="Saraspur Mills, Saraspur Rd, Saraspur, Ahmedabad, Gujarat 380018";
        LAT="23.035718";
        LONG="72.537896";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Main-Land China Ltd";
        address="Law Garden, Ahmedabad";
        MainImageLink="http://www.gomelaka.my/site/wp-content/uploads/2015/03/veggie-planet-interior-c.jpg";
        CategoryID="1";
        Number="2556277725";
        Rating=4.4f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=800.0;
        home_delivery="true";
        Veg="false";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="false";
        Address="Near, Mirzapur Rd, Mirzapur, Lal Darwaja, Ahmedabad, Gujarat 380001";
        LAT="23.038656";
        LONG="72.538205";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Indigo Nation Ltd";
        address="Malviya Nagar, Jaipur";
        MainImageLink="http://www.enterijer.rs/sites/default/files/8_56.jpg";
        CategoryID="2";
        Number="2544477725";
        Rating=4.6f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=1000.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="true";
        Address="Narayan Chamber, Opposite Nehru Bridge, Ashram Road, Ellisbridge, Ahmedabad, Gujarat 380009";
        LAT="23.041860";
        LONG="72.540185";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Raw India Pvt.";
        address="Vijay Nagar, Jaipur";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/236x/de/8f/c0/de8fc0802cd050a8bf23731f09241497.jpg";
        CategoryID="4";
        Number="";
        Rating=1.2f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=300.0;
        home_delivery="true";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="true";
        cardaccepted="false";
        walletaccepted="true";
        Address="Law Garden Cross Road, Near V-Mart,, Opposite Samartheshwar Mahadev, Off. C.G. Road, Navrangpura,Ellisbridge, Ellisbridge, Ahmedabad, Gujarat 380009";
        LAT="23.044680";
        LONG="72.545141";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Lemon Tree ";
        address="Mem Nagar, Ahmedabad";
        MainImageLink="http://retaildesignblog.net/wp-content/uploads/2011/11/Joy-Cupcakes-by-Mim-Design-Melbourne.jpg";
        CategoryID="3";
        Number="5545875654";
        Rating=2.3f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=900.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="true";
        Address=" Arambha Complex, Opp. Riddhi Maternity Hospital, Ankur Cross Road, Naranpura, Vijaynagar, Naryanpura, Ahmedabad, Gujarat 380013";
        LAT="23.048598";
        LONG="72.550579";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Holiday Inn";
        address="Akhbar Nagar, Ahmedabad";
        MainImageLink="https://eltornilloquetefalta.files.wordpress.com/2015/10/four-hundred-rabbits-2.jpg";
        CategoryID="1";
        Number="5111175654";
        Rating=4.2f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=500.0;
        home_delivery="false";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="false";
        Address="Shivalik Yash, 132 Feet Ring Road, Opposite BRTS, Naranpura, 132 Feet Ring Rd, Vijaynagar, Naryanpura, Ahmedabad, Gujarat 380013";
        LAT="23.050661";
        LONG="72.554795";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="JW Marriott";
        address="Satellite, Ahmedabad";
        MainImageLink="http://ghar360.com/blogs/wp-content/uploads/165.jpg";
        CategoryID="3";
        Number="";
        Rating=3.3f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=800.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Near Gujarat High Court, S.G.Highway, Sola, Vishwas City 1, Sola, Ahmedabad, Gujarat 380060";
        LAT="23.049483";
        LONG="72.557078";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Cosmopolition By Citizen";
        address="CG Road, Ahmedabad";
        MainImageLink="https://cdn.pursuitist.com/wp-content/uploads/2011/10/Ator-Restaurant-4.jpg";
        CategoryID="1";
        Number="9875878564";
        Rating=5.0f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=800.0;
        home_delivery="true";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="false";
        cardaccepted="false";
        walletaccepted="true";
        Address="Road Rash Go Karting, Opposite Gujrat High Court, SG Highway, Vishwas City 1, Sola, Ahmedabad, Gujarat 382481";
        LAT="23.049528";
        LONG="72.560750";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Lilla Palace";
        address="Uday-Pol, Udaipur";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/736x/f9/f8/38/f9f8384c28ead424fbf9004e625a3a78.jpg";
        CategoryID="4";
        Number="5478578564";
        Rating=4.9f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=800.0;
        home_delivery="false";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="true";
        Address="Opp Zydus Hospital, Sola Over Bridge,, Thaltej, Ahmedabad, Gujarat 380054";
        LAT="23.055176";
        LONG="72.560504";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="China Town";
        address="Malviya Nagar, Jaipur";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/736x/5c/2f/1e/5c2f1e7d2ec283f946848c6b109ecabb.jpg";
        CategoryID="1";
        Number="";
        Rating=0.1f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=1000.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="false";
        walletaccepted="false";
        Address="Arista Building, Sindhu Bhavan Road, Opp HOF, Bodakdev, PRL Colony, Ahmedabad, Gujarat 380054";
        LAT="23.103716";
        LONG="72.533277";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Continential India Ltd";
        address="Malviya Nagar, Jaipur";
        MainImageLink="http://weburbanist.com/wp-content/uploads/2011/02/cafe-hybrids-wash-n-coffee.jpg";
        CategoryID="2";
        Number="4578548569";
        Rating=1.4f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=600.0;
        home_delivery="false";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="false";
        cardaccepted="false";
        walletaccepted="true";
        Address="Opp.Sindhu bhavan, Sindhu Bhavan Road, Bodakdev, PRL Colony, Thaltej, Ahmedabad, Gujarat 380054";
        LAT="23.033831";
        LONG="72.509588";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="The Fern";
        address="Uday Sagar, Jaipur";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/originals/3f/e0/9f/3fe09f5e8e4509f700ec3960e5ea77e1.jpg";
        CategoryID="4";
        Number="5687456985";
        Rating=3.6f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=500.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Near Sindhu Bhavan, Pakvan Bopal Road, Bodakdev, PRL Colony, Thaltej, Bodakdev, Ahmedabad 380054";
        LAT="26.850059";
        LONG="75.773572";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);


        name="Lazy Mojo";
        address="Word Trade Park, Jaipur";
        MainImageLink="http://kinhdoanhcafe.com/wp-content/uploads/2014/08/thiet-ke-noi-that-quan-ca-phe-5-4.jpg";
        CategoryID="3";
        Number="9782832543";
        Rating=1.9f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=990.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Upkar Market, Malviya Nagar, India, Block B, Vidyut Abhiyanta Colony, Malviya Nagar, Jaipur, Rajasthan 302017";
        LAT="26.859160";
        LONG="75.786647";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Coffee Culture";
        address="Gaurav Tower, Jaipur";
        MainImageLink="https://i.ytimg.com/vi/F1Byoq8XLGo/maxresdefault.jpg";
        CategoryID="2";
        Number="";
        Rating=2.3f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=1000.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="false";
        cardaccepted="true";
        walletaccepted="true";
        Address="Upkar Market, Malviya Nagar, India, Block B, Vidyut Abhiyanta Colony, Malviya Nagar, Jaipur, Rajasthan 302017";
        LAT="26.873787";
        LONG="75.797498";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Hotel Patang";
        address="Main City, Ahmedabad";
        MainImageLink="https://reclaimthesoul.files.wordpress.com/2014/05/warm-small-restaurant-interior-design.jpg";
        CategoryID="4";
        Number="7854896542";
        Rating=2.9f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=750.0;
        home_delivery="true";
        Veg="true";
        Parking="false";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="false";
        Address="W.T.P, Jawahar Lal Nehru Marg, D-Block, Milap Nagar, Jaipur, Rajasthan 302017";
        LAT="26.886304";
        LONG="75.804075";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Chatter Box";
        address="MemNagar, Ahmedabad";
        MainImageLink="http://cdn.homedit.com/wp-content/uploads/2012/10/starbucks-coffee-interior.jpg";
        CategoryID="1";
        Number="8878996542";
        Rating=5.0f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=300.0;
        home_delivery="true";
        Veg="false";
        Parking="true";
        Wifi="false";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="G-1, Svc Vinay Building, Opp. Bharat Petroleum, Calgeri Marg, Malviya Nagar, Mauji Colony, Moji Nagar, Malviya Nagar, Jaipur, Rajasthan 302017";
        LAT="26.895140";
        LONG="75.807919";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Tinder Box";
        address="Raja Park, Jaipur";
        MainImageLink="https://s-media-cache-ak0.pinimg.com/originals/73/fc/34/73fc348b0f63fe23374e9339f7bf3e42.jpg";
        CategoryID="3";
        Number="7858964752";
        Rating=2.5f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=900.0;
        home_delivery="true";
        Veg="false";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Taj Lake Palace, Pichola, Udaipur, Rajasthan 313001";
        LAT="24.574965";
        LONG="73.680014";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="ITC RajPutana";
        address="Polo Victory, Jaipur";
        MainImageLink="http://dcbydesignblog.com/wp-content/uploads/2010/03/Counter-Detail.jpg";
        CategoryID="2";
        Number="5487965842";
        Rating=4.7f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=779.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Pichola, Udaipur, Rajasthan 313001";
        LAT="24.579326";
        LONG="73.687335";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Bistro India";
        address="Food Court, World Trade Park, Jaipur";
        MainImageLink="https://d1wb0ukcj65cfk.cloudfront.net/restaurant/a-baker-pda-20150630141806423_lrg.jpg";
        CategoryID="3";
        Number="7788965842";
        Rating=2.0f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=820.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="false";
        walletaccepted="false";
        Address="103, Bhatiayani Chhohata, Bhatiyani Chohatta, Udaipur, Rajasthan 313001";
        LAT="24.576579";
        LONG="73.685238";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Tomatoes ";
        address="SG High Way, Ahmedabad";
        MainImageLink="http://www.prismma.in/wp-content/uploads/theme-restaurant-bikerscafe10.jpg";
        CategoryID="2";
        Number="7412589632";
        Rating=3.0f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=550.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="false";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="false";
        Address="Opp. Jaipur Hospital, Main Tonk Road, Mansingh Pura, Tonk Phatak, Jaipur, Rajasthan 302018";
        LAT="26.907156";
        LONG="75.806236";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="In House Stake";
        address="Manapura, Ahmedabad";
        MainImageLink="http://www.zingyhomes.com/projectImages/cache/29/3d/293d0025f0e242810519b8d9cf22e6f6.jpg";
        CategoryID="1";
        Number="";
        Rating=2.4f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=717.0;
        home_delivery="true";
        Veg="false";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="false";
        walletaccepted="true";
        Address="A-1, Vasundhara Colony, Opp. Kamal and Co, Tonk Phatak, Kirti Nagar, Vasundhara Colony, Tonk Phatak, Jaipur, Rajasthan 302015";
        LAT="26.911997";
        LONG="75.796894";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        name="Shisha Sky Top";
        address="Vadaj, Ahmedabad";
        MainImageLink="http://romadancecontest.com/wp-content/uploads/2016/01/muebles-de-cocina-panama.png";
        CategoryID="4";
        Number="9988556622";
        Rating=4.3f;
        desc="Our Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.";
        avgcst=1110.0;
        home_delivery="true";
        Veg="true";
        Parking="true";
        Wifi="true";
        jainfood="true";
        cardaccepted="true";
        walletaccepted="true";
        Address="Manav Ashram Colony, Tonk Road, Gopal Pura Mod, Manav Ashram Colony, Vasundhara Colony, Gopal Pura Mode, Jaipur, Rajasthan 302015";
        LAT="26.903166";
        LONG="75.793142";
        contentValues.put("name", name);
        contentValues.put(RESTURANTS_COLOUMN_ADDRESS,address);
        contentValues.put(RESTURANTS_COLOUMN_MAINIMAGE,MainImageLink);
        contentValues.put(RESTURANTS_COLOUMN_CATEGORYID,CategoryID);
        contentValues.put(RESTURANTS_COLOUMN_PHONENO,Number);
        contentValues.put(RESTURANTS_COLOUMN_RATING,Rating);
        contentValues.put(RESTURANTS_COLOUMN_Description,desc);
        contentValues.put(RESTURANTS_COLOUMN_AVERAGECOST,avgcst);
        contentValues.put(RESTURANTS_COLOUMN_HOME_DELIVERY,home_delivery);
        contentValues.put(RESTURANTS_COLOUMN_VEGETARIAN,Veg);
        contentValues.put(RESTURANTS_COLOUMN_PARKING,Parking);
        contentValues.put(RESTURANTS_COLOUMN_WIFI,Wifi);
        contentValues.put(RESTURANTS_COLOUMN_SPECIAL_JAIN_FOOD,jainfood);
        contentValues.put(RESTURANTS_COLOUMN_CARD_ACCEPTED,cardaccepted);
        contentValues.put(RESTURANTS_COLOUMN_WALLET_ACCEPTED,walletaccepted);
        contentValues.put(RESTURANTS_COLOUMN_AddressComplete,Address);
        contentValues.put(RESTURANTS_COLOUMN_Address_LAT,LAT);
        contentValues.put(RESTURANTS_COLOUMN_Address_LONG,LONG);
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav,fav);
        db.insert("resturant", null, contentValues);

        ContentValues contentValues1 = new ContentValues();

        String category;
        String category_id;
        String imageLink;
        category="Chinese";
        category_id="1";
        imageLink="https://timeopinions.files.wordpress.com/2013/02/chinesefood.jpg";
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORY, category);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYID,category_id);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYIMAGE,imageLink);
        db.insert(CATEGORIES_TABLE_NAME, null, contentValues1);

        category="Continental";
        category_id="2";
        imageLink="http://www.differencebetween.info/sites/default/files/images/3/continental.jpg";
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORY, category);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYID,category_id);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYIMAGE,imageLink);
        db.insert(CATEGORIES_TABLE_NAME, null, contentValues1);

        category="Mexican";
        category_id="3";
        imageLink="http://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/12/9/0/FNK_Chicken-Chili-and-Cheese-Quesadillas_s4x3.jpg.rend.hgtvcom.966.773.jpeg";
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORY, category);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYID,category_id);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYIMAGE,imageLink);
        db.insert(CATEGORIES_TABLE_NAME, null, contentValues1);

        category="Italian";
        category_id="4";
        imageLink="https://alianosdundee.com/file/2015/12/Italian-Pasta-in-East-Dundee-IL-Alianos-Italian-Food.jpg";
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORY, category);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYID,category_id);
        contentValues1.put(CATEGORIES_COLOUMN_CATEGORYIMAGE,imageLink);
        db.insert(CATEGORIES_TABLE_NAME, null, contentValues1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        db.execSQL("DROP TABLE IF EXISTS resturant");
        db.execSQL("DROP TABLE IF EXISTS categories");
        onCreate(db);
    }

    public boolean insertContact (String name, String phone, String email,String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("password", pass);
        contentValues.put(DETAILS_COLUMN_ADDRESS,"");
        db.insert("contacts", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    public String getName(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select name from contacts where id="+id+"", null );
        String Name="User";
        if (res.moveToFirst()) {
            do {

                Name=res.getString(0);
            } while (res.moveToNext());
        }
        return Name;
    }

    public String getHotelName(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select name from resturant where id="+id+"", null );
        String Name="User";
        if (res.moveToFirst()) {
            do {

                Name=res.getString(0);
            } while (res.moveToNext());
        }
        return Name;
    }


    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DETAILS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String phone, String email,String Address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put(DETAILS_COLUMN_ADDRESS,Address);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateFav (String name, String fav) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESTURANTS_COLOUMN_Address_Fav, fav);
        db.update(RESTURANTS_TABLE_NAME, contentValues, RESTURANTS_COLOUMN_NAME+"=\""+name+"\"",null);
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(DETAILS_TABLE_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<Resturant> getAllResturants() {
        ArrayList<Resturant> array_list = new ArrayList<Resturant>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select id,name,address,imagelink,category_id,number,rating,desc,avgcst,homedelivery," +
                "veg,parking,wifi,jainfood,cardaccepted,walletaccepted,addresscomplete,LAT,LONG,fav from resturant", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Integer id=cursor.getInt(0);
                String Name=cursor.getString(1);
                String address=cursor.getString(2);
                String imageLink=cursor.getString(3);
                String category_id=cursor.getString(4);
                String number=cursor.getString(5);
                Float rating=cursor.getFloat(6);
                String desc=cursor.getString(7);
                Double avgcst=cursor.getDouble(8);
                String Homedelivery=cursor.getString(9);
                String veg=cursor.getString(10);
                String parking=cursor.getString(11);
                String wifi=cursor.getString(12);
                String jainfood=cursor.getString(13);
                String cardacccept=cursor.getString(14);
                String wallet=cursor.getString(15);
                String addresscomplete=cursor.getString(16);
                String LAT=cursor.getString(17);
                String LONG=cursor.getString(18);
                String fav=cursor.getString(19);

                Resturant mResturant= new Resturant(id,Name,address,imageLink,category_id,number,rating,desc,avgcst,
                        Homedelivery,veg,parking,wifi,jainfood,cardacccept,wallet,addresscomplete,LAT,LONG,fav);
                // Adding contact to list
                array_list.add(mResturant);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public ArrayList<Resturant> getDataCategoryID(String id) {
        ArrayList<Resturant> array_list = new ArrayList<Resturant>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select name,address,imagelink,category_id,number,rating,desc,avgcst,homedelivery," +
                "veg,parking,wifi,jainfood,cardaccepted,walletaccepted,addresscomplete,LAT,LONG,fav from resturant where category_id=\""+id+"\"", null );
        if (cursor.moveToFirst()) {
            do {
                String Name=cursor.getString(0);
                String address=cursor.getString(1);
                String imageLink=cursor.getString(2);
                String category_id=cursor.getString(3);
                String number=cursor.getString(4);
                Float rating=cursor.getFloat(5);
                String desc=cursor.getString(6);
                Double avgcst=cursor.getDouble(7);
                String Homedelivery=cursor.getString(8);
                String veg=cursor.getString(9);
                String parking=cursor.getString(10);
                String wifi=cursor.getString(11);
                String jainfood=cursor.getString(12);
                String cardacccept=cursor.getString(13);
                String wallet=cursor.getString(14);
                String addresscomplete=cursor.getString(15);
                String LAT=cursor.getString(16);
                String LONG=cursor.getString(17);
                String fav=cursor.getString(18);

                Resturant mResturant= new Resturant(Name,address,imageLink,category_id,number,rating,desc,avgcst,
                        Homedelivery,veg,parking,wifi,jainfood,cardacccept,wallet,addresscomplete,LAT,LONG,fav);

                // Adding contact to list
                array_list.add(mResturant);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public ArrayList<Resturant> getDataFav(String id) {
        ArrayList<Resturant> array_list = new ArrayList<Resturant>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select name,address,imagelink,category_id,number,rating,desc,avgcst,homedelivery," +
                "veg,parking,wifi,jainfood,cardaccepted,walletaccepted,addresscomplete,LAT,LONG,fav from resturant where fav=\""+id+"\"", null );
        if (cursor.moveToFirst()) {
            do {
                String Name=cursor.getString(0);
                String address=cursor.getString(1);
                String imageLink=cursor.getString(2);
                String category_id=cursor.getString(3);
                String number=cursor.getString(4);
                Float rating=cursor.getFloat(5);
                String desc=cursor.getString(6);
                Double avgcst=cursor.getDouble(7);
                String Homedelivery=cursor.getString(8);
                String veg=cursor.getString(9);
                String parking=cursor.getString(10);
                String wifi=cursor.getString(11);
                String jainfood=cursor.getString(12);
                String cardacccept=cursor.getString(13);
                String wallet=cursor.getString(14);
                String addresscomplete=cursor.getString(15);
                String LAT=cursor.getString(16);
                String LONG=cursor.getString(17);
                String fav=cursor.getString(18);

                Resturant mResturant= new Resturant(Name,address,imageLink,category_id,number,rating,desc,avgcst,
                        Homedelivery,veg,parking,wifi,jainfood,cardacccept,wallet,addresscomplete,LAT,LONG,fav);

                // Adding contact to list
                array_list.add(mResturant);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> array_list = new ArrayList<Category>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select category,categoryid,categoryimage from categories", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String Name=cursor.getString(0);
                String category_id=cursor.getString(1);
                String imageLink=cursor.getString(2);
                Category mCategory= new Category(Name,category_id,imageLink);

                // Adding contact to list
                array_list.add(mCategory);
            } while (cursor.moveToNext());
        }
        return array_list;
    }


    public ArrayList<details> getDataEmail(String email) {
        ArrayList<details> array_list = new ArrayList<details>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where email=\""+email+"\"",null);
        if (res.moveToFirst()) {
            do {
                int id=res.getInt(0);
                String Name=res.getString(1);
                String Phone=res.getString(2);
                String email1=res.getString(3);
                String pass=res.getString(4);
                details contact = new details(id,Name,Phone,email1,pass);

                // Adding contact to list
                array_list.add(contact);
            } while (res.moveToNext());
        }
        return array_list;
    }

    public ArrayList<details> getAllContactsID() {
        ArrayList<details> array_list = new ArrayList<details>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select email,password from contacts", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String Name=cursor.getString(0);
                String Phone=cursor.getString(1);
                details contact = new details(Name,Phone);

                // Adding contact to list
                array_list.add(contact);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public String getfavDetail(String Name) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select fav from resturant where name=\""+Name+"\"", null );
        String fav="true";
        if (cursor.moveToFirst()) {
            do {
                fav=cursor.getString(0);

            } while (cursor.moveToNext());
        }
        return fav;
    }

    public ArrayList<details> getAllContactsPhone() {
        ArrayList<details> array_list = new ArrayList<details>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select phone from contacts", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String Phone=cursor.getString(0);
                details contact = new details(Phone);
                // Adding contact to list
                array_list.add(contact);
            } while (cursor.moveToNext());
        }
        return array_list;
    }
    public void insertingResturantData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public boolean insertReview (Integer restid, Integer userid, Float star,String review_title,String review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESTURANTS_REVIEW_COLOUMN_RESUTRANT_ID, restid);
        contentValues.put(RESTURANTS_REVIEW_COLOUMN_REIVEW_USER_ID, userid);
        contentValues.put(RESTURANTS_REVIEW_COLOUMN_REVIEW_STAR, star);
        contentValues.put(RESTURANTS_REVIEW_COLOUMN_REVIEW_TITLE,review_title);
        contentValues.put(RESTURANTS_REVIEW_COLOUMN_REVIEW_COMPLETE,review);
        db.insert(RESTURANTS_REVIEW_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean insertRating (Integer restid,Float rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESTURANTS_COLOUMN_RATING, rating);
        db.update(RESTURANTS_TABLE_NAME, contentValues, RESTURANTS_COLOUMN_ID+"=\""+restid+"\"",null);
        return true;
    }

    public ArrayList<Review> getReview(Integer HotelID) {

        ArrayList<Review> array_list = new ArrayList<Review>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select user_id,star,review_title,review_complete from review where resturant_id=\""+HotelID+"\"", null );

        if (cursor.moveToFirst()) {
            do {
                Integer user_id=cursor.getInt(0);
                float star=cursor.getFloat(1);
                String review_title=cursor.getString(2);
                String review=cursor.getString(3);
                Review contact = new Review(user_id,star,review_title,review);
                // Adding contact to list
                array_list.add(contact);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public ArrayList<Resturant> getAllResturantsRatingDesc() {
        ArrayList<Resturant> array_list = new ArrayList<Resturant>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select id,name,address,imagelink,category_id,number,rating,desc,avgcst,homedelivery," +
                "veg,parking,wifi,jainfood,cardaccepted,walletaccepted,addresscomplete,LAT,LONG,fav from resturant ORDER BY rating DESC", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Integer id=cursor.getInt(0);
                String Name=cursor.getString(1);
                String address=cursor.getString(2);
                String imageLink=cursor.getString(3);
                String category_id=cursor.getString(4);
                String number=cursor.getString(5);
                Float rating=cursor.getFloat(6);
                String desc=cursor.getString(7);
                Double avgcst=cursor.getDouble(8);
                String Homedelivery=cursor.getString(9);
                String veg=cursor.getString(10);
                String parking=cursor.getString(11);
                String wifi=cursor.getString(12);
                String jainfood=cursor.getString(13);
                String cardacccept=cursor.getString(14);
                String wallet=cursor.getString(15);
                String addresscomplete=cursor.getString(16);
                String LAT=cursor.getString(17);
                String LONG=cursor.getString(18);
                String fav=cursor.getString(19);

                Resturant mResturant= new Resturant(id,Name,address,imageLink,category_id,number,rating,desc,avgcst,
                        Homedelivery,veg,parking,wifi,jainfood,cardacccept,wallet,addresscomplete,LAT,LONG,fav);
                // Adding contact to list
                array_list.add(mResturant);
            } while (cursor.moveToNext());
        }
        return array_list;
    }

    public ArrayList<Resturant> getAllResturantsAverageCostAsc() {
        ArrayList<Resturant> array_list = new ArrayList<Resturant>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select id,name,address,imagelink,category_id,number,rating,desc,avgcst,homedelivery," +
                "veg,parking,wifi,jainfood,cardaccepted,walletaccepted,addresscomplete,LAT,LONG,fav from resturant ORDER BY avgcst ASC", null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Integer id=cursor.getInt(0);
                String Name=cursor.getString(1);
                String address=cursor.getString(2);
                String imageLink=cursor.getString(3);
                String category_id=cursor.getString(4);
                String number=cursor.getString(5);
                Float rating=cursor.getFloat(6);
                String desc=cursor.getString(7);
                Double avgcst=cursor.getDouble(8);
                String Homedelivery=cursor.getString(9);
                String veg=cursor.getString(10);
                String parking=cursor.getString(11);
                String wifi=cursor.getString(12);
                String jainfood=cursor.getString(13);
                String cardacccept=cursor.getString(14);
                String wallet=cursor.getString(15);
                String addresscomplete=cursor.getString(16);
                String LAT=cursor.getString(17);
                String LONG=cursor.getString(18);
                String fav=cursor.getString(19);

                Resturant mResturant= new Resturant(id,Name,address,imageLink,category_id,number,rating,desc,avgcst,
                        Homedelivery,veg,parking,wifi,jainfood,cardacccept,wallet,addresscomplete,LAT,LONG,fav);
                // Adding contact to list
                array_list.add(mResturant);
            } while (cursor.moveToNext());
        }
        return array_list;
    }
}
