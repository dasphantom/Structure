package com.example.sander.structure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String mTitle;
    private Long mLast_date;

    public Task() {

    }

    public Task(String title, Long last_date)
    {
        this.mTitle = title;
        this.mLast_date = last_date;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Long getmLast_date() {

        return mLast_date;
    }

    /**public Long getStringmLast_date() {

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd/MM/yyyy");
        String stringDate = sdf.format(mLast_date);

        return stringDate;
    }
     */
}
