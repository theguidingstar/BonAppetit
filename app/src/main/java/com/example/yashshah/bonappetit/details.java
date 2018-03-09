package com.example.yashshah.bonappetit;

/**
 * Created by Yash shah on 19-06-2017.
 */

public class details {
    String image;
    String hotel_name;
    String type;

    String Name;
    String Phone;
    String PhoneNo;
    String email;
    String pass;
    int id;
    String Address;
    Float rating;


    public details(String image,
            String hotel_name,
            Float rating,String Address)
    {
        this.image=image;
        this.hotel_name=hotel_name;
        this.rating=rating;
        this.Address=Address;
    }

    public details(String Name,String Phone)
    {
        this.Name=Name;
        this.Phone=Phone;
    }

    public details(int id,String Name,String Phone,String email,String pass)
    {
        this.id=id;
        this.Name=Name;
        this.Phone=Phone;
        this.email=email;
        this.pass=pass;
    }

    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPass() {
        return this.pass;
    }
    public String getAddress() {
        return this.Address;
    }
    public Float getRating() {
        return this.rating;
    }
    public details(String PhoneNO)
    {
        this.PhoneNo=PhoneNO;
    }
    public String getName() {
        return this.Name;
    }
    public String getPhone() {
        return this.Phone;
    }
    public String getPhoneNo() {
        return this.PhoneNo;
    }



    public String getImage() {
        return this.image;
    }
    public String getHotel_name() {
        return this.hotel_name;
    }
    public String getType() {
        return this.type;
    }

}
