package com.example.yashshah.bonappetit;

/**
 * Created by Yash shah on 14-06-2017.
 */

public class contactdetail {
    private String Name;
    private String number;


    public contactdetail(String Name, String number) {
        this.Name = Name;
        this.number = number;
    }

    public String getName() {
        return this.Name;
    }

    public String getNumber() {
        return this.number;
    }

}
