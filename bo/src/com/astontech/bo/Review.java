package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBO {

    //region PROPERTIES

    private int reviewId;
    private Date reviewDate;

    //endregion

    //region CONSTRUCTORS

    public Review(){}

    public Review(int reviewId) {
        this.reviewId = reviewId;
    }

    public Review(int reviewId, Date reviewDate) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
    }

    //endregion

    //region GETTERS SETTERS

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    //endregion

}
