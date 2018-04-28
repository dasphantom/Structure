package com.example.sander.structure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private String mTitle;
    private Long mLast_date;
    private String mCategory;



    public Task() {

    }

    public Task( String title, Long last_date, String category)
    {

        this.mTitle = title;
        this.mLast_date = last_date;
        this.mCategory = category;
    }

    public String getmTitle() {

        return mTitle;
    }

    public Long getmLast_date() {

        return mLast_date;
    }

    public String getmCategory() {
        return mCategory;
    }
}
