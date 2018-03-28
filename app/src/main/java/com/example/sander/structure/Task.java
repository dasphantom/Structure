package com.example.sander.structure;

import java.util.Date;

public class Task {
    private String mTitle, mLast_date;

    public Task() {

    }

    public Task(String title, String last_date)
    {
        this.mTitle = title;
        this.mLast_date = last_date;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmLast_date() {
        return mLast_date;
    }
}
