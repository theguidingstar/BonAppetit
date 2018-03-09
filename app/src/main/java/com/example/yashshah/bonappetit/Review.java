package com.example.yashshah.bonappetit;

/**
 * Created by Yash shah on 06-07-2017.
 */

public class Review {
    Integer user_id;
    float star;
    String review_title;
    String review;

    Review(Integer user_id,
            float star,
            String review_title,
            String review)
    {
        this.user_id=user_id;
        this.star=star;
        this.review_title=review_title;
        this.review=review;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public float getStar() {
        return star;
    }

    public String getReview_title() {
        return review_title;
    }

    public String getReview() {
        return review;
    }
}
