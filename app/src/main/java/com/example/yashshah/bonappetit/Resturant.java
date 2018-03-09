package com.example.yashshah.bonappetit;

/**
 * Created by Yash shah on 29-06-2017.
 */

public class Resturant {
    String Name;
    String Address;
    String ImageLink;
    String CategoryID;
    String Phoneno;
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
    String addresscomplete;
    String LAT;
    String LONG;
    String fav;
    Integer id;

    public Integer getId() {
        return id;
    }

    public String getFav() {
        return fav;
    }

    public String getDesc() {
        return this.desc;
    }

    public Double getAvgcst() {
        return this.avgcst;
    }

    public String getHome_delivery() {
        return this.home_delivery;
    }

    public String getVeg() {
        return this.Veg;
    }

    public String getParking() {
        return this.Parking;
    }

    public String getWifi() {
        return this.Wifi;
    }

    public String getJainfood() {
        return this.jainfood;
    }

    public String getCardaccepted() {
        return this.cardaccepted;
    }

    public String getWalletaccepted() {
        return this.walletaccepted;
    }

    public String getAddresscomplete() {
        return this.addresscomplete;
    }

    public String getLAT() {
        return this.LAT;
    }

    public String getLONG() {
        return this.LONG;
    }

    Resturant (String Name,String Address,String ImageLink,String CategoryID,String Phoneno,Float Rating)
    {
        this.Name=Name;
        this.Address=Address;
        this.ImageLink=ImageLink;
        this.CategoryID=CategoryID;
        this.Phoneno=Phoneno;
        this.Rating=Rating;

    }

    Resturant (Integer id,String Name,String Address,String ImageLink,String CategoryID,String Phoneno,Float Rating,String desc,
               Double avgcst,String home_delivery,String Veg,String Parking,String Wifi,String jainfood,String cardaccepted
                ,String walletaccepted,String addresscomplete,String LAT,String LONG,String fav)
    {
        this.id=id;
        this.Name=Name;
        this.Address=Address;
        this.ImageLink=ImageLink;
        this.CategoryID=CategoryID;
        this.Phoneno=Phoneno;
        this.Rating=Rating;
        this.desc=desc;
        this.avgcst=avgcst;
        this.home_delivery=home_delivery;
        this.Veg=Veg;
        this.Parking=Parking;
        this.Wifi=Wifi;
        this.jainfood=jainfood;
        this.cardaccepted=cardaccepted;
        this.walletaccepted=walletaccepted;
        this.addresscomplete=addresscomplete;
        this.LAT=LAT;
        this.LONG=LONG;
        this.fav=fav;
    }

    Resturant (String Name,String Address,String ImageLink,String CategoryID,String Phoneno,Float Rating,String desc,
               Double avgcst,String home_delivery,String Veg,String Parking,String Wifi,String jainfood,String cardaccepted
            ,String walletaccepted,String addresscomplete,String LAT,String LONG,String fav)
    {
        this.Name=Name;
        this.Address=Address;
        this.ImageLink=ImageLink;
        this.CategoryID=CategoryID;
        this.Phoneno=Phoneno;
        this.Rating=Rating;
        this.desc=desc;
        this.avgcst=avgcst;
        this.home_delivery=home_delivery;
        this.Veg=Veg;
        this.Parking=Parking;
        this.Wifi=Wifi;
        this.jainfood=jainfood;
        this.cardaccepted=cardaccepted;
        this.walletaccepted=walletaccepted;
        this.addresscomplete=addresscomplete;
        this.LAT=LAT;
        this.LONG=LONG;
        this.fav=fav;
    }
    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public Float getRating() {
        return Rating;
    }
}
