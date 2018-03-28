package com.example.sander.structure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String mTitle;
    private Date mLast_date;

    public Task() {

    }

    public Task(String title, Date last_date)
    {
        this.mTitle = title;
        this.mLast_date = last_date;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getmLast_date() {

        return mLast_date;
    }

    public String getStringmLast_date() {

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd/MM/yyyy");
        String stringDate = sdf.format(mLast_date);

        return stringDate;
    }
}
