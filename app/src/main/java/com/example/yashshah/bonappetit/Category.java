package com.example.yashshah.bonappetit;

/**
 * Created by Yash shah on 30-06-2017.
 */

public class Category {
    String CategoryName;
    String CategoryID;
    String CategoryImageLink;

    Category (String CategoryName,
            String CategoryID,
            String CategoryImageLink)
    {
        this.CategoryName=CategoryName;
        this.CategoryID=CategoryID;
        this.CategoryImageLink=CategoryImageLink;
    }

    public String getCategoryName() {
        return this.CategoryName;
    }

    public String getCategoryID() {
        return this.CategoryID;
    }

    public String getCategoryImageLink() {
        return this.CategoryImageLink;
    }
}
